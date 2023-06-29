import java.util.concurrent.Executor
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.time.Duration

class ExecutorWithShutdown(private val executor: Executor) {
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()
    private var shutdown = false

    @Throws(RejectedExecutionException::class)
    fun execute(command: Runnable): Unit {
        if (shutdown) throw RejectedExecutionException("Executor is shut down")
        executor.execute(command)
    }

    fun shutdown(): Unit {
        shutdown = true
    }

    @Throws(InterruptedException::class)
    fun awaitTermination(timeout: Duration): Boolean {
        lock.withLock {
            // fast path
            if (shutdown) return true

            var remainingNanos = timeout.inWholeNanoseconds
            while (true) {
                try {
                    remainingNanos = condition.awaitNanos(remainingNanos)
                } catch (e: InterruptedException) {
                    if (shutdown) {
                        Thread.currentThread().interrupt()
                        return true
                    }
                    throw e
                }
                if (shutdown) return true
                if (remainingNanos <= 0) return false
            }
        }
    }
}
