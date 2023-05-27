# __Monitores__

## __Monitores implícitos (intrísecos)__

Anteriores aos monitores explícitos.

Qualquer objeto, i.e, qualquer instância de um tipo que deriva de _object_:

* é um ___lock___
* é uma ___condição___ __(única para cada monitor)__

## __Monitores explícitos__

* Interface _lock_
* Interface _condition_

__Aquisição do _Lock___:
* _Statement syncronized { ... }_
* Métodos com o modificador _syncronized (@Syncronized)_ -> método de instânica

Exs.:

```java
String s = "Hello"
Object l = new Object()

syncronized(l/s) {
    ...
}

class A {
    ...
}

A a = new A()

syncronized(a) { ... }
```

Método de instância -> ___this___

Método estático -> objeto __classe__

Class base _Object_ tem métodos:
* wait() -> espera na __condição__ implicita
* notify(), notifyAll -> __sincronização__ da condição implíctia

__Nunca misturar monitores de tipos diferentes (exclusões mútuas diferentes):__
```java
Lock l = new ReentrantLock()

syncronized(l) {
    ...
}

l.lock()

Condition c = l.newCondition

c.wait()
c.signal()
```

# __Publicação de Objetos__

Criar um objeto numa _thread_ e usar esse objeto noutra ___thread___.

Formas de ter ___happens before___ (HB):
* referência ___volatile___
* _thread start_    

Ex.:
```kotlin
/*
write field
write 'volatile' reference
-----------X HB-----------> read 'volatile' reference
                            lock.lock() -> não garante HB porque nâo existe unlock entre o write e o read
                            read field
*/
@Test
fun simpleTest() {
    // var units = 5 -> write
    val s = Semaphore(5)
    
    // Garante HB devido ao thread.start()
    thread {
        // lock.lock()
        // read units
        s.acquired()    
    }
}
```

Não se pode tornar visível a referência de um objeto que pode ainda nâo estar inicializada:

```kotlin
var r

class A {
    init { r = this }
}
```