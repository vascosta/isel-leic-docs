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