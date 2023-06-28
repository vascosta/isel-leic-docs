# ___CompletableFuture___

* Agendamento de uma continuação da operação, produzindo um novo CompletableFuture
* Tem um funcionamento similar às Promises do Javascript

__E.g.__:
```kotlin
fun <T> all(inputFutures: List<CompletionStage<T>>): CompletionStage<List<T>> {
    val futureToReturn = CompletableFuture<List<T>>()
    val listToReturn: MutableList<T> = mutableListOf<T>()
    val lock = ReentrantLock()
    var isDone = false
    inputFutures.forEach { inputFuture ->
        inputFuture.handle { success: T?, error: Throwable? ->
            var maybeSuccess: List<T>? = null
            var maybeError: Throwable? = null
            lock.withLock {
                if (isDone) {
                    return@handle
                }
                if (success != null) {
                    listToReturn.add(success)
                } else {
                    requireNotNull(error)
                    maybeError = error
                    isDone = true
                    return@withLock
                }
                if (listToReturn.size == inputFutures.size) {
                    maybeSuccess = listToReturn
                    isDone = true
                }
            }
            if (maybeSuccess != null) {
                futureToReturn.complete(maybeSuccess)
            } else if (maybeError != null) {
                futureToReturn.completeExceptionally(maybeError)
            }
        }
    }
    return futureToReturn
}
```