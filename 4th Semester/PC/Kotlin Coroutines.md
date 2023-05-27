# __Kotlin Coroutines__

Computação Sequencial possível de ser suspendida.

Programação __Assíncrona__.

__Minimizar__ o __bloqueio__ de threads.

__Minimizar__ o nº de threads __necessárias__:
* Threads tem um __custo significativo__ do S.O
    * Podemos facilmente ter dezenas ou centenas de threads por processo;

    * Dificilmente conseguiremos ter dezenas ou centenas de milhares;

JDK1 -> Virtual Threads


## __Escalonamento de Threads__
* Escalonamento e comutação realizados pelo __S.O__ -> Transição __user-mode__ por __Kernel-mode__;

* Comutação pode occorer em qualquer sítio;

* Escalonamento __Preemptivo__;

* __Geração de Código__ não é especial (à excepção do modelo de memória);

* Input/Output está __coordenado__ com o __sistema de threads__.

## __Escalonamento de Coroutines__
* Escalonamento e comutação realizados pela __biblioteca de coroutines do Kotlin__;

* Comutação não pode ocorrer em pontes de código pré-definidos -> __pontos de suspensão__;

* Escalonamento __Cooperativo__;

* Geração do código __é especial__.

* __Nem todo__ o Input/Output está coordenado com o __sistema de coroutines__:
    * I/O da __biblioteca standard do Java não está coordenado__;

    * I/O da __biblioteca feita para uso em coroutines__ então __está coordenado__;

* __Dispatcher__;

* __Concorrência Estruturada__.