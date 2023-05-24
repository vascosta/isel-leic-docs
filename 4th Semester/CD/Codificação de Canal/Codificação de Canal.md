# __Codificação de Canal__

## __Modelo de canal discreto__

O canal é analisado através de modelo discreto usando
variáveis aleatórias (v.a.)

#

### __Modelo__ ___Binary Symmetric Channel___ __(BSC)__

<div align=center> 

![]([4th Semester/CD/Codificação de Canal/imgs/Modelo-BSC.png](https://github.com/VascostaIsel/isel-leic-docs/blob/main/4th%20Semester/CD/Codifica%C3%A7%C3%A3o%20de%20Canal/imgs/Modelo-BSC.png)) 

</div>

__Probabilidade de erro de bit__:

$$ P_e = P(Y_0, X_1) + P(Y_1, X_0) $$
$$ = P(Y_0|X_1).P(X_1) + P(Y_1|X_0).P(X_0) $$
$$ = \alpha.P(X_1) + \alpha.P(X_0) $$
$$ = \alpha $$

$ P_e $ -> __BER__

## __Códigos de controlo de erros__

A deteção e correção são obtidas pela introdução de __redundância__ na mensagem original.

#

### __Modos de funcionamento__

__FEC__ -> Forward Error Correction:
* Modo de correção de erros;
* O recetor recebe as palavras, __deteta eventuais erros e corrige-os__.

__ARQ__ -> Automatic Repeat Request:
* Modo de deteção de erros;
* O recetor recebe as palavras e __deteta eventuais erros e em caso de erro, solicita a retransmissão__.

#

## __Códigos de Bloco (n,k)__

Cada bloco de __k__ bits de mensagem origina uma palavra de código com __n__ bits:
* k -> número de bits de __mensagem__;
* n -> número de bits de __palavra de código__.

<div align=center> 

![](imgs\Códigos-de-Bloco.png) 

</div>

#

### __Propriedades__

* ___Code rate___ ($ R $) -> $ R = \frac{k}{n} $, medida de eficiência;

* __Distância de Hamming__ ($ dH $):
    * Número de dígitos em que diferem duas quaisquer palavras do código;

    * Eg.:
    
<div align=center> 

![](imgs\Distância-de-Hamming.png) 

</div>

* __Distância mínima__ ($ dmin $):
    * É a menor distância de Hamming entre duas quaisquer palavras do código; depende da redundância;

    * Majorante => $ dmin \leq 1 + q, q = n - k $

* Deteta todos os padrões até __“I” erros__ -> $ l \leq dmin - 1 $

* Corrige todos os padrões até __“t” erros__ -> $ t \leq \lfloor\frac{dmin - 1}{2}\rfloor $

* __Deteta “l” erros e corrige “t” erros__ -> $ dmin \geq l + t + 1, \ com \ l > t $

#

### __Códigos Lineares__

__Bloco__ -> todas as palavras têm a __mesma dimensão__;

__Linear__:
* O vetor nulo pertence ao código;

* A __soma modular de quaisquer duas palavras do código__ é ainda uma palavra do código.

Eg.:

```
n = número de bits da palavra de código         2^n palavras possíveis
k = número de bits da mensagem                  2^k palavras de código
q = n – k, é o número de bits redundantes

m = [m0 m1 ... mk-1] -> mensagem
c -> palavra de código
```

__Sistemática__ -> $ c = [m_0 \ m_1 \ ... \ m_{k-1} \ b_0 \ b_1 \ ... \ b_{q-1}] $

__Não Sistemática__ -> $ c = [m_0 \ b_1 \ b_0 \ m_1 \ ... \ m_{k-1} \ ... \ b_{q-1}] $

O desenho de códigos eficientes é um problema complEgo: 

$$ \uparrow R \ \downarrow dmin \ ou \ \downarrow R \ \uparrow dmin $$

Os códigos lineares são um __sub-conjunto__ de todos os códigos, requerem __menos memória__ e Egistem __codificadores e descodificadores simples__

#

### __Código de Repetição (3,1)__

Consiste na repetição da mensagem.

Eg.:

<div align=center> 

![](imgs\Egemplo-Código-de-Repetição.png) 

</div>

```
m | c
0 | 000
1 | 111                    
```

$ 2^k = 2^1 = 2 $ palavras

$ 2^n = 2^3 = 8 $ possíveis palavras de código

Descodificação realizada por __maioria__.

<div align=center> 

![](imgs\Egemplo-Código-de-Repetição-2.png)

</div>

Eg.:

Com, por Egemplo $ \alpha = 10^{-15} $ 

$ P(1,3) = C^{3}_{1} \ . \ \alpha^1(1 - \alpha)^2 $ 

$ P(2,3) = C^{3}_{2} \ . \ \alpha^2(1 - \alpha)^2 $ 

#

### __Código Bit de Paridade (3,2)__

Adicionar um bit no final da mensagem -> este bit é a __soma módulo 2__ dos bits da mensagem.

Palavra de código -> $ c = [m_0 \ m_1 \ m_0 \oplus m_1] $

Eg.:

```
m  | c
00 | 000
01 | 011     
10 | 101 
11 | 110              
```

<div align=center> 

![](imgs\Egemplo-Código-Bit-de-Paridade.png) 

</div>

#

## __Palavras de Código: Vetores__

<div style=flEg align=center> 

![](imgs\Egemplo-Palavras-de-Código-Vetores.png)

</div>

```
(a) -> código de repetição (3,1) => 3 arestas entre as 2 palavras de código
(b) -> código de bit de paridade (3,2) => 2 arestas entre 2 palavras de código mais próximas
```

#

## __Peso de Hamming (w)__

Número de dígitos não nulos numa palavra.

Sejam $ c_i \ e \ c_j $ duas palavras distintas de um código linear de bloco:

$$ dmin = min \ dH(c_i, c_j), com \ i \ne j $$

Dado que o código é linear:

$$ dmin = min \ w(c_i \oplus c_j) = min \ w(c_k), \ sendo \ c_k \ palavra \ do \ código, \ diferente \ do \ vetor \ nulo$$

Eg.:

```
Código (3,1)                            Código (3,2)

m  | c  | w(c)     dmin = 3             m  | c   | w(c)     dmin = 2
0 | 000 | 0        l = 2                00 | 000 | 0        l = 1
1 | 111 | 3        t = 1                01 | 011 | 2        t = 0
                                        10 | 101 | 2
                                        11 | 110 | 2          
```
