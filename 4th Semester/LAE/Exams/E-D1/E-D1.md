# __E-D1__

## __1__

```kotlin
// prog.kt

data class Message(val txt : String)

class Printer {
    fun writeln(msg : Message) { println(msg.txt) }
}

val out = Printer()

fun main() {
    out.writeln(Message("Hello"))
}
```

```kotlin
// kotlinc prog.kt

Message.class // data class Message
Printer.class // class Printer
ProgKt.class // file prog.kt
```

---

## __2__

```kotlin
class Foo(a: Int, var b: String, val c: Int, d: Double) {
    val x : String = "ISEL"
    var y : Int = 2023
}
```

```kotlin
// b, d, x, y -> propriedades (val, var)
// a, c -> parâmetros
```

---

## __3__

```java
public static <T, V> void setMany(T[] objs, Method propSetter, V value) {
    // Percorrer o array objs
    for (T obj : objs) {
        try {
            // Chamar o método propSetter no objeto "obj" com o argumento "value"
            // através do método invoke
            propSetter.invoke(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```

---

## __4__

```
public static final int func(int, int);
Code:
0: iload_0
1: iload_1
2: imul
3: iconst_5
4: iadd
5: ireturn
```

---

```kotlin
fun func(a: Int, b: Int) = (a * b) + 5
```

---

## __5__

```kotlin
fun <R> List<*>.weaklyCheckedAs() : List<R> {
    if (!isEmpty()) {
        first() as R
    }
    @Suppress("UNCHECKED_CAST")
    return this as List<R>
}
```

## __a)__

```kotlin
// fun <R> List<*>.weaklyCheckedAs() : List<R>
inline fun <reified R> List<*>.weaklyCheckedAs() : List<R>

// inline -> remove a reflexão e permite o uso de reified em parâmetros Tipo

// reified -> permite que o parâmetro Tipo seja acessível dentro da função como se fosse uma classe normal
```

## __b)__

```
O compilador, em tempo de compilação tem conhecimento sobre os tipos utilizados, no entanto o Type Erasure remove a informação desses tipos em tempo de execução, neste caso, "R".

Logo, quando é feito o cast "first() as R", o compilador não pode verificar em tempo de execução se o cast é seguro, devido ao Type Erasure.

Resumindo, o cast não é verificável, uma vez que em tempo de execução os items da lista podem não ter sido convertidos para o tipo "R".
```

---

## __6__

```kotlin
fun <T : Any> Sequence<T?>.noNulls(): Sequence<T> = sequence {
    val iter = this@noNulls.iterator()
    while (iter.hasNext()) {
        val next = iter.next()
        if (next != null) yield(next)
    }
}

fun <T : Any> Sequence<T?>.noNulls(): Sequence<T> = sequence {
    for (item in this@noNulls) {
        if (item != null) {
            yield(item)
        }
    }
}
````

---

## __7__

```
explica o garbage collector, eden e afins (TODO)
```

---

## __8__

```kotlin
// A
fun <T : Closeable, R> T.use(func: (T) -> R) : R {
    try {
        return func(this)
    } finally {
        close()
    }
}

// B
fun <T> Collection<T>.use(func: (T) -> Unit) {
    for (item in this) {
        func(item)
    }
}

// C
fun <T : Closeable, R> Sequence<T>.use(func: (T) -> R) : Sequence<R> = sequence {
    for (item in this@use) {
        try {
            yield(func(this))
        } finally {
            item.close()
        }
    }
}
```

```
Implementação B -> NÃO, uma vez que náo tem nenhum parametro de Tipo que seja Closeable

Implementação C -> NÃO, uma vez que retorna uma Sequence<R> e não um R

Implementação A -> SIM
```