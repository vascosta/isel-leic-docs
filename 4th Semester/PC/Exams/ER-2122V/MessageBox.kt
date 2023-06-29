import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MessageBox<T> {

    private val lock = ReentrantLock()
    private var messageQueue = LinkedList<Continuation<T>>()

    suspend fun waitForMessage(): T = suspendCoroutine<T> {continuation ->
        lock.withLock {
            messageQueue.add(continuation)
        }
    }

    fun sendToAll(message: T): Int {
        lock.withLock {
            val totalReceivedMessages = messageQueue.size
            messageQueue.forEach { it.resume(message) }
            messageQueue = LinkedList<Continuation<T>>()
            return totalReceivedMessages
        }
    }
}