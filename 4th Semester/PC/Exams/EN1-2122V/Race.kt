import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun race(f0: suspend () -> Int, f1: suspend () -> Int): Int = coroutineScope {
    var result: Int? = null
    var job1: Job? = null
    var job0: Job? = null

    job1 = launch {
        result = f1()
        if (result != null) job0!!.cancel()
    }

    job0 = launch {
        result = f0()
        if (result != null) job1!!.cancel()
    }

    job1.join()
    job0.join()

    return@coroutineScope result ?: throw IllegalStateException("No coroutine finished successfully.")
}