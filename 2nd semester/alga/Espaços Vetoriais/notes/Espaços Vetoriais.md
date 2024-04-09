# __Espaços Vetoriais__

## __Definição__
> Um conjunto V é um __espaço vetorial real__ se estão definidas em V duas operações:
> * $ \forall \ u, v \in V, u + v \in V $;
> * $ \forall \ u \in V, \forall \ \alpha \in \mathbb{R}, \alpha u \in V $;

> Que satisfaçam as seguintes propriedades:
> * $ \forall \ u, v \in V, u + v = v + u $;
> * $ \forall \ u, v, w \in V, (u + v) + w = u + (v + w) $;
> * $ \exists \ v_0 \in V, \forall \ u \in V, u + v_0 = u $;
> * $ \forall \ u \in V, \exists \ (-u) \in V, u + (-u) = v_0 $;
> * $ \forall \ \alpha, \beta \in \mathbb{R}, \forall \ u \in V, (\alpha + \beta)u = \alpha u + \beta u $;
> * $ \forall \ \alpha \in \mathbb{R}, \forall \ u, v \in V, \alpha(u + v) = \alpha u + \alpha v $;
> * $ \forall \ \alpha, \beta \in \mathbb{R}, \forall \ u \in V, \alpha(\beta u) = (\alpha \beta)u $;
> * $ \forall \ u \in V, 1u = u $;


## __Subespaço Vetorial__
> __Subconjunto não vazio S__ de V tal que:
> * $ \forall \ u, v \in S, u + v \in S $;
> * $ \forall \ u \in S, \forall \ \alpha \in \mathbb{R} \Rightarrow \alpha u \in S $;

__Satisfazendo__ as propriedades de um espaço vetorial, S é um __subespaço vetorial__ de V então:

* $ v_0 \in S $;
* $ \forall \ u \in S, \Rightarrow \ a.u \in S $;

__Núcleo__ de uma matriz A $ N(A) = \{(x_1, \ x_2, \ \dots, \ x_n) \in \mathbb{R}^n: A\begin{bmatrix} x_1 \ x_2 \ \dots \ x_n \end{bmatrix}^T = \begin{bmatrix} 0 \end{bmatrix}\} $ é um __subespaço vetorial__ de $ \mathbb{R}^n $.

__É um subespaço vetorial__ das __matrizes quadradas de ordem n__ o subconjunto das matrizes:
* __Simétricas__;
* __Triangulares superiores/inferiores__;
* __Diagonais__ ou com __diagonal nula__;
* __Escalares__.

__Não é um subespaço vetorial__ das __matrizes quadradas de ordem n__ o subconjunto das matrizes:
* Com __diagonal não nula__;
* __Invertíveis__ e __não invertíveis__.

## __Combinação Linear__
> Seja $ \{v_1, \ v_2, \ \dots, \ v_n\} \in V $ e $ \{a_1, \ a_2, \ \dots, \ a_n\} \in \mathbb{R} $, então a __combinação linear__ dos vetores $ \{v_1, \ v_2, \ \dots, \ v_n\} $ é dada por: $ a_1v_1 + a_2v_2 + \dots + a_nv_n $.

* __E.g.__:

<div align="center">

O vetor $ u = (2, 3) $ é combinação linear de $ u_1 = (-4, -6) $ ?

$ u = a_1u_1 \Rightarrow (2, 3) = a_1(-4, -6) \Rightarrow (2, 3) = (-4a_1, -6a_1) \Rightarrow a_1 = -\frac{1}{2} $.

</div>

## __Combinação Linear Nula__
> O __vetor nulo__ é __combinação linear de qualquer__ conjunto de vetores: $ v_0 = 0v_1 + 0v_2 + \dots + 0v_n $.

## __Dependência e Independência Linear__

Seja $ \{v_1, \ v_2, \ \dots, \ v_n\} \in V $:

* Os vetores são __linearmente dependentes__ se existirem escalares $ \{a_1, \ a_2, \ \dots, \ a_n\} \in \mathbb{R} $, não todos nulos, tal que $ a_1v_1 + a_2v_2 + \dots + a_nv_n = 0 $.

    * Neste caso, pelo menos um dos vetores é __combinação linear__ dos restantes.

* Os vetores são __linearmente independentes__ se a equação $ a_1v_1 + a_2v_2 + \dots + a_nv_n = 0 $ só tiver a solução nula.

### __Propriedades__

* Os vetores de um sistema __SPI__ são sempre __linearmente dependentes__;

* O vetor nulo é __linearmente dependente__;

* $ u $ é __linearmente dependente__ se e só se $ u \neq 0 $;

* $ u_1, \ \dots, \ u_n $ são __linearmente dependentes__ se e só se pelo menos um deles for __combinação linear__ dos restantes.

* Se algum dos vetores $ u_1, \dots, \ u_n $ for o vetor nulo, então os vetores são __linearmente dependentes__.

* Se $ u_1, \dots, \ u_n $ são __linearmente independentes__ então $ u_1, \dots, \ u_{n+1} $ são linearmente dependentes se e só se $ u_{n+1} $ for __combinação linear__ dos restantes.

* Se $ u_1, \ \dots, \ u_n $ são __linearmente dependentes__ então $ u_1, \dots, \ u_{n+1}, \ \dots, \ u_m $ são __linearmente dependentes__.

* Se $ u_1, \ \dots, \ u_n $ são __linearmente independentes__ então os vetores de qualquer seu subconjunto são __linearmente independentes__.


## __Subespaço Gerado__
> Conjunto de __todas as combinações lineares__ de um conjunto de vetores $ \{v_1, \ v_2, \ \dots, \ v_n\} \in V: \ <v_1, \ \dots \ , v_n> \ = \{a_1v_1 + a_2v_2 + \dots + a_nv_n: a_1, \ \dots \ , a_n \in \mathbb{R}\} $.

## __Intersecção e Soma de Subespaços Vetoriais__

### __Propriedades__

Se $ S_1, \ S_2 $ são __subespaços vetoriais__ de V então:

* $ S_1 \cap S_2 $ é um __subespaço vetorial__ de V;

* $ S_1 + S_2 = \{s_1 + s_2: s_1 \in S_1 \land s_2 \in S_2\} $ é um __subespaço vetorial__ de V.

## __Base e Dimensão__

O conjunto $ \{v_1, \ v_2, \ \dots, \ v_n\} \in V $ diz-se uma __base__ de V se:

* Os vetores são __linearmente independentes__;

* Os vetores forem __geradores__ de V, ou seja, $ V = \ <v_1, \ \dots \ , v_n> $.

__Base Canónica__ -> $ \{(1,0,\dots,0), \ (0,1,\dots,0), \ \dots, \ (0,0,\dots,1)\} $.

__Dimensão ($ dim(V) $)__ 

> Número de vetores da base.

* $ dim(\mathbb{R}^n) = n $;

* $ dim(\mathbb{R}^{m \ * \ n}) = m \ * \ n $;

* $ dim(\mathbb{P}_n(x)) = n + 1 $;

Para mostrar que um __conjunto de vetores são geradores de um espaço vetorial__, basta mostrar que $ r([u_1, \ \dots \ , u_n]) = k = dim({R^k}) $.