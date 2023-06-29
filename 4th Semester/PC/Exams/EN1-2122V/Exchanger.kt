import java.util.LinkedList
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Exchanger<T> {
    data class Request<T>(val valueToExchange: T, val continuation: Continuation<T>)

    private val lock = ReentrantLock()
    private val requestQueue = LinkedList<Request<T>>()

    suspend fun exchange(value: T): T = suspendCoroutine { continuation ->
        lock.withLock {
            if (requestQueue.isNotEmpty()) {
                val localRequest = requestQueue.removeFirst()
                localRequest.continuation.resume(value)
                continuation.resume(localRequest.valueToExchange)
            } else {
                requestQueue.add(Request(value, continuation))
            }
        }
    }
}
