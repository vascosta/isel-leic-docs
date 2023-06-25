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

class X:
1 propriedade (nr), mas como é um getter, não é guardada no heap.

class Y:
3 propriedades (bar, nr, foo), mas como nr e foo são getters, não são guardadas no heap.

class Z:
2 propriedades (bar, foo), mas como são val, são guardadas no heap.

Ordem de ocupação de memória no Heap, de maior para menor:
Z, Y, X
```

---

## __4__

```java
fun generateCode() : ClassMaker {
    val cm = ClassMaker.beginExternal("Valuer").interface_().public_()
    cm.addMethod(Int::class.java, "estimate", String::class.java).public_().abstract_()
    return cm
}
```

```
12: aload_0
13: aload_1
14: invokeinterface #23, 2
19: iconst_2
20: iadd
21: iconst_5
22: idiv
23: ireturn
```

## __a)__

```java
public interface Valuer {
    public abstract int estimate(String s);
}
```

## __b)__

```kotlin
// ERRADO, acho eu
fun Valuer.func(a: Valuer) = (a.estimate("s") + 2) / 5
```

## __c)__

```
1 - Se um programa Kotlin incluir o ficheiro .class com o bytecode indicado à direita, então o gerador de código apresentado à esquerda terá de ser executado, o mais tardar, logo antes da primeira execução do método de extensão.

R.: TODO

2 - Considere dois ficheiros: 1. O ficheiro .class produzido pelo gerador da esquerda; e 2. O ficheiro com o código fonte Kotlin do método de extensão. Bastam esses dois ficheiros, para que o compilador de Kotlin possa produzir o bytecode apresentado à direita.

R.: Verdadeiro, uma vez que o ficheiro 1 (Valuer.class) contém a interface Valuer, a qual seria usada pela função de extensão no ficheiro 2 (Main.kt por exemplo).

3 - Se um programa compilado para a JVM incluir o ficheiro .class com o bytecode indicado à direita, então o ficheiro .class produzido pelo gerador da esquerda não é necessário para a sua execução.

R.: Falso, como já referido em 2, o Valuer.class é necessário para que o compilador de Kotlin possa produzir o bytecode apresentado à direita.

4 - Se um programa compilado para a JVM incluir o ficheiro .class com o bytecode indicado à direita, então é inútil que o mesmo programa também inclua o gerador apresentado à esquerda.

R.: TODO
```

---

## __5__

```kotlin
val strs = mutableListOf("ISEL", "LEIC", "LAE")

strs[2] as Int = 5 // 1
(strs as Array<Int>)[2] = 5 // 2
(strs as MutableList<Int>).add(5) // 3
strs.add(5 as String) // 4
```

```
3, porque a passa momentaneamente a MutableList<Int>, adiciona o Int (5) e depois volta a ser MutableList<String>, "enganando" o compilador.
```

---

## __6__

```kotlin
fun hot() {
    val other: Int?
    val n = 6545
    other = n
    val res = n.equals("ola")
    val end = other + res as Int
}
```

```
TODO
```

---

## __7__

```kotlin
val nrs = sequenceOf("abc", "def", "super").map { print("$it "); it.length }
println(nrs.distinct().count())
println(nrs.count())
```

```
Uma vez que as sequências não são guardadas em memória, há necessidade de que a cada chamada a uma sequência, seja necessário "recriá-la":

abc def super 2
abc def super 3

Usando o arrayListOf, o output mudaria sim, uma vez que o array fica sim guardado em memória, logo:

abc def super 2
3
```

---

## __8__

```
TODO
```

---

## __9__

```kotlin
class OutFile(path: String) : Closeable {
    private var out : OutputStream? = FileOutputStream(path)
    fun write(msg: String) = out?.write(msg.toByteArray())
    override fun close() = cleanup()
    protected fun finalize() = cleanup()
    private fun cleanup() { out!!.close(); out = null }
}
```

```
TODO
```