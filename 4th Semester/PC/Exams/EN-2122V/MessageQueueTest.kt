import org.testng.AssertJUnit.assertEquals
import org.junit.jupiter.api.RepeatedTest
import kotlin.time.Duration.Companion.seconds

class MessageQueueTest {
    @RepeatedTest(1)
    fun test() {
        val queue = MessageQueue<String>()
        val ola = "OLA"
        val adeus = "ADEUS"
        val messages = listOf(ola, adeus)
        messages.forEach { queue.enqueue(it) }
        assertEquals(messages, queue.tryDequeue(2, 1.seconds))
    }

    @RepeatedTest(1)
    fun testTimeout() {
        val queue = MessageQueue<String>()
        assertEquals(null, queue.tryDequeue(1, 1.seconds))
    }

    @RepeatedTest(100)
    fun testInterrupt() {
        val queue = MessageQueue<String>()
        val ola = "OLA"
        val adeus = "ADEUS"
        val messages = listOf(ola, adeus)
        messages.forEach { queue.enqueue(it) }
        Thread.currentThread().interrupt()
        assertEquals("OLA", queue.tryDequeue(1, 1.seconds)!!.first())
    }

    @RepeatedTest(100)
    fun testInterrupt2() {
        val queue = MessageQueue<String>()
        Thread.currentThread().interrupt()
        assertEquals("OLA", queue.tryDequeue(1, 1.seconds)!!.first())
    }
}