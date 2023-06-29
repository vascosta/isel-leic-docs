import java.io.Closeable
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference

class SafeUsageCountedHolder<T: Closeable>(value: T) {
    private var value: AtomicReference<T> = AtomicReference(value)
    private var useCounter = AtomicInteger(1)

    fun startUse(): T {
        while (true) {
            val observedUseCounter = useCounter.get()
            if (observedUseCounter == 0) throw IllegalStateException("Already closed")
            useCounter.compareAndSet(observedUseCounter, observedUseCounter + 1)
            return value.get() ?: throw IllegalStateException("Already closed")
        }
    }

    fun endUse() {
        while (true) {
            val observedUseCounter = useCounter.get()
            if (observedUseCounter == 0) throw IllegalStateException("Already closed")
            if (useCounter.decrementAndGet() == 0) {
                val observedValue = value.get()
                observedValue.close()
                value.compareAndSet(observedValue, null)
            }
        }
    }
}