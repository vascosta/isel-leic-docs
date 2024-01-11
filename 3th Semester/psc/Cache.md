# Cache

A cache é um array de sets.

Um set é um array de linhas.

Linha:
* Dados do bloco -> 32 ou 64 bytes
* Endereço de memória desse bloco -> Tag
* Indicações -> valid bit, dirty bit, etc

E.g.:
```
Set 0 -> |valid, dirty, ...|   linha     |   bloco    |

E -> linhas por set
S -> sets -> 2^s
B -> tamanho do bloco -> 2^b bytes
L -> total de linhas na cache -> S x E

C -> Dimensão da cache -> B x L = B x S x E

   t bits       s bits            b bits
|   Tag    |    Set idx    |    Block offset    | -> endereço com tamanho de m bits
                         
```

## Mapeamento direto

Cada set tem apenas uma linha.

```
C = 1 MByte
B = 64 Byte
m = 32 Bit

L = C / B = 2^20 / 2^6 = 2^14

t = 12 bits  l = 14 bits    b = 6 bits
|   Tag    |    linha    |    # byte    |
```

## Mapeamento full associativo

A cache é baseada num único set, que contém todas as linhas.

```
C = 1 MByte
B = 64 Byte
m = 32 Bit

L = C / B = 2^20 / 2^6 = 2^14

    t = 26 bits       b = 6 bits
|       Tag        |    # byte    |
```

#

## Exercícios

Ex.:
```
Admita um sistema computacional com um nível de cache, formada por blocos de 64 bytes. 

Considere um array de structs do tipo A. 

Quantas posições desse array podem ser completamente armazenadas num bloco da cache?
Justifique. 
```

```c
struct A { short a; int b; char c };
```

```
sizeof(A) = 2 + 4 + 1 = 7 bytes

64 / 7 = 9,14 -> 9 posições
```

Ex.:
```
Quantas linhas de cache ocupa um array bidimensional de valores inteiros com as 
dimensões 4 por 24, numa cache com 8 MBytes de capacidade, formada por blocos de 32 
bytes.
```

```
int array[4][24];

sizeof(array) = 4 x 24 x 4 = 2^2 x 2^2 x 6 x 2^2 = bytes

C = 8 MBytes = 8 x 2^20 = 2^3 x 2^20 = 2^23 bytes
B = 32 Bytes = 2^5 bytes

2^2 x 2^2 x 6 x 2^2 / 2^5 = 2^1 x 6 = 12 linhas
```