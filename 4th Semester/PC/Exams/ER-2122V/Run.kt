import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun <A, B, C> myRun(f0: suspend () -> A, f1: suspend () -> B, f2: suspend (A, B) -> C): C {
    var a: A? = null
    var b: B? = null
    coroutineScope {
        launch { a = f0() }
        launch { b = f1() }
    }
    return f2(a!!, b!!)
}