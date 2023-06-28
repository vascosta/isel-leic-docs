# __Sincronizadores__

## __Monitor-Style__
* A thread que altera o estado cria condições para a outra prosseguir, e sinaliza
* A outra thread é que realiza a sua mudança de estado

---

## ___Kernel-Style___
* A thread que altera o estado e cria condições para a outra prosseguir, realiza o que a outra pretender fazer e sinaliza.

---

## __ReentrantLock__

```kotlin
private val lock = ReentrantLock()
```

---

## __Condition__

```kotlin
private val condition = lock.newCondition()

// Espera passiva, sem a posse do lock, até que a condição seja sinalizada ou que a thread seja interrompida
condition.await()

// Igual ao anterior, mas recupera a posse do lock passado timeout nanosegundos
condition.awaitNanos(timeout: Long)

// Sinaliza uma thread à espera da condição
condition.signal()

// Sinaliza todas as threads que estavam à espera
condition.signalAll()
```

---

## __Sincronizadores__

### ___Semaphore___
* Usado para restringir o acesso da thread a algum recurso
* Tem um __contador__ inicializado com um __número de unidades__
* __Métodos__:
    * ``acquire`` $ \rightarrow $ __espera__ até que uma unidade esteja disponível e __decrementa__ o __contador__
    * ``release`` $ \rightarrow $ __incrementa__ o __contador__
* Pode ser ___fair___ ou ___unfair___, sendo que fair implementa a topologia __FIFO__

__E.g.__:


```kotlin
class NArySemaphoreUsingFifoAndKernelStyle(
    initialUnits: Int,
) {
    init {
        require(initialUnits > 0) { "Number of initial units must be greater than zero" }
    }

    private class Request(
        val requestedUnits: Int,
        val condition: Condition,
        var isDone: Boolean = false,
    )

    private var availableUnits = initialUnits
    private val queue = NodeLinkedList<Request>()
    private val lock = ReentrantLock()

    fun release(releasedUnits: Int) {
        require(releasedUnits > 0) { "releasedUnits must be greater than zero" }
        lock.withLock {
            availableUnits += releasedUnits
            completeAll()
        }
    }

    @Throws(InterruptedException::class)
    fun acquire(requestedUnits: Int, timeout: Duration): Boolean {
        require(requestedUnits > 0) { "requestedUnits must be greater than zero" }
        lock.withLock {
            if (queue.empty && availableUnits >= requestedUnits) {
                availableUnits -= requestedUnits
                return true
            }
            var remainingNanos = timeout.inWholeNanoseconds
            val localRequest = queue.enqueue(Request(requestedUnits, lock.newCondition()))
            while (true) {
                try {
                    remainingNanos = localRequest.value.condition.awaitNanos(remainingNanos)
                } catch (e: InterruptedException) {
                    if (localRequest.value.isDone) {
                        Thread.currentThread().interrupt()
                        return true
                    }
                    queue.remove(localRequest)
                    completeAll()
                    throw e
                }
                if (localRequest.value.isDone) {
                    return true
                }
                if (remainingNanos <= 0) {
                    queue.remove(localRequest)
                    completeAll()
                    return false
                }
            }
        }
    }

    private fun completeAll() {
        while (queue.headCondition { availableUnits >= it.requestedUnits }) {
            val request = queue.pull().value
            availableUnits -= request.requestedUnits
            request.condition.signal()
            request.isDone = true
        }
    }
}
```

---

### ___Exchanger___
* Ponto de sincronização onde threads emparelham e trocam valores
* Único método ``exchange(T value)``, que __espera__ até que outra thread queira __trocar um valor__, ou troca se alguma __já estiver à espera__.

__E.g.__:

```kotlin
class NAryExchanger<T>(private val groupSize: Int) {
    private val lock = ReentrantLock()
    private var currentRequest: Request<T> = Request(lock.newCondition())

    init {
        require(groupSize >= 2) { "groupSize must be greater or equal to 2" }
    }

    private class Request<R>(
        val condition: Condition,
        var list: MutableList<R> = mutableListOf()
    )

    /**
     * Method that allows threads to exchange data with other threads in groups of [groupSize]
     * The threads that exchange data are blocked until the group is complete
     * If the group is not complete after the specified [timeout], the threads are unblocked and the method returns null
     * If the group is complete, the threads are unblocked and the method returns the list of exchanged data
     * @throws InterruptedException if the thread is interrupted while waiting for the group to be complete
     * @throws IllegalArgumentException if the timeout is negative
     */
    @Throws(InterruptedException::class)
    fun exchange(value: T, timeout: Duration): List<T>? {
        require(timeout >= Duration.ZERO) { "timeout must be greater or equal to 0" }
        lock.withLock {
            val localRequest = currentRequest

            // fast path: group gets filled
            if (localRequest.list.size == groupSize - 1) {
                localRequest.list.add(value)
                val group = localRequest.list.toList()
                localRequest.condition.signalAll() // wake up all threads
                currentRequest = Request(lock.newCondition()) // create new request
                return group
            }

            // wait path: wait for group to be filled
            localRequest.list.add(value)
            var remainingNanos = timeout.inWholeNanoseconds
            while (true) {
                try {
                    remainingNanos = localRequest.condition.awaitNanos(remainingNanos)
                } catch (e: InterruptedException) {
                    if (localRequest.list.size == groupSize) { // prioritize group completion over interruption
                        Thread.currentThread().interrupt() // restore interrupt status
                        return localRequest.list.toList()
                    }
                    localRequest.list.remove(value)
                    throw InterruptedException() // rethrow exception
                }
                if (localRequest.list.size == groupSize) { // group completion
                    return localRequest.list.toList()
                }
                if (remainingNanos <= 0) { // timeout
                    localRequest.list.remove(value)
                    return null
                }
            }
        }
    }
}
```

---

### ___Thread Pool___
* Coleção de worker threads que executam computações assíncronas;
* Usada para reduzir o número de threads da aplicação;
* Em Java, a classe Executors é uma factory para Thread Pools;
* A interface Executor tem um único método para submeter instâncias Runnable para execução: execute(Runnable runnable).

__E.g.__:

```kotlin
class SimpleThreadPool(
    private val maxThreads: Int,
) {

    private val lock = ReentrantLock()
    private val workItems = NodeLinkedList<Runnable>()
    private var nOfWorkerThreads = 0

    fun execute(workItem: Runnable): Unit = lock.withLock {
        if (nOfWorkerThreads < maxThreads) {
            // create a new worker
            nOfWorkerThreads += 1
            Thread {
                workerLoop(workItem)
            }.start()
        } else {
            workItems.enqueue(workItem)
        }
    }

    private fun getNextWorkItem(): GetWorkItemResult = lock.withLock {
        return if (workItems.notEmpty) {
            GetWorkItemResult.WorkItem(workItems.pull().value)
        } else {
            nOfWorkerThreads -= 1
            GetWorkItemResult.Exit
        }
    }

    sealed class GetWorkItemResult {
        object Exit : GetWorkItemResult()
        class WorkItem(val workItem: Runnable) : GetWorkItemResult()
    }

    // Does NOT hold the lock
    private fun workerLoop(firstRunnable: Runnable) {
        var currentRunnable = firstRunnable
        while (true) {
            safeRun(currentRunnable)
            currentRunnable = when (val result = getNextWorkItem()) {
                is GetWorkItemResult.WorkItem -> result.workItem
                GetWorkItemResult.Exit -> return
            }
        }
    }
}
```