import java.util.*
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.time.Duration

class Semaphore(private val initialUnits: Int) {

    init {
        require(initialUnits >= 0) { "Initial units must be non-negative" }
    }

    private var availableUnits = initialUnits
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()
    private var shutdown = false

    fun release() = lock.withLock {
        availableUnits++
        condition.signal()
    }


    @Throws(InterruptedException::class, RejectedExecutionException::class)
    fun acquire(timeout: Duration): Boolean = lock.withLock {
        var remainingNanos = timeout.inWholeNanoseconds
        while (availableUnits <= 0) {
            if (shutdown) throw RejectedExecutionException("Semaphore has been shut down")
            if (remainingNanos <= 0) {
                // No need to propagate signal because `availableUnits <= 0` is true
                return false
            }
            try {
                remainingNanos = condition.awaitNanos(remainingNanos)
            } catch (e: InterruptedException) {
                /*
                 * Not needed really needed due to
                 *  "An implementation can favor responding to an interrupt over normal method return in response
                 *  to a signal. In that case the implementation must ensure that the signal is redirected to another
                 *  waiting thread, if there is one."
                 */
                if (availableUnits > 0) {
                    condition.signal()
                }
                throw e
            }
        }
        if (shutdown) throw RejectedExecutionException("Semaphore has been shut down")
        availableUnits -= 1
        return true
    }

    fun shutdown(): Unit = lock.withLock {
        shutdown = true
        availableUnits = initialUnits
        condition.signalAll()
    }

    @Throws(InterruptedException::class)
    fun awaitTermination(timeout: Duration): Boolean {
        lock.withLock {
            // fast path
            if (shutdown && availableUnits == initialUnits) return true

            var remainingNanos = timeout.inWholeNanoseconds
            while (true) {
                try {
                    remainingNanos = condition.awaitNanos(remainingNanos)
                } catch (e: InterruptedException) {
                    if (shutdown && availableUnits == initialUnits) {
                        Thread.currentThread().interrupt()
                        shutdown = false
                        return true
                    }
                    throw e
                }
                if (shutdown && availableUnits == initialUnits) return true
                if (remainingNanos <= 0) {
                    return false
                }
            }
        }
    }
}