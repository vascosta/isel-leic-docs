import java.util.LinkedList
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.time.Duration

class MessageQueue<T> {

    private class EnqueueRequest<T> (
        val message: T,
        val condition: Condition,
    )

    private class DequeueRequest<T> (
        val nOfMessages: Int,
        val condition: Condition,
        val messages : MutableList<T> = mutableListOf(),
        val thread: Thread
    )

    private val messageQueue = LinkedList<T>()
    private val enqueueRequestQueue = LinkedList<EnqueueRequest<T>>()
    private val dequeueRequestQueue = LinkedList<DequeueRequest<T>>()
    private val lock = ReentrantLock()

    @Throws(InterruptedException::class)
    fun tryEnqueue(message: T, timeout: Duration): Thread? {
        lock.withLock {
            if (enqueueRequestQueue.isEmpty() && dequeueRequestQueue.isNotEmpty()
                && dequeueRequestQueue.first().messages.size < dequeueRequestQueue.first().nOfMessages) {
                dequeueRequestQueue.first().messages.add(message)
                return dequeueRequestQueue.first().thread
            }

            // wait path
            var remainingNanos = timeout.inWholeNanoseconds
            val localRequest = EnqueueRequest(message, lock.newCondition())
            enqueueRequestQueue.add(EnqueueRequest(message, lock.newCondition()))
            while (true) {
                try {
                    remainingNanos = localRequest.condition.awaitNanos(remainingNanos)
                } catch (e: InterruptedException) {
                    if (dequeueRequestQueue.isNotEmpty()
                        && dequeueRequestQueue.first().messages.size < dequeueRequestQueue.first().nOfMessages) {
                        Thread.currentThread().interrupt()
                        dequeueRequestQueue.first().messages.add(message)
                        enqueueRequestQueue.remove(localRequest)
                        return dequeueRequestQueue.first().thread
                    }
                    enqueueRequestQueue.remove(localRequest)
                    throw e
                }
                if (dequeueRequestQueue.isNotEmpty() &&
                    dequeueRequestQueue.first().messages.size < dequeueRequestQueue.first().nOfMessages) {
                    dequeueRequestQueue.first().messages.add(message)
                    enqueueRequestQueue.remove(localRequest)
                    return dequeueRequestQueue.first().thread
                }
                if (remainingNanos <= 0) {
                    // timeout
                    enqueueRequestQueue.remove(localRequest)
                    return null
                }
            }
        }
    }

    @Throws(InterruptedException::class)
    fun tryDequeue(nOfMessages: Int, timeout: Duration): List<T>? {
        require(nOfMessages > 0) { "nOfMessages must be greater than 0" }
        lock.withLock {
            val messages = mutableListOf<T>()
            println("im here")

            // fast path
            if (dequeueRequestQueue.isEmpty() && messageQueue.size >= nOfMessages) {
                repeat(nOfMessages) { messages.add(messageQueue.removeFirst()) }
                return messages
            }

            // wait path
            var remainingNanos = timeout.inWholeNanoseconds
            val localRequest = DequeueRequest(nOfMessages, lock.newCondition(), messages, Thread.currentThread())
            dequeueRequestQueue.add(localRequest)
            while (true) {
                try {
                    remainingNanos = localRequest.condition.awaitNanos(remainingNanos)
                } catch (e: InterruptedException) {
                    if (messageQueue.size >= localRequest.nOfMessages) {
                        Thread.currentThread().interrupt()
                        repeat(nOfMessages) { localRequest.messages.add(messageQueue.removeFirst()) }
                        dequeueRequestQueue.remove(localRequest)
                        return localRequest.messages
                    }
                    dequeueRequestQueue.remove(localRequest)
                    throw e
                }
                if (messageQueue.size >= localRequest.nOfMessages) {
                    dequeueRequestQueue.remove(localRequest)
                    repeat(nOfMessages) { localRequest.messages.add(messageQueue.removeFirst()) }
                    return localRequest.messages
                }
                if (remainingNanos <= 0) {
                    // timeout
                    dequeueRequestQueue.remove(localRequest)
                    return null
                }
            }
        }
    }
}