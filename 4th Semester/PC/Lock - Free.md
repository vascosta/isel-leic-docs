# ___Lock - Free___
* Se múltiplas threads tentam aceder ao mesmo recurso, pelo menos uma irá conseguir, e as restantes voltarão a tentar $ \Rightarrow $ não existe obstrução
* Normalemente usa-se os tipos Atomic
* ``boolean compareAndSet(int expect, int update)``

E.g.:

```kotlin
class ThreadSafeModuloCounter(
    private val modulo: Int,
) {

    init {
        require(modulo > 0) { "modulo must be strictly positive" }
    }

    private val value = AtomicInteger()

    fun inc() {
        while (true) {
            val observed = value.get()
            val next = if (observed < modulo - 1) {
                observed + 1
            } else {
                0
            }
            if (value.compareAndSet(observed, next)) {
                return
            }
            // retry
        }
    }

    fun dec() {
        while (true) {
            val observed = value.get()
            val next = if (observed > 0) {
                observed - 1
            } else {
                modulo - 1
            }
            if (value.compareAndSet(observed, next)) {
                return
            }
            // retry
        }
    }

    fun get(): Int = value.get()
}
```