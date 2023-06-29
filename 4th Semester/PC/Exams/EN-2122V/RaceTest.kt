import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun test() {
        suspend fun f0(): Int {
            delay(2000)
            return 0
        }

        suspend fun f1(): Int {
            delay(1000)
            return 1
        }

        runBlocking { println(race({ f0() }, { f1() })) }
    }
}