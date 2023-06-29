import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.testng.AssertJUnit.assertEquals

class RunTest {
    @Test
    fun test() {
        suspend fun f0(): Int {
            return 4
        }

        suspend fun f1(): Int {
            return 1
        }

        suspend fun f2(a: Int, b: Int): Int {
            return a + b
        }

        runBlocking { assertEquals(5, myRun(::f0, ::f1, ::f2)) }
    }
}