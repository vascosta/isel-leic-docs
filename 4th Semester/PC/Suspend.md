# ___Suspend___

* Função que pode ser suspensa e retomada posteriormente
* Só podem ser chamadas por outras suspending functions ou numa coroutine

---

## __CoroutineScope__
* Define o scope das coroutines
* Todos os coroutine builders são extensão de CoroutineScope (à exceção de runBlocking), e herdam automaticamente o contexto.

---

## ___CoroutineContext___
* Conjunto de elementos, usados para influenciar a execução de uma coroutine
* Pode-se mudar o contexto de uma coroutine através do método withContext

## ___launch___
* Coroutine builder
* Lança uma nova coroutine concorrentemente com o resto do código.
```kotlin
launch {
    // código
}
```	

---

## ___runBlocking___
* Coroutine builder
* Bloqueia a thread onde é chamado
* Cria um CoroutineScope
* Thread bloqueada até todas as coroutines dentro do CoroutineScope terminarem
```kotlin
runBlocking {
    // código
}
```

---

## ___delay___
* Suspending function
* Suspende a coroutine por um tempo especificado
* Semelhante ao Thread.sleep
```kotlin
launch {
    delay(1000)
}
```

---

## ___coroutineScope___
* Fornece um CoroutineScope
* Semelhante ao runBlocking, só que não bloqueia a thread, apenas suspende
* Outra diferença é q é uma suspending function
```kotlin	
coroutineScope {
    // código
}
```

---

## ___suspendCoroutine___
* Obtém a continuação da mesma, e suspende a coroutine até esta ser retomada
* Cria um ponto de suspensão
* ``Continuation.resume`` e ``Continuation.resumeWithException`` são utilizadas para retomar a coroutine
```kotlin
suspendCoroutine<Tipo> { continuation ->
    // código
}
```


## ___suspendCancellableCoroutine___
* Suspende a coroutine como o método acima, mas fornecendo uma ``CancellableContinuation``
* Uma continuação é single-shot, significando que só é executada uma vez
```kotlin
try {
    suspendCancellableCoroutine<Tipo> { continuation ->
        // código
    }
} catch (ex: CancellationException) {
    // código
}
```

---

__E.g.__:
```kotlin
class SuspendableCountDownLatch(
    initialCount: Int,
) {
    private var count: Int = initialCount
    private var continuationList = mutableListOf<Continuation<Unit>>()
    private val lock = ReentrantLock()

    fun countDown() {
        var continuationListToResume: List<Continuation<Unit>>? = null
        lock.withLock {
            if (count == 0) {
                return@withLock
            }
            count -= 1
            if (count == 0) {
                continuationListToResume = continuationList.toList()
                continuationList.clear()
            }
        }
        continuationListToResume?.forEach {
            it.resume(Unit)
        }
    }

    suspend fun await() {
        suspendCoroutine<Unit> { continuation ->
            lock.withLock {
                if (count == 0) {
                    continuation.resume(Unit)
                } else {
                    continuationList.add(continuation)
                }
            }
        }
    }
}
```