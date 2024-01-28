# 1
```
Para implementar um serviço para operar como daemon pondera-se receber os pedidos 
através de um named pipe (ou fifo, com tipo p no sistema de ficheiros) ou através 
de um socket de domínio Unix (tipo s no sistema de ficheiros) de tipo stream. 

Qual seria a principal desvantagem para o named pipe?
```

```
A principal desvantagem do named pipe é que este não são mecanismos de comunicação bilateral.
```

# 2
```
Um dos mecanismos previstos para comunicação entre processos (IPC) em sistemas da 
família Unix é a memória partilhada. 

No entanto, a utilização de memória partilhada geralmente implica a utilização de
outros mecanismos de comunicação entre processos. Porquê?
```

```
Uma das razões é que a memória partilhada não contém um mecanismo de sincronização, 
o que implicaria a utilização de, por exemplo, semáforos.

Outra possível razão é a falta de coerência entre caches. Sempre que uma cache é 
atualizada com informação que pode vir a ser partilhada (usada por outros 
processos), é necessário que as caches dos outros processos sejam também 
atualizadas.
```

# 3
```
Um serviço systemd pode estar: enabled, disabled, active, inactive.

a) O que indica cada um destes quatro estados?

b) Indique os pares destes quatro estados que são legítimos de ocorrer (compatíveis 
entre si).
```

## a
```
Enabled -> o serviço é iniciado automaticamente em boot.

Disabled -> o serviço não é iniciado automaticamente em boot.

Active -> o serviço está a correr.

Inactive -> o serviço não está a correr.
```

## b
```
Enabled e active.
Enabled e inactive.
Disable e active.
Disabled e inactive.
```

# 4
```
No âmbito do systemd, explique sucintamente o que é um ficheiro de unidade do 
tipo .socket e o que se entende por socket activation.
```

```
Um ficheiro de unidade do tipo .socket é um ficheiro que descreve como se gere um 
UDS.

Socket activation é um mecanismo que permite que um serviço apenas seja iniciado quando se conecta a um socket. Para isso, basta o serviço ter na secção [Unit] a diretiva Requires=nome.socket.
```

# 5
```
Explique sucintamente o que se entende por paravirtualização e qual a sua principal 
desvantagem.
```

```
Paravirtualização é uma técnica de virtualização que oferece uma interface de 
software às VMs (Virtual Machines) que é semelhante à interface de 
hardware-software do host. Esta nova interface tem modificações mínimas do kernel 
do host o que permite à VM comunicar com os recursos do host em vez de ter que os 
emular.

A principal desvantagem é que o sistema operativo do guest tem de ser modificado para poder trabalhar no ambiente virtualizado.
```

# 6
```
Explique sucintamente o que se entende por máquinas virtuais de processo. 

Dê exemplos práticos da utilização deste tipo de virtualização no cenário 
particular do set de instruções da arquitetura do host ser distinto do existente no 
ambiente virtualizado.
```

```
Máquinas virtuais de processo na verdade não são bem máquinas virtuais, são apenas processos que correm no sistema operativo do host.

Não estão isoladas do host podendo assim terem acesos aos recursos do host.

A função principal delas é converter o set de instruções do sistema operativo guest para o set de instruções do sistema operativo do host.

Um exemplo é a JVM (Java Virtual Machine) que converte o set de instruções do Java para o set de instruções do sistema operativo do host.
```

# 7
```
Comente a seguinte afirmação:

    «Um dos custos incontornáveis do sistema de contentores Docker é o de manter 
    múltiplas versões do kernel Linux para que, por exemplo, as imagens baseadas em 
    Ubuntu 22.04 usem o kernel 5.15 enquanto as imagens baseadas em Red Hat 
    Enterprise Linux 8 precisam do kernel 4.18»
                                                                – autor anónimo
```

```
Esta afirmação está errada, visto quue o Docker partilha o kernel do host com os containers, permitindo uma execução mais leve e rápida.
```

# 8
```
Considere a operação docker build guiada por um Dockerfile.

a) Que condições dão origem a uma nova camada de overlay na imagem resultante do 
build? 

b) Na reconstrução de uma imagem, que condições permitem o reaproveitamento das 
imagens intermédias (em cache) do build anterior?
```

## a
```
Uma nova camada de overlay (camada não-vazia) é criada por cada instrução do 
Dockerfile que altere o file system.

Por exemplo, instruções como COPY ou ADD criam uma nova camada de overlay, enquanto 
que instruções como RUN e WORKDIR podem ou não criar uma nova camada de overlay 
(depende se alteram o file system ou não).

Instruçoes como o FROM não criam uma nova camada de overlay, visto que não alteram 
o file system.
```

## b
```
De maneira a reaproveitar imagens intermédias, é necessário que os ficheiros que 
estão, por exemplo, as ser copiados, não tenham sofrido alterações, ou seja, se de 
uma maneira geral, os ficheiros não tiverem sofrido alterações, é possível 
reaproveitar as imagens intermédias.

Caso contrário, as imagens intermédias abaixo da camada que sofreu alterações, são 
descartadas.
```                

# 9
```
Um ficheiro docker-compose.yml, para especificação de uma solução composta com o 
nome tp2, contém três serviços: svca, svcb e svcc, todos colocados na mesma rede, 
svcnet, de tipo bridge. 

Os serviços svca e svcc têm apenas uma instância cada um, mas o serviço svcb foi 
lançado com scale=4.

Executando um shell (/bin/sh) no contentor do serviço svca, qual é a diferença 
observável entre executar ping svcb ou ping tp2-svcb-1 ?
```

```
Ao executar ping svcb, o ping é feito para um dos 4 contentores do serviço svcb, de fornma aleatória.

Ao executar ping tp2-svcb-1, o ping é feito para o contentor tp2-svcb-1.
```