# 1
```
O código abaixo implementa um serviço, a operar como daemon, para guardar e 
recuperar 4 bytes. 

No entanto, a forma como o named pipe é utilizado está fundamentalmente errada. Porquê?
```

```c
char data[4];
int main() {
    char req[REQ_LEN];
    umask(0111); mkfifo("/tmp/tp2-req", 0666);
    int fd = open("/tmp/tp2-req", O_RDWR);
    for (;;) {
        memset(req, 0, REQ_LEN);
        int len; do { len = read(fd, req, REQ_LEN); } while (len == 0);
        switch (req[0]) {
            case 'S': memcpy(data, &req[1], 4); write(fd, "OK\n", 3); break;
            case 'G': write(fd, data, 4); break;
            case 'Q': write(fd, "OK\n", 3); unlink("/tmp/tp2-req"); exit(0);
            default: write(fd, "ERR\n", 4); break;
        }
    }
}
```

```
Visto que a comunicação usando named pipes é unidirecional, fazer open do pipe com tags de leitura e escrita (O_RDWR) seria impossível.
```

# 2
```
Vários processos relacionados comunicam através de um espaço de memória partilhada. 

Um dos processos aloca espaço para um objeto com malloc, preenche devidamente 
todos os campos do objeto e publica o ponteiro para o objeto na zona de memória partilhada. 

Há processos a tentar consultar os campos do objeto publicado e a terminar a 
execução com indicação de segmentation fault. 

Qual é o problema?
```

```
O problema é que nem todos os processos têm os mesmos endereços virtuais para o 
objeto.

Logo um mesmo endereço virtual, para processos diferentes pode ser traduzido para 
diferentes endereços físicos, o que resulta em segmentation fault quando estes 
tentam aceder ao objeto.
```

# 3
```
No arranque do sistema, o systemd precisa de determinar o conjunto de serviços em 
estado enabled.

Como se determina essa informação?
```

```
O systemd procura por ficheiros .service em /etc/systemd/system e /usr/lib/
systemd/system que contenham a diretiva "WantedBy" com o valor "sysinit.target".
```

# 4
```
Na definição de ficheiro de unidade para o systemd, é possível adicionar um 
serviço (especificado num ficheiro .service) a um target (especificado num 
ficheiro .target) sem editar, direta ou indiretamente, o ficheiro .target.

a) Indique como se pode conseguir o efeito indicado.

b) Indique qual o propósito para a existência desta funcionalidade.
```

## a
```
É necessário adicionar a diretiva "WantedBy" no ficheiro de configuração do 
serviço, que indica o target que o serviço quer para se iniciar.
```

## b
```
Ao adicionar a diretiva "WantedBy" no ficheiro de configuração do serviço, o 
systemd adiciona automaticamente o serviço ao target especificado, sem ser 
necessário editar o ficheiro .target, tornando associar serviços a targets mais 
flexível.
```

# 5
```
Os processadores ARM v8 de 64 bits (por vezes designados por aarch64) suportam um 
modo de tradução de endereços com duas fases, em que um endereço virtual é 
primeiro traduzido para um endereço intermédio e a seguir passa por uma segunda 
tradução para se obter o endereço físico final.

Qual é o propósito deste esquema de tradução com duas fases?
```

```
O esquema de tradução com duas fases visa aumentar o isolamento entre máquinas virtuais e aumentar a segurança.

Uma vez que haver duas fases de tradução de endereços mantém a ilusão de que a 
máquina virtual interage com o hardware real enquanto que o host controla com 
maior eficácia os recursos partilhados.
```

# 6
```
Comente a seguinte afirmação:

    «Um dos custos incontornáveis do sistema de contentores Docker é o de 
    precisar de uma máquina virtual auxiliar para correr um kernel Linux, que 
    fica em execução em simultâneo com o kernel do host, seja num sistema 
    Windows, Mac ou Linux.»
                                                                – autor anónimo
```

```
Esta afirmação está errada, visto que o Docker não precisa de uma máquina virtual 
auxiliar para correr um kernel Linux.

O Docker usa o kernel do host, e não um kernel Linux, para correr os contentores, 
sendo assim possível correr contentores Docker em sistemas Windows, Mac ou Linux.
```

# 7
```
Considere o Dockerfile apresentado ao lado e dois ficheiros, package.json e app.
js, com uma aplicação para Node.js

a) A construção da imagem falha na linha com RUN cp, que se pretendia que 
colocasse os ficheiros da aplicação Node.js na diretoria de destino. 

Indique porquê e corrija.

b) Modifique ainda o Dockerfile para minimizar o número de reconstruções de 
camadas quando algum dos ficheiros da aplicação Node.js é alterado e reduza o 
número total de camadas.
```

```Dockerfile
FROM ubuntu
WORKDIR /opt/isel/tp2
RUN cp * /opt/isel/tp2/
RUN apt update
RUN apt install -y npm nodejs
RUN npm install
EXPOSE 80
CMD ["node", "app.js"]
```

## a
```
O comando cp não funciona porque o WORKDIR não é a diretoria atual, mas sim a 
diretoria de trabalho do container.

Para isso, é necessário alterar o comando cp para "COPY . /opt/isel/tp2/".
```

## b
```Dockerfile
FROM ubuntu
WORKDIR /opt/isel/tp2

COPY package.json .

RUN apt update && apt install -y npm nodejs && npm install

COPY app.js .

EXPOSE 80
CMD ["node", "app.js"]
```                

# 8
```
Uma solução para docker compose, composta por múltiplos serviços, utiliza redes 
distintas para vários grupos de serviços dessa solução. 

Consequentemente, os vários contentores da solução estarão em execução com 
definições distintas de rede, possivelmente todas elas diferentes das definições 
de rede do sistema anfitrião. 

No entanto, todos os processos desses contentores são também processos do sistema anfitrião. 

Como podem coexistir no mesmo sistema operativo processos com definições de rede diferentes?
```

```
Apesar de os processos dos contentores estarem em execução com definições de rede 
diferentes do sistema anfitrião, o docker cria uma interface de rede virtual para 
cada contentor, que é associada a uma interface de rede física do sistema 
anfitrião, sendo assim a coexistência de processos com definições de rede 
diferentes possível.
```