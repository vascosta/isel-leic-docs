# __Valores e Vetores Próprios__

## __Definição__
> Seja $ f: U \rightarrow U $ uma aplicação linear.

Um vetor $ u $ não nulo de $ U $ é um __vetor próprio__ de $ f $ se existir um __valor próprio__: 

<div align=center>

$ \lambda \in \mathbb{R} $ tal que $ f(u) = \lambda u $

</div>

> Seja $ A $ uma matriz quadrada de ordem $ n $.

Um vetor $ u  \in \mathbb{R}^n $ não nulo é um __vetor próprio__ de $ A $ se existir um __valor próprio__:

<div align=center>

$ \lambda \in \mathbb{R} $ tal que $ A[u] = \lambda[u] $

</div>

## __Espectro__
> Seja $ f: U \rightarrow U $ uma aplicação linear.

Chama-se __espectro__ de $ f $ ao conjunto de todos os __valores próprios__ de $ f $:

<div align=center>

$ \Epsilon(f) $

</div>

> Seja $ A $ uma matriz quadrada de ordem $ n $.

Chama-se __espectro__ de $ A $ ao conjunto de todos os __valores próprios__ de $ A $:

<div align=center>

$ \Epsilon(A) $

</div>

## __Cáculo de Valores e Vetores Próprios__

> Sejam $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $ uma aplicação linear e $ A $ a matriz canônica de $ f $.

* Os __valores próprios__ de $ f $ são as __soluções da equação__ $ \det(A - \lambda I) = 0 $.

* Os __vetores próprios__ de $ f $ associados ao valor próprio $ \lambda $ são as __soluções do sistema homogêneo__ $ (A - \lambda I)u = 0 $.

## __Polinômio Característico__

> Sejam $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $ uma aplicação linear e $ A $ a matriz canônica de $ f $.

Ao polinómio (de grau _n_) na variável $ x $ chama-se __polinómio característico__ de $ f $ e denota-se por $ p(x) $ e é dado por:

<div align=center>

$ p(x) = \det(A - xI_n) $

</div>

### __Multiplicidade Algébrica de um Valor Próprio__

> Seja $ \lambda $ um __valor próprio__ de $ f $.

A __multiplicidade algébrica__ de $ \lambda $ ($ m.a.(\lambda) $) é o __número de vezes__ que $ \lambda $ é raiz de $ p(x) $.

## __Subespaço Próprio__

> Sejam $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $ uma aplicação linear e $ A $ a matriz canônica de $ f $.

O __subespaço próprio__ de $ f $ associado ao valor próprio $ \lambda $ é o conjunto:

<div align=center>

$ S_{\lambda} \ \{ u \in \mathbb{R}^n: f(u) = \lambda u \} = \{ u \in \mathbb{R}^n: A[u] = \lambda[u] \} $

</div>

### __Multiplicidade Geométrica de um Valor Próprio__

> Seja $ \lambda $ um __valor próprio__ de $ f $.

A __multiplicidade geométrica__ de $ \lambda $ ($ m.g.(\lambda) $) é a __dimensão__ do __subespaço próprio__ de $ f $ associado a $ \lambda $.

### __Propriedades__

> Seja $ S_{\lambda} $ o __subespaço próprio__ de $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $ associado ao valor próprio $ \lambda $.

* Se $ \lambda \neq 0 \Rightarrow f(S_{\lambda}) = S_{\lambda} $
    * $ f $ deixa $ S_{\lambda} $ invariante.

* Se $ \lambda = 0 \Rightarrow f(S_{\lambda}) = \{0_{\mathbb{R}^n}\} $
    * $ S_{\lambda} = S_0 = Nuc(f) $

    * $ f $ __não é injetiva nem sobrejetiva__.

## __Multiplicidades__

> Seja $ \lambda $ um __valor próprio__ de $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $.

* $ 1 \leq m.g.(\lambda) \leq m.a.(\lambda) $

* $ m.a.(\lambda) = 1 \Rightarrow m.g.(\lambda) = 1 $

## __Vetores Próprios e Dependência Linear__

> Sejam $ \lambda_1, \lambda_2, ..., \lambda_k $ os __valores próprios__ de $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $, __distintos 2 a 2__.

Se $ u_1, u_2, ..., u_k $ são __vetores próprios__ associados a $ \lambda_1, \lambda_2, ..., \lambda_k $, então $ u_1, u_2, ..., u_k $ são __linearmente independentes__.

## __Diagonalização__

Uma aplicação linear $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $ é __diagonalizável__ se existir uma base de $ \mathbb{R}^n $ formada por __vetores próprios__ de $ f $.

## __Aplicação diagonalizável e Matriz Diagonal__

> Seja $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $ uma aplicação linear __diagonalizável__ e $ \Beta = \{ u_1, u_2, ..., u_n \} $ uma base (ordenada) de $ \mathbb{R}^n $ formada por __vetores próprios__ de $ f $.

A matriz de $ f $ na base $ \Beta $ é uma matriz __diagonal__:

<div align=center>

$ M(f, \Beta, \Beta) = \begin{bmatrix} \lambda_1 & 0 & \cdots & 0 \\ 0 & \lambda_2 & \cdots & 0 \\ \vdots & \vdots & \ddots & \vdots \\ 0 & 0 & \cdots & \lambda_n \end{bmatrix} = diag(\lambda_1, \lambda_2, ..., \lambda_n) $

</div>

### __Propriedades__

> Seja $ f: \mathbb{R}^n \rightarrow \mathbb{R}^n $ uma aplicação linear.

* $ f $ é __diagonalizável__;

* A __soma__ das __multiplicidades geométricas__ dos __valores próprios__ de $ f $ é igual a $ n $;

* Existe uma base de $ \mathbb{R}^n $ em relação à qual a matriz de $ f $ é diagonal.

## __Matriz Diagonalizável__

Uma matriz $ A $ quadrada de ordem $ n $ é __diagonalizável__ se for __semelhante__ a uma matriz __diagonal__:

<div align=center>

$ D = P^{-1}AP $

</div>

* $ D $ é uma matriz __diagonal__ (com os __valores próprios__ de $ A $ na diagonal);

* $ P $ é uma matriz __diagonalizante__ de $ A $ (com os __vetores próprios__ de $ A $ nas colunas).