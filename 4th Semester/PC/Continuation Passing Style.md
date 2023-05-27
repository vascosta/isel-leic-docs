# __Continuation Passing Style__

## __Direct Syle__

```kotlin
/*
    [A]--call-->[F]--ret-->[B]
*/

suspend fun f(a: Int): String
```

#

## __CPS__

```kotlin
/*   
    [A]--()-->[F]--R-->[B]
         |--->[B]

    () -> Argumento extra que é uma referência para a continuação do código que está a seguir à chamada da função
*/

// Gerado pelo compilador através do DS
fun f(a: Int, c: Continuation<String>): Any
```

Função ___suspend___ é escrita em __DS no código fonte__ mas usa __CPS no _byte code_ resultante da compilação__.

```kotlin
suspend fun(...): ... {
    ...
}

// suspendCoroutine -> Potencial Ponto de suspensão
val res = suspendCoroutine { Continuation ->
    Continuation.resume("Hello")
}

println(res)
```