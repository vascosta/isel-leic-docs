# __Séries__

## __Definição__

> $ S_n = \sum_{n=0}^{n} a_n = a_0 + a_1 + a_2 + \cdots + a_n $

$ \sum_{n=0}^{\infty} U_n $ é convergente sse:

$$ \lim_{n \to \infty} S_n = s $$

* Se $ s = 0 $, a série é $ U_n $ é __infinitésimo__.

* Se $ s $ não for __finito__, a série é __divergente__.

### __Exemplos__

$ U_n = 2 $

* $ S_n = 2 + 2 + 2 + \cdots + 2 = 2n \Rightarrow lim_{n \to \infty} S_n = + \infty $

$ \Rightarrow $ divergente

#

$ U_n = (-1)^n $

* $ \begin{cases} S_n = -1, \text{se } n \text{ é par} \\ S_n = 0, \text{se } n \text{ é ímpar} \end{cases} $
    
    * $ \nexists \lim_{n \to \infty} S_n $

$ \Rightarrow $ divergente

#
#

## __Séries Geométricas__

> $ \sum_{n=0}^{\infty} c \cdot r^n = c + c \cdot r + c \cdot r^2 + \cdots + c \cdot r^n $

> $ c $ = primeiro termo e $ r $ = razão

Se $ |r| < 1 $, a série é __convergente__ e a soma é:

$$ \sum_{n=0}^{\infty} c \cdot r^n = \frac{c}{1 - r} $$

### __Exemplos__

$ \sum_{n=1}^{\infty} (-\frac{1}{2})^n =
\\ \sum_{n=1}^{\infty} (-1).(\frac{1}{2})^n =
\\ \sum_{n=1}^{\infty} (-\frac{1}{2}) (-\frac{1}{2})^{n-1}
$

* $ c = -\frac{1}{2} $ e $ r = -\frac{1}{2} $

    * $ |r| = \frac{1}{2} < 1 \Rightarrow $ convergente

$ \Rightarrow \sum_{n=1}^{\infty} (-\frac{1}{2})^n = \frac{\frac{1}{2}}{1 - (-\frac{1}{2})} = \frac{-\frac{1}{2}}{\frac{3}{2}} = \frac{1}{3} $

#

$ \sum_{n=1}^{\infty} \frac{5^{n+1}}{2^{n+1}} $

* $ U_n = \frac{5^{n+1}}{2^{n+1}} $

* $ U_{n+1} = \frac{5^{n+2}}{2^{n+2}} $

    * $ r = \frac{U_{n+1}}{U_n} = \frac{5^{n+2}}{2^{n+2}} \cdot \frac{2^{n+1}}{5^{n+1}} = 5.\frac{1}{2^2} = \frac{5}{4} > 1 \Rightarrow $ divergente

#
#

## __Séries de Dirichlet__

> $ \sum_{n=1}^{\infty} \frac{1}{n^\alpha} $

* É __convergente__ sse $ \alpha > 1 $

* É __divergente__ sse $ \alpha \leq 1 $

#
#

## __Propriedades__

> $ \sum_{n=0}^{\infty} U_n $ e $ \sum_{n=0}^{\infty} V_n $ séries convergentes

> $ c \in \mathbb{R} $

* $ \sum_{n=0}^{\infty} (U_n + V_n) = \sum_{n=0}^{\infty} U_n + \sum_{n=0}^{\infty} V_n $ é convergente.

* $ \sum_{n=0}^{\infty} c \cdot U_n = c \cdot \sum_{n=0}^{\infty} U_n $ é convergente.

* Se $ \sum_{n=0}^{\infty} U_n $ __converge__ e $ \sum_{n=0}^{\infty} V_n $ __diverge__, então $ \sum_{n=0}^{\infty} (U_n + V_n) $ é __divergente__.

* Se $ \sum_{n=0}^{\infty} U_n $ e $ \sum_{n=0}^{\infty} V_n $ são __divergentes__, então $ \sum_{n=0}^{\infty} (U_n + V_n) $ é __convergente__ ou __divergente__.

#
#

## __Condição Necessária de Convergência__

Se $ lim_{n \to \infty} U_n \neq 0 \Rightarrow \sum_{n=0}^{\infty} U_n $ é __divergente__.

### __Exemplos__

$ U_n = \frac{n}{n + 1} $ 

* $ lim_{n \to \infty} \frac{n}{n + 1} $

    * $ lim_{n \to \infty} \frac{n}{n(1 + \frac{1}{n})} = $
    
    * $ lim_{n \to \infty} \frac{1}{1 + \frac{1}{n}} = 1 \Rightarrow $ divergente

#
#

## __Critérios para Séries de Termos do Mesmo Sinal__

### __Critério da Comparação Direta__

> $ U_n $ e $ V_n $ sucessões de termos __positivos__ a partir de __certa ordem__

$ U_n \leq V_n $ para qualquer ordem

* Se $ \sum_{n=0}^{\infty} V_n $ é __convergente__ $ \Rightarrow $ $ \sum_{n=0}^{\infty} U_n $ também é __convergente__.

* Se $ \sum_{n=0}^{\infty} U_n $ é __divergente__ $ \Rightarrow $ $ \sum_{n=0}^{\infty} V_n $ também é __divergente__.

#

### __Critério de Comparação com Passagem ao Limite__

> $ U_n $ e $ V_n $ sucessões de termos __positivos__ a partir de __certa ordem__

> $ L = lim_{n \to \infty} \frac{U_n}{V_n} $

* Se $ 0 < L < + \infty \Rightarrow \sum_{n=0}^{\infty} U_n $ e $ \sum_{n=0}^{\infty} V_n $ têm a mesma natureza.

* Se $ L = 0 $ e $ \sum_{n=0}^{\infty} V_n $ é __convergente__ $ \Rightarrow $ $ \sum_{n=0}^{\infty} U_n $ também é __convergente__.

* Se $ L = + \infty $ e $ \sum_{n=0}^{\infty} V_n $ é __divergente__ $ \Rightarrow $ $ \sum_{n=0}^{\infty} U_n $ também é __divergente__.

#

### __Critério D'Alembert ou da Razão__

> $ U_n $ uma sucessão de termos __positivos__

> $ L = lim_{n \to \infty} \frac{U_{n+1}}{U_n} $

* Se $ L < 1 $, $ \sum_{n=0}^{\infty} U_n $ é __convergente__.

* Se $ L > 1 $, $ \sum_{n=0}^{\infty} U_n $ é __divergente__.

#

### __Critério de Cauchy ou da Raiz__

> $ U_n $ uma sucessão de termos __positivos__

> $ L = lim_{n \to \infty} \sqrt[n]{U_n} $

* Se $ L < 1 $, $ \sum_{n=0}^{\infty} U_n $ é __convergente__.

* Se $ L > 1 $, $ \sum_{n=0}^{\infty} U_n $ é __divergente__.

* Se $ L = 1 $, o critério é __inconclusivo__.

* Se $ L = 1^+ $, $ \sum_{n=0}^{\infty} U_n $ é __divergente__.

#

### __Módulo de Séries__

> $ \sum_{n=0}^{\infty} U_n $ 

* Se $ \sum_{n=0}^{\infty} |U_n| $ é __convergente__ $ \Rightarrow $ $ \sum_{n=0}^{\infty} U_n $ é __convergente__ e diz-se __absolutamente convergente__.

* Se $ \sum_{n=0}^{\infty} |U_n| $ é __divergente__ $ e $ $ \sum_{n=0}^{\infty} U_n $ é __convergente__ $ \Rightarrow $ $ \sum_{n=0}^{\infty} U_n $ é __convergente__.

* Se o __Critério D'Alembert ou de Cauchy__ garantem que $ \sum_{n=0}^{\infty} |U_n| $ é __divergente__ $ \Rightarrow $ $ \sum_{n=0}^{\infty} U_n $ é __divergente__.

#

### __Critério de Leibniz__

Se $ a_n $ é uma sucessão __positiva e decrescente__ e $ lim_{n \to \infty} a_n = 0 \Rightarrow \sum_{n=0}^{\infty} (-1)^n a_n $ é __convergente__.