# __Aplicações Lineares__

## __Definição__

> Sejam $ U $ e $ V $ dois espaços vetoriais de tamanho n e m, respetivamente. 

__Uma aplicação ou transformação linear__ $ f: U \rightarrow V $ é uma função que verifica:

* $ f(u + v) = f(u) + f(v), \ \forall u, \ v \in U $;

* $ f(\alpha u) = \alpha f(u), \ \forall \alpha \in \mathbb{R}, \ \forall u \in U $.

* $ f(0_U) = 0_V $.

* $ f(a_1u_1 + a_2u_2 + \dots + a_nu_n) = a_1f(u_1) + a_2f(u_2) + \dots + a_nf(u_n) $.

__A imagem de qualquer vetor de U é combinação linear das imagens de uma base de U__.

## __Expressão Analítica__

Se $ f: \mathbb{R}^n \rightarrow \mathbb{R}^m $ é uma __aplicação linear__ então:

* $ f(x_1, \ x_2, \ \dots, \ x_n) = (a_{11}x_1 + a_{12}x_2 + \dots + a_{1n}x_n, \ a_{21}x_1 + a_{22}x_2 + \dots + a_{2n}x_n, \ \dots, \ a_{m1}x_1 + a_{m2}x_2 + \dots + a_{mn}x_n), \ \forall a_{ij} \in \mathbb{R}, i \in [m], \ j \in [n] $.

## __Imagem/Contradomínio de um Subespaço Vetorial__

> Seja $ f: U \rightarrow V $ uma __aplicação linear__.

Se $ S $ __é um subespaço vetorial__ de $ U $ então a imagem de $ S $:

* $ f(S) = \{ f(u): \ u \in S \} $ __é um subespaço vetorial__ de $ V $.

* $ S = <u_1, \ u_2, \ \dots, \ u_n> \ \Rightarrow f(S) = \ <f(u_1), \ f(u_2), \ \dots, \ f(u_n)> $.

* $ f(S) = Im(f) $.

## __Núcleo__

> Seja $ f: U \rightarrow V $ uma __aplicação linear__.

Núcleo de $ f $ é o subespaço vetorial de $ U $ definido por:

* $ N(f) = \{ u \in U: \ f(u) = 0_V \} $.

## __Sobrejetividade__

Uma __aplicação linear__ $ f: U \rightarrow V $ é __sobrejetiva__ se:

* $ Im(f) = V $.

<div align=center>

![](../imgs/1.png)

</div>

## __Injetividade__

Uma __aplicação linear__ $ f: U \rightarrow V $ é __sobrejetiva__ se:

* $ N(f) = \{ 0_U \} $.

<div align=center>

![](../imgs/2.png)

</div>

## __Teorema da Dimensão__

> Seja $ f: U \rightarrow V $ uma __aplicação linear__.

Se $ dim(U) = n $:

* $ dim(Im(f)) + dim(N(f)) = n $.

* $ dim(Im(f)) $ -> __Característica__ de $ f $ ($ c_f $).

* $ dim(N(f)) $ -> __Nulidade__ de $ f $ ($ n_f $).

* $ c_f + n_f = dim(U) $.

## __Morfismos__

Uma __aplicação linear__ $ f: U \rightarrow U $ diz-se um:

* __Homomorfismo__ de $ U $ em $ V $;

* __Monoformismo__ se é __injetiva__;

* __Epimorfismo__ se é __sobrejetiva__;

* __Isomorfismo__ se é __bijetiva__ (injetiva e sobrejetiva).

* __Endomorfismo__ se $ U = V $.

* __Automorfismo__ se é um __endomorfismo__ e __isomorfismo__.

## __Matriz Canónica de uma Aplicação Linear__

> Seja $ f: \mathbb{R}^n \rightarrow \mathbb{R}^m $ uma __aplicação linear__.

A __matriz canónica__ de $ f $ é a matriz __cujas colunas são as imagens dos vetores da base canónica__ de $ \mathbb{R}^n $:

* $ M_f = \begin{bmatrix} f(e_1) & f(e_2) & \dots & f(e_n) \end{bmatrix} $.

* $ [f(u)] = M_f  \begin{bmatrix} x_1 \\ x_2 \\ \vdots \\ x_n \end{bmatrix} $.

### __Imagem__

> Seja $ f: \mathbb{R}^n \rightarrow \mathbb{R}^m $ uma __aplicação linear__.

A __imagem__ de $ f $ é o __espaço gerado pelas colunas da matriz canónica__ de $ f $:

* $ Im(f) = <f(e_1), \ f(e_2), \ \dots, \ f(e_n)> $.

* $ dim(Im(f)) = r[M_f] $.

### __Núcleo__

> Seja $ f: \mathbb{R}^n \rightarrow \mathbb{R}^m $ uma __aplicação linear__.

O __núcleo__ de $ f $ é o __espaço nulo da matriz canónica__ de $ f $:

* $ N(f) = \{ (x1, \ x2, \ \dots, \ x_n) \in \mathbb{R}^n: \ M_f [u]^T = 0 \} $.

* $ dim(N(f)) = n - r[M_f] $.

### __Teorema da Dimensão__

> Seja $ f: \mathbb{R}^n \rightarrow \mathbb{R}^m $ uma __aplicação linear__.

* $ c_f = r(M_f) $.

* $ n_f = n - r(M_f) $.

* $ c_f + n_f = n = dim(\mathbb{R}^n) $.

* Se $ n > m \Rightarrow $ __não é injetiva__.

* Se $ n < m \Rightarrow $ __não é sobrejetiva__.

* Se $ n = m \Rightarrow $ __é bijetiva__.

## __Matriz de uma Aplicação Linear__

> Seja $ f: U \rightarrow V $ uma __aplicação linear__ e $ B_U = \{ u_1, \ u_2, \ \dots, \ u_n \} $ e $ B_V = \{ v_1, \ v_2, \ \dots, \ v_m \} $ bases de $ U $ e $ V $, respetivamente.

Chama-se __matriz de $ f $ nas bases__ $ B_U $ e $ B_V $ à matriz do tipo m x n:

* $ M(f, B_U, B_V) = \begin{bmatrix} a_{11} & a_{12} & \dots & a_{1n} \\ a_{21} & a_{22} & \dots & a_{2n} \\ \vdots & \vdots & \ddots & \vdots \\ a_{m1} & a_{m2} & \dots & a_{mn} \end{bmatrix} $.

* $ f(u_1) = a_{11}v_1 + a_{21}v_2 + \dots + a_{m1}v_m $.

* $ f(u_n) = a_{1n}v_1 + a_{2n}v_2 + \dots + a_{mn}v_m $.

* $ M(f, C_{\mathbb{R}^n}, C_{\mathbb{R}^m}) = M_f $.

> Seja $ f: \mathbb{R}^n \rightarrow \mathbb{R}^m $ uma __aplicação linear__ e $ B = \{ u_1, \ u_2, \ \dots, \ u_n \} $ e $ B' = \{ v_1, \ v_2, \ \dots, \ v_m \} $ bases de $ \mathbb{R}^n $ e $ \mathbb{R}^m $, respetivamente.

* $ M(f, B, B') = [B']^{-1}M_f[B] $.