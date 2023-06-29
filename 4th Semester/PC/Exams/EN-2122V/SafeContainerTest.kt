import org.junit.jupiter.api.RepeatedTest

class SafeContainerTest {
    @RepeatedTest(1)
    fun testConsume() {
        val values = arrayOf(
            SafeValue("isel", 3),
            SafeValue("pc", 4))
        val safeContainer = SafeContainer(values)

        val threads = mutableListOf<Thread>()
        repeat(10) {
            threads.add(
                Thread {
                    println(safeContainer.consume())
                }
            )
        }

        threads.forEach { it.start() }
        threads.forEach { it.join() }
    }
}