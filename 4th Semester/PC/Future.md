# __Future__

Representa o __resultado__ de uma operação/computação, potencialmente em __curso__.

Operação não completada:
* Completa com __sucesso__ -> R
* Completa com __erro__ -> E

## __Síncrono__

Ex.:
```
---->
    |o|  
    |p|
    |e|
    |r|
    |a|
    |ç|
    |ã|
    |o|
<---| |
R ou E
```

Função __retorna__ quando a operação __acabou__.

O retorno está __síncrono__ com a __terminação__ da operação.

## __Assícrono__

Ex.:
```
-------->
<-------|o|  
F<R>    |p|
        |e|
        |r|
        |a|
        |ç|
        |ã|
        |o|
```

O retorno não está síncrono __(assíncrono)__ com a __terminação__ da operação.

# __Future _Java___

```java
interface Future <R> { 
    // Observar o seu estado
    // Esperar até que a operação esteja concluída
    ... 
}

class CompletableFuture <R> {
    // Não é abstracta
    ...
}

val cf = CompletableFuture<String>()
cd.complete("Hello") // Não completo -> completo
```

## Catch de CompletableFuture

```kotlin
fun <R1, R2> CompletableFuture<R1>.catch(block: (Throwable) -> R1): CompletableFuture<R2> {
    return this.handle { success: R1, error: Throwable? ->
        if (success != null) {
            success
        } else {
            require (error != null)
            block(error)
        }
    }
}
```
