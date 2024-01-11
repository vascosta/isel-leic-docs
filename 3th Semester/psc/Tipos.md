# Tipos

| Declaração C      | Declaração Intel |
|:-----------------:|:----------------:|
| char              | byte             |
| short             | word             |
| int               | dword            |
| unsigned int      | dword            |
| long int          | qword            |
| unsigned long int | qword            | 
| size_t            | qword            |
| float             | dword            |
| double            | qword            |
| pointer (void *)  | qword            | 
| struct            | -                |

Tamanho de uma struct depende do tamanho dos seus membros.

#

| Unidade           | Potência de 2    |
|:-----------------:|:----------------:|
| Byte              | 2^3              |
| Kilobyte          | 2^10             |
| Megabyte          | 2^20             |
| Gigabyte          | 2^30             |
| Terabyte          | 2^40             |
| Petabyte          | 2^50             |

#

E.g.:
```
64 Bytes = 8 x 8 Bytes = 2^3 x 2^3 Bytes = 2^6 Bytes
```

## Alinhamento

O alinhamento de uma struct é o tamanho do maior membro.

Para alocar os membros da struct é preciso colocar por ordem do 1º ao último membro, tendo em conta o alinhamento.

E.g.:
```
struct values {
    char len; // 1 byte
    short base; // 2 bytes
    short *offset; // 8 bytes
};

Alinhamento = 8 bytes

- len
- base
- base
-
-
-
-
-

Uma vez que offset já não cabe no espaço restante, é preciso colocar o offset no início de um novo bloco de 8 bytes, logo o tamanho da struct é 16 bytes.
```

E.g.:
```c
struct {
    char a; // 1 byte
    int b; // 4 bytes
    char c; // 1 byte
} s; // 9 bytes
```