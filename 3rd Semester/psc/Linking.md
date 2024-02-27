# Linking

## Declaração

Âmbito das declarações:
* bloco
* função
* módulo
* programa

Uma declaração está associada a um storage class:
* auto
* register
* static
* extern

## Operação de ligação

Determinar o endereço de cada objeto referencida (variável ou função).

Ligação interna -> resolução de símbolos locais - pelo compilador.

Ligação externa -> resolução de símbolos globais - pelo linker.

## Ficheiros objecto

Relocatable object file (.o) -> binário de código e de dados resultante direto da 
compilação de um ficheiro;

Executable object file (.out) -> binário executável pronto a ser carregado em memória.

Shared object file (.so) -> pode ser dinamicamente carregado em memória e ligado com o executável.

E.g.:
```
gcc -c ... -> utilizado para indicar que é apenas para compilar.

calculate.c -> calculate.i -> calculate.s -> calculate.o + linker + main.o -> a.out

	1ª seta: pré-processamento cpp
	2ª seta: compilação gcc
	3ª seta: assembler as
	Final: ligação entre o main e o(s) ficheiro(s), através do Linker.

Obs.: o linker pode dar erro se não encontrar os dados que estão a ser chamados.
```

## Secções

| Símbolo      | Secção           | Âmbito           |
|:------------:|:----------------:|:----------------:|
| B            | bss              | global           |
| b            | bss              | local            |
| D            | data             | global           |
| d            | data             | local            |
| R            | ReadOnly         | global           |
| r            | ReadOnly         | local            |
| T            | text             | global           |
| t            | text             | local            |
| U            | undefined        | global           |
| u            | undefined        | local            |
| C            | comum            | global           |
| c            | comum            | local            |

static -> local

funções -> T

Ordem das secções -> text, rodata, data, bss

Geram símbolos:
* Definições de funções
* Chamadas a funções (são undefined se estiverem definidas noutro ficheiro)

Não geram símbolos:
* Declarações de funções
* Declarações de variáveis
* Defines
* Typedef