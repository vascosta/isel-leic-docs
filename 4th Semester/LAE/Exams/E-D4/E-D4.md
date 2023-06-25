# __E-D4__

## __1__

```kotlin
// classes.kt

import java.io.Closeable

interface Printable { fun printIt() }

class Info(val code : Int, val text : String) : Printable, Closeable {
    override fun printIt() { println("Info($code) { text: \"$text\"}") }
    override fun close() { println("Info($code) -- Done") }
}

fun texts() = sequence { yield("ISEL"); yield("LEIC"); yield("LAE") }

fun main() {
    var count = 1
    texts().map { Info(count++, it) }.forEach { it.use { info -> info.printIt() } }
}
```

## __a)__

```kotlin
// kotlinc classes.kt

Printable.class // interface Printable
Info.class // class Info
ClassesKt.class // file classes.kt
```

## __b)__

```
iload
```

## __c)__

```
Uma vez que a função "text()" faz yield a 3 elementos, a máquina de estados (invokeSuspend) terá 3 estados.
```

---

## __2__

## __a)__

```kotlin
@Target(AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class DontRead()
```

```java
public class VarUtils {
    public static Map<String, Method> getPublicVarGettersOf(Object obj) {
        Map<String, Method> publicVarGetters = new HashMap<>();

        // Obter todos os métodos que não têm a anotação DontRead
        Method[] methods = Arrays.stream(obj.getClass().getDeclaredMethods())
                .filter(m -> !m.isAnnotationPresent(DontRead.class))
                .toArray(Method[]::new);
    
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                // setX -> x
                String propName = method.getName().substring(3).toLowerCase(); 

                // Verifica se existe um método getX
                if (Arrays.stream(methods).anyMatch(m -> m.getName().equals("get" + propName.toUpperCase()))) {
                    // Inserir o par (x, getX) no mapa
                    publicVarGetters.put(propName, method);
                }
            }
        }
        return publicVarGetters;
    }
}
```

## __b)__

```java
public static void showVars(Object obj) {
    Map<String, Method> map = getPublicVarGettersOf(obj);
    System.out.println(obj.getClass().getName() + " {");

    for (String propName : map.keySet()) {
        try {
            String propType = obj.getClass()
                .getDeclaredField(propName).getType().getSimpleName();

            System.out.println(
                "  var" + propName + " : " 
                + propType + " = " + map.get(propName).invoke(obj)
            );
        
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    System.out.println("}");
}
```

---

## __3__

```kotlin
class X(bar: Int) {
    val nr: Int
        get() = foo
    companion object {
        val foo = 7657
        val zaz = 1234
        val qux = 9876
    }
}

class Y(var bar: Int = 7657, qux: String = "ISEL-LEIC") {
    val nr
        get() = bar
    val foo
        get() = nr
}
class Z(
    val bar: Int,
    val foo: Int
)
```

```
Tipos primitivos (Boolean, Int, Float, ...) são guardados na stack.
Tipos objetos (String, Classes, Companion Objects, ...) são guardados no heap.

Propriedades ocupam mais espaço que parâmetros.

class X:
bar (stack) -> ()
nr (stack) -> Companion Object (heap) -> foo (heap) -> 7657

class Y:
bar (stack) -> 7657
qux (heap) -> "ISEL-LEIC"
nr (stack) -> bar (stack) -> 7657
foo (stack) -> nr (stack) -> bar (stack) -> 7657

class Z:
bar (stack) -> ()
foo (stack) -> ()

Ordem de ocupação de memória no Heap:
Z, Y, X
```

---

## __4__

## __a)__

```kotlin

```