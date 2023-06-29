import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Exchanger<T> {
    class Request<T>(val valueToExchange: T, val continuation: Continuation<T>)

    private val lock = ReentrantLock()
    private var currentRequest: Request<T>? = null

    suspend fun exchange(value: T): T = suspendCoroutine { continuation ->
        lock.withLock {
            if (currentRequest != null) {
                val localRequest = currentRequest
                localRequest!!.continuation.resume(value)
                continuation.resume(localRequest.valueToExchange)
            } else {
                currentRequest = Request(value, continuation)
            }
        }
    }
}
