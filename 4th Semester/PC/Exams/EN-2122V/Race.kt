import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicReference

suspend fun race(f0: suspend () -> Int, f1: suspend () -> Int): Int {
    val result = AtomicReference<Int>(null)

    try {
        coroutineScope {
            launch {
                val res = f0()
                result.compareAndSet(null, res)
                cancel()
            }
            launch {
                val res = f1()
                result.compareAndSet(null, res)
                cancel()
            }
        }
    } catch (e: CancellationException) {
        if (result.get() == null)
            throw e
    }

    return result.get() ?: throw IllegalStateException()
}