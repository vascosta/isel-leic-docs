import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

suspend fun <A, B, C> myRun(f0: suspend () -> A, f1: suspend () -> B, f2: suspend (A, B) -> C): C {
    return coroutineScope {
        val a = async { f0() }
        val b = async { f1() }
        return@coroutineScope f2(a.await(), b.await())
    }
}