import java.util.concurrent.Executor
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.time.Duration

class ExecutorWithShutdown(private val executor: Executor) {
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()
    private var shutdown = false
    private var nOfPendingCommands = 0

    @Throws(RejectedExecutionException::class)
    fun execute(command: Runnable): Unit {
        lock.withLock{
            if (shutdown) throw RejectedExecutionException("Executor is shut down")
            nOfPendingCommands++
            val r = {
                try {
                    command.run()
                } finally {
                    decrementeNOfPendingCommands()
                }
            }
            executor.execute(r)
        }
    }

    private fun decrementeNOfPendingCommands(): Unit {
        lock.withLock {
            nOfPendingCommands--
        }
    }

    fun shutdown(): Unit {
        shutdown = true
        condition.signalAll()
    }

    @Throws(InterruptedException::class)
    fun awaitTermination(timeout: Duration): Boolean {
        lock.withLock {
            // fast path
            if (shutdown && nOfPendingCommands == 0) return true

            var remainingNanos = timeout.inWholeNanoseconds
            while (true) {
                try {
                    remainingNanos = condition.awaitNanos(remainingNanos)
                } catch (e: InterruptedException) {
                    if (shutdown && nOfPendingCommands == 0) {
                        Thread.currentThread().interrupt()
                        return true
                    }
                    throw e
                }
                if (shutdown && nOfPendingCommands == 0) return true
                if (remainingNanos <= 0) return false
            }
        }
    }
}
