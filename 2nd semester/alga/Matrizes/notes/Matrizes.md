# __Matrizes__

## __Definição__

Quadro com $ m $ x $ n $ números reais (complexos) dispostos por $ m $ __linhas__ e $ n $ __colunas__ -> $ A_{m \times n} $.

__E.g.__: 

<div align=center>

$ A_{2 \times 3} = \begin{bmatrix} 1 & 2 & 3 \\ 4 & 5 & 6 \end{bmatrix} $

</div>

#

## __Entrada de uma Matriz__

__Número__ situado na linha $ i $ e coluna $ j $ de uma matriz $ A $ -> $ a_{ij}, \ i \in \{1, \dots, m\}, \ j \in \{1, \dots, n\} $.

__E.g.__:

<div align=center>

$ A_{2 \times 3} = \begin{bmatrix} 1 & 2 & 3 \\ 4 & 5 & 6 \end{bmatrix} $

$ a_{11} = 1, \ a_{12} = 2, \ a_{13} = 3, \ a_{21} = 4, \ a_{22} = 5, \ a_{23} = 6 $

</div>

#

## __Igualdade de Matrizes__

Duas matrizes $ A $ e $ B $ do tipo $ m \times n $ são __iguais__ se $ a_{ij} = b_{ij} $ para todo $ i \in \{1, \dots, m\} $ e $ j \in \{1, \dots, n\} $ -> $ A = B $.

__E.g.__:

Determine a matriz $ A_{3 \times 3} $ tal que $ a_{ij} = 2^{i+j}, \ i, j \in \{1, 2, 3\} $.

<div align=center>

$ A_{3 \times 3} = \begin{bmatrix} 2^{1+1} & 2^{1+2} & 2^{1+3} \\ 2^{2+1} & 2^{2+2} & 2^{2+3} \\ 2^{3+1} & 2^{3+2} & 2^{3+3} \end{bmatrix} = \begin{bmatrix} 2^2 & 2^3 & 2^4 \\ 2^3 & 2^4 & 2^5 \\ 2^4 & 2^5 & 2^6 \end{bmatrix} = \begin{bmatrix} 4 & 8 & 16 \\ 8 & 16 & 32 \\ 16 & 32 & 64 \end{bmatrix} $

</div>

#

## __Tipos de Matrizes__

* __Matriz Coluna__ ($ A_{m \times 1} $)
    * __E.g.__:

<div align=center>

$ A_{3 \times 1} = \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix} $

</div>

* __Matriz Linha__ ($ A_{1 \times n} $)
    * __E.g.__:

<div align=center>

$ A_{1 \times 3} = \begin{bmatrix} 1 & 2 & 3 \end{bmatrix} $

</div>

* __Matriz Quadrada__ ($ A_{n} $) -> Matriz do tipo $ n \times n $.
    * __Elementos principais__ -> entradas $ a_{ii} $;
    * __Diagonal principal__ -> sequência de __elementos principais__.
    * __E.g.__:

<div align=center>

$ A_{3} = \begin{bmatrix} 1 & 2 & 0 \\ 0 & 2 & 0 \\ 0 & 0 & 3 \end{bmatrix} $

</div>

* __Matriz Triangular Superior__ ($ A_{n} $) -> $ a_{ij} = 0, $ para $ i > j $.
    * __E.g.__:

<div align=center>

$ A_{3} = \begin{bmatrix} 1 & 2 & 3 \\ 0 & 2 & 3 \\ 0 & 0 & 3 \end{bmatrix} $

</div>

* __Matriz Triangular Inferior__ ($ A_{n} $) -> $ a_{ij} = 0, $ para $ i < j $.
    * __E.g.__:

<div align=center>

$ A_{3} = \begin{bmatrix} 1 & 0 & 0 \\ 2 & 2 & 0 \\ 3 & 3 & 3 \end{bmatrix} $

</div>

* __Matriz diagonal__ ($ A_{n} $) -> $ a_{ij} = 0, $ para $ i \neq j $.
    * __E.g.__:

<div align=center>

$ A_{3} = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 2 & 0 \\ 0 & 0 & 3 \end{bmatrix} $

</div>

* __Matriz Escalar__ ($ A_{n} $) -> Matriz diagonal com todos os elementos principais iguais.
    * __E.g.__:

<div align=center>

$ A_{3} = \begin{bmatrix} 2 & 0 & 0 \\ 0 & 2 & 0 \\ 0 & 0 & 2 \end{bmatrix} $

</div>

* __Matriz Identidade__ ($ I_{n} $) -> Matriz escalar com elementos principais iguais a 1.
    * __E.g.__:

<div align=center>

$ I_{3} = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix} $

</div>

* __Matriz Nula__ ($ O_{m \times n} $ ou $ O $) -> Matriz com todas as entradas iguais a 0.
    * __E.g.__:

<div align=center>

$ O_{3 \times 3} = \begin{bmatrix} 0 & 0 & 0 \\ 0 & 0 & 0 \\ 0 & 0 & 0 \end{bmatrix} $

</div>

* __Submatriz__ -> Matriz que se obtém por eliminação de linhas e/ou colunas de uma matriz.
    * $ A[i_1, \dots, i_k | j_1, \dots, j_l] $ -> submatriz de $ A $ formada pelas linhas $ i_1, \dots, i_k $ e pelas colunas $ j_1, \dots, j_l $ de $ A $;
    * $ A(i_1, \dots, i_k | j_1, \dots, j_l) $ -> submatriz que se obtém __por eliminação__ das linhas $ i_1, \dots, i_k $ e pelas colunas $ j_1, \dots, j_l $ de $ A $.
    * __E.g.__:

<div align=center>

$ A_{3 \times 3} = \begin{bmatrix} 1 & 2 & 3 \\ 4 & 5 & 6 \\ 7 & 8 & 9 \end{bmatrix} $

$ A[1,2|2,3] = \begin{bmatrix} 2 & 3 \\ 5 & 6 \end{bmatrix} $

$ A(1,2|2,3) = \begin{bmatrix} 7 \end{bmatrix} $

</div>

* __Matriz Transposta__ ($ A^T $) -> Matriz que se obtém __trocando__ as __linhas__ pelas __colunas__ de uma matriz.
    * $ (A^T)_{ij} = a_{ji}, \ i \in \{1, \dots, n\}, \ j \in \{1, \dots, m\} $.
    * __E.g.__:

<div align=center>

$ A_{3 \times 2} = \begin{bmatrix} 1 & 2 \\ 3 & 4 \\ 5 & 6 \end{bmatrix} \Rightarrow A^T_{2 \times 3} = \begin{bmatrix} 1 & 3 & 5 \\ 2 & 4 & 6 \end{bmatrix} $

</div>

* __Matriz Simétrica__ -> Matriz __igual__ à sua __transposta__.
    * $ A = A^T $.
    * __E.g.__:

<div align=center>

$ A_{2 \times 2} = \begin{bmatrix} 1 & 2 \\ 2 & 3 \end{bmatrix} $

</div>

* __Matriz Anti-simétrica__ -> Matriz __oposta__ à sua __transposta__.
    * $ A = -A^T $.
    * $ a_{ii} = 0, $ para todo $ i \in \{1, \dots, n\} $.
    * __E.g.__:

<div align=center>

$ A_{2 \times 2} = \begin{bmatrix} 0 & 2 \\ -2 & 0 \end{bmatrix} $

</div>

* __Matriz Invertível__ -> Matriz __quadrada__ que possui uma matriz $ X $ tal que $ AX = I_n = XA $.
    * __E.g.__:

<div align=center>

Se $ X $ e $ Y $ são matrizes de ordem $ n $ tais que $ AX = I_n = XA \ $ e $ \ AY = I_n = YA, \ \Rightarrow X = Y $.

</div>

* __Matriz Inversa__ ($ A^{-1} $) -> Matriz (única) que verifica $ AA^{-1} = I_n = A^{-1}A $.
    * __Propriedades__:
        * $ A^{-1} $ é invertível e $ (A^{-1})^{-1} = A $;
        * $ A^T $ é invertível e $ (A^T)^{-1} = (A^{-1})^T $;
        * $ \alpha A $ é invertível se $ \in \mathbb{R}\setminus\{0\} $ e $ (\alpha A)^{-1} = \frac{1}{\alpha} A^{-1} $;
        * $ AB $ é invertível e $ (AB)^{-1} = B^{-1} A^{-1} $;
        * $ A^k $ é invertível e $ (A^k)^{-1} = (A^{-1})^k $.
    * __E.g.__:

<div align=center>

$ A_{2 \times 2} = \begin{bmatrix} 1 & 2 \\ 1 & 1 \end{bmatrix} $

$ A^{-1} = \begin{bmatrix} -1 & 2 \\ 1 & -1 \end{bmatrix} $

$ A \times A^{-1} = \begin{bmatrix} 1 & 2 \\ 1 & 1 \end{bmatrix} \times \begin{bmatrix} -1 & 2 \\ 1 & -1 \end{bmatrix} = \begin{bmatrix} 1 & 0 \\ 0 & 1 \end{bmatrix} = I_2 $

</div>

* __Matriz Ortogonal__ -> Matriz __quadrada__, __invertível__ e que verifica $ A^T = A^{-1} $.
    * $ AA^T = I_n $.
    * __E.g.__:

<div align=center>

$ A_{2 \times 2} = \begin{bmatrix} 0 & 1 \\ -1 & 0 \end{bmatrix} $

$ A^T = \begin{bmatrix} 0 & -1 \\ 1 & 0 \end{bmatrix} $

$ AA^T = \begin{bmatrix} 0 & 1 \\ -1 & 0 \end{bmatrix} \times \begin{bmatrix} 0 & -1 \\ 1 & 0 \end{bmatrix} = \begin{bmatrix} 1 & 0 \\ 0 & 1 \end{bmatrix} = I_2 \Rightarrow A^T = A^{-1} $


</div>

#

## __Operaçõs com Matrizes__

* __Soma de matrizes__ ($ A + B $) -> Matriz __soma__ de $ A $ e $ B $.
    * $ (A + B)_{ij} = a_{ij} + b_{ij} $.
    * ``A e B devem ser do mesmo tipo, caso contrário, a soma não é definida.``
    * __Propriedades__:
        * __Associativa da Adição__ -> $ A + (B + C) = (A + B) + C $;
        * __Comutativa da Adição__ -> $ A + B = B + A $;
        * __Elemento Neutro da Adição__ -> $ A + O = A $;
        * __Elemento Oposto da Adição__ -> $ A + (-A) = O $;
        * $ (A + B)^T = A^T + B^T $;
        * $ A + (-B) = A - B $.
    * __E.g.__:

<div align=center>

$ A_{2 \times 2} = \begin{bmatrix} 1 & 2 \\ 3 & 4 \end{bmatrix}, \ B_{2 \times 2} = \begin{bmatrix} 5 & 6 \\ 7 & 8 \end{bmatrix} \Rightarrow A + B = \begin{bmatrix} 6 & 8 \\ 10 & 12 \end{bmatrix} $

</div>

* __Multiplicação por um Escalar__ ($ \alpha A $) -> Matriz __produto escalar__ de $ A $ por $ \alpha $.
    * $ (\alpha A)_{ij} = \alpha a_{ij} $.
    * __Propriedades__:
        * $ \alpha (A + B) = \alpha A + \alpha B $;
        * $ (\alpha + \beta) A = \alpha A + \beta A $;
        * $ \alpha (\beta A) = (\alpha \beta) A = \beta (\alpha A) $;
        * $ 1A = A, \ -1A = -A, \ 0A = O $;
        * $ \alpha (A^T) = (\alpha A)^T $.
    * __E.g.__:

<div align=center>

$ A_{2 \times 2} = \begin{bmatrix} 1 & 2 \\ 3 & 4 \end{bmatrix} \Rightarrow 2A = \begin{bmatrix} 2 & 4 \\ 6 & 8 \end{bmatrix} $

</div>

* __Multiplicação de Matrizes__ ($ AB $) -> Matriz __produto__ de $ A $ por $ B $.
    * $ (AB)_{ij} = a_{i1}b_{1j} + a_{i2}b_{2j} + \dots + a_{in}b_{nj} = \sum_{k=1}^{n} a_{ik}b_{kj} $.
    * ``O número de colunas de A deve ser igual ao número de linhas de B e vice-versa.``
    * __Propriedades__:
        * $ (AB)C = A(BC) $;
        * $ A(B + C) = AB + AC $;
        * $ (B + C)A = BA + CA $;
        * $ (kA)B = A(kB) = k(AB) $ para todo o escalar $ k $;
        * $ A_n I_n = I_n A_n = A $;
        * $ (AB)^T = B^T A^T $.
    * __E.g.__:

<div align=center>

$ A_{2 \times 2} = \begin{bmatrix} 1 & 3 \\ 5 & -3 \end{bmatrix}, \ B_{2 \times 3} = \begin{bmatrix} 2 & 6 & 4 \\ 0 & -2 & 1 \end{bmatrix} $

$ AB = \begin{bmatrix} 1 \times 2 + 3 \times 0 & 1 \times 6 + 3 \times (-2) & 1 \times 4 + 3 \times 1 \\ 5 \times 2 + (-3) \times 0 & 5 \times 6 + (-3) \times (-2) & 5 \times 4 + (-3) \times 1 \end{bmatrix} = \begin{bmatrix} 2 & 0 & 7 \\ 10 & 36 & 17 \end{bmatrix} $

$ BA $ não está definido.

</div>

* __Potência de Matrizes__ ($ A^k $) -> Matriz __produto__ de $ A $ por ela mesma $ k $ vezes.
    * $ A^k = A^{k-1} A, \ k \in \mathbb{N} $.
    * __Propriedades__:
        * $ A^0 = I $;
        * $ A^m A^n = A^{m+n} $;
        * $ (A^m)^n = A^{mn} $;
        * $ (AB)^n = A^n B^n $.
    * __E.g.__:

<div align=center>

$ A_{2 \times 2} = \begin{bmatrix} 1 & 2 \\ 3 & 4 \end{bmatrix}  $

$ A^2 = A \times A = \begin{bmatrix} 1 & 2 \\ 3 & 4 \end{bmatrix} \times \begin{bmatrix} 1 & 2 \\ 3 & 4 \end{bmatrix} = \begin{bmatrix} 7 & 10 \\ 15 & 22 \end{bmatrix} $

</div>