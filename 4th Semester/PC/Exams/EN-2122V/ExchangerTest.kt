import org.junit.jupiter.api.Test
import kotlinx.coroutines.*

class ExchangerTest {
    @Test
    fun test() {
        val exchanger = Exchanger<String>()
        runBlocking {
            launch {
                delay(1000)
                println("Coroutine 1 has ${exchanger.exchange("String from coroutine 1")}")
            }
            launch {
                println("Coroutine 2 has ${exchanger.exchange("String from coroutine 2")}")
            }
            launch {
                delay(1000)
                println("Coroutine 3 has ${exchanger.exchange("String from coroutine 3")}")
            }
            launch {
                println("Coroutine 4 has ${exchanger.exchange("String from coroutine 4")}")
            }
        }
    }
}