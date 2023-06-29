import java.util.LinkedList
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.time.Duration

class MessageQueue<T>() {

    private class Request<T>(
        val nOfMessages: Int,
        val condition: Condition,
        val messages: List<T>
    ) { }

    private val lock = ReentrantLock()
    private val messageQueue = mutableListOf<T>()
    private val requestQueue = LinkedList<Request<T>>()

    fun enqueue(message: T): Unit {
        lock.withLock {
            messageQueue.add(message)
        }
    }

    @Throws(InterruptedException::class)
    fun tryDequeue(nOfMessages: Int, timeout: Duration): List<T>? {
        require(nOfMessages > 0) { "nOfMessages must be greater than 0" }
        lock.withLock {
            val messages = mutableListOf<T>()

            // fast path
            if (requestQueue.isEmpty() && messageQueue.size >= nOfMessages) {
                repeat(nOfMessages) {
                    messages.add(messageQueue.removeFirst())
                }
                return messages
            }

            // wait path
            var remainingNanos = timeout.inWholeNanoseconds
            val localRequest = Request(nOfMessages, lock.newCondition(), messages)
            requestQueue.add(localRequest)
            while (true) {
                try {
                    remainingNanos = localRequest.condition.awaitNanos(remainingNanos)
                } catch (e: InterruptedException) {
                    if (messageQueue.size >= localRequest.nOfMessages) {
                        Thread.currentThread().interrupt()
                        repeat(nOfMessages) {
                            messages.add(messageQueue.removeFirst())
                        }
                        requestQueue.remove(localRequest)
                        return messages
                    }
                    requestQueue.remove(localRequest)
                    throw e
                }
                if (messageQueue.size >= localRequest.nOfMessages) {
                    requestQueue.remove(localRequest)
                    repeat(nOfMessages) {
                        messages.add(messageQueue.removeFirst())
                    }
                    return messages
                }
                if (remainingNanos <= 0) {
                    // timeout
                    requestQueue.remove(localRequest)
                    return null
                }
            }
        }

    }
}