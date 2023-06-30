import java.util.concurrent.atomic.AtomicInteger

class SafeValue<T>(val value: T, initialLives: Int) {
    val lives = AtomicInteger(initialLives)
}

class SafeContainer<T>(private val values: Array<SafeValue<T>>) {
    private var index = AtomicInteger(0)
    fun consume(): T? {
        while(index.get() < values.size) {
            if (values[index.get()].lives > 0) {
                values[index.get()].lives -= 1
                return values[index.get()].value
            }
            while (true) {
                val observedIndex = index.get()
                val nextIndex = observedIndex + 1
                if (index.compareAndSet(observedIndex, nextIndex)) {
                    break
                }
            }

        }
        return null
    }
}
