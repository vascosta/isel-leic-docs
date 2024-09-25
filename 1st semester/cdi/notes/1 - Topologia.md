# __Topologia__

## __Distância entre 2 Pontos__

> $ d(x, y) = |x - y| $

### __Propriedades__

* $ d(x, y) \geq 0, \ \forall \ x, y \in \mathbb{R} $

* $ d(x, y) = 0 \Leftrightarrow x = y, \ \forall \ x, y \in \mathbb{R} $

* $ d(x, y) = d(y, x), \ \forall \ x, y \in \mathbb{R} $

* $ d(x, y) \leq d(x, z) + d(z, y), \ \forall \ x, y, z \in \mathbb{R} $

## __Vizinhança de 1 Ponto__

> $ \delta > 0 $

Sendo $ a \in \mathbb{R} $, a vizinhança de $ a $ é o conjunto:

$$ V_{\delta}(a) = \{ x \in \mathbb{R} \ | \ d(x, a) < \delta \} $$

$$ = \ ]a - \delta, \ a + \delta[ $$

## __Ponto Interior de um Conjunto__

> $ X \subseteq \mathbb{R} \ \text{e} \ a \in \mathbb{R} $

Diz-se que $ a $ é um __ponto interior__ de $ X $ se __existe pelo menos uma vizinhança__ de $ a $ contida no em $ X $:

$$ \exists \ \delta > 0, \ \text{tal que} \ V_{\delta}(a) \subseteq X $$

$ int \ X $ é o conjunto de todos os pontos interiores de $ X $.

## __Ponto Exterior de um Conjunto__

> $ X \subseteq \mathbb{R} \ \text{e} \ a \in \mathbb{R} $

Diz-se que $ a $ é um __ponto exterior__ de $ X $ se __existe pelo menos uma vizinhança__ de $ a $ contida no __complementar__ de $ X $:

$$ \exists \ \delta > 0, \ \text{tal que} \ V_{\delta}(a) \cap X = \emptyset $$

$ ext \ X $ é o conjunto de todos os pontos exteriores de $ X $.

## __Ponto Fronteiro de um Conjunto__

> $ X \subseteq \mathbb{R} \ \text{e} \ a \in \mathbb{R} $

Diz-se que $ a $ é um __ponto fronteiro__ de $ X $ se não é nem interior nem exterior:

$$ \forall \ \delta > 0, \ V_{\delta}(a) \cap X \neq \emptyset \ \wedge \ V_{\delta}(a) \cap X^{c} \neq \emptyset $$

$ fr \ X $ é o conjunto de todos os pontos fronteiros de $ X $.

## __Ponto de Acumulação de um Conjunto__

> $ X \subseteq \mathbb{R} \ \text{e} \ a \in \mathbb{R} $

Diz-se que $ a $ é um __ponto de acumulação__ de $ X $ se:

$$ \forall \ \delta > 0, \ \exists \ x \in X \setminus \{a\}: x \in V_{\delta}(a) $$

## __Aderência/Fecho de um Conjunto__

> $ \overline{X} = int \ X \ \cup \ fr \ X $

## __Derivado de um Conjunto__

> $ X' = \ $ conjunto de todos os pontos de acumulação de $ X $

## __Ponto Isolado de um Conjunto__

> $ X \subseteq \mathbb{R} \ \text{e} \ a \in \mathbb{R} $

Diz-se que $ a $ é um __ponto isolado__ de $ X $ se:

$$ \exists \ \delta > 0, \ V_{\delta}(a) \cap X = \{a\} $$

## __Exemplo de Pontos de um Conjunto__

$ X = {-\frac{1}{2}} \ \cup [1, \ 3[ $

* $ x = 2 $ é um ponto interior de $ X $

* $ x = 0 $ é um ponto exterior de $ X $

* $ x = 1 $ é um ponto fronteiro de $ X $

* $ int \ X = \ ]1, \ 3[ $

* $ ext \ X = \ ]-\infty, \ -\frac{1}{2}[ \ \cup ]-\frac{1}{2}, \ 1[ \ \cup \ ]3, \ +\infty[ $

* $ fr \ X = \{-\frac{1}{2}, \ 1, \ 3\} $

* $ \overline{X} = \ {-\frac{1}{2}} \ \cup [1, 3] $

#
$ X = \{ x \in \mathbb{R} \ | \ x = -\frac{1}{n}, \ n \in \mathbb{N} \} $

* $ X' = \{0\} $

* Pontos Isolados: $ X $

## __Conjunto Aberto__

> $ X \subseteq \mathbb{R} $

Diz-se que $ X $ é um __conjunto aberto__ se:

$$ int \ X = X $$

## __Conjunto Fechado__

> $ X \subseteq \mathbb{R} $

Diz-se que $ X $ é um __conjunto fechado__ se:

$$ \overline{X} \ = X $$

## __Exemplos de Conjuntos Abertos e Fechados__

$ X = \ ]1, \ \pi[ $

* $ int \ X = \ ]1, \ \pi[ \ = X \Rightarrow X $ é aberto

* $ fr \ X = \{1, \ \pi\} $

* $ \overline{X} = \ [1, \ \pi] \neq X \Rightarrow X $ não é fechado

#

$ Y = \ [1, \ \pi[ $

* $ int \ Y = \ ]1, \ \pi[ \ \neq Y \Rightarrow Y $ não é aberto

* $ fr \ Y = \{1, \ \pi\} $

* $ \overline{Y} = \ [1, \ \pi] = Y \Rightarrow Y $ é fechado

#

$ \mathbb{R} $

* $ int \ \mathbb{R} = \mathbb{R} = \mathbb{R} \Rightarrow \mathbb{R} $ é aberto

* $ fr \ \mathbb{R} = \emptyset $

* $ \overline{\mathbb{R}} = \mathbb{R} = \mathbb{R} \Rightarrow \mathbb{R} $ é fechado

## __Majorante__

> $ X \subseteq \mathbb{R} $ e $ a \in \mathbb{R} $

Diz-se que $ a $ é uma __majorante__ de $ X $ se:

$$ \forall \ x \in X, \ x \leq a $$

## __Minorante__

> $ X \subseteq \mathbb{R} $ e $ a \in \mathbb{R} $

Diz-se que $ a $ é uma __minorante__ de $ X $ se:

$$ \forall \ x \in X, \ x \geq a $$

## __Conjunto Majorado__

> $ X \subseteq \mathbb{R} $

Diz-se que $ X $ é um __conjunto majorado__ se tiver pelo menos uma majorante.

## __Conjunto Minorado__

> $ X \subseteq \mathbb{R} $

Diz-se que $ X $ é um __conjunto minorado__ se tiver pelo menos uma minorante.

## __Conjunto Limitado__

> $ X \subseteq \mathbb{R} $

Diz-se que $ X $ é um __conjunto limitado__ se for majorado e minorado.

## __Conjunto Compacto__

> $ X \subseteq \mathbb{R} $

Diz-se que $ X $ é um __conjunto compacto__ se for fechado e limitado.

## __Supremo__

> $ X \subseteq \mathbb{R} $ e $ a \in \mathbb{R} $

Diz-se que $ a $ é o __supremo__ de $ X $ ($ sup \ X $) se for o menor majorante de $ X $.

Qualquer subconjunto de $ \mathbb{R} $ não vazio e majorado tem supremo em $ \mathbb{R} $.

Se o $ sup \ X \in X $, então $ sup \ X = max \ X $.

## __Ínfimo__

> $ X \subseteq \mathbb{R} $ e $ a \in \mathbb{R} $

Diz-se que $ a $ é o __ínfimo__ de $ X $ ($ inf \ X $) se for o maior minorante de $ X $.

Qualquer subconjunto de $ \mathbb{R} $ não vazio e minorado tem ínfimo em $ \mathbb{R} $.

Se o $ inf \ X \in X $, então $ inf \ X = min \ X $.

## __Exemplos de Conjuntos Majorados, Minorados, Limitados e Compactos__

$ X = \ ]-\infty, \ \frac{3}{5}] \ \cap \ (]-\frac{1}{2}, \ 2[ \ \cup \ [-1, \ 0[) = \ ]-\infty, \ \frac{3}{5}] \ \cap \ [-1, \ 2] = [-1, \ \frac{3}{5}] $

* Majorantes: $ [\frac{3}{5}, \ +\infty[ $
    * $ sup \ X = \frac{3}{5} = max \ X $

* Minorantes: $ ]-\infty, \ -1] $
    * $ inf \ X = -1 = min \ X $

* $ X $ __é limitado__

* $ int \ X = \ ]-1, \ \frac{3}{5}[ \ \neq X \Rightarrow X $ __não é aberto__

* $ fr \ X = \{-1, \ \frac{3}{5}\} $

* $ \overline{X} = \ [-1, \ \frac{3}{5}] = X \Rightarrow X $ __é fechado__

* $ X $ __é compacto__

## __Como Determinar o Domínio de uma Função de Variável Real__

* Fazer o levantamento das condições de existência da função:

    * $ \frac{x}{y} $ apenas está definida se $ y \neq 0 $
    
    * $ \sqrt[2k]{x} \equiv x^{\frac{1}{2k}} $ apenas está definida se $ x \geq 0 $, se $ k \in \mathbb{N} $

    * $ \ln{x} $ e $ \log_b{x} $ apenas estão definidas se $ x > 0 $

    * $ x^k $ apenas está definida se $ x > 0 $

    * $ \tan{x} $ apenas está definida se $ x \neq \frac{\pi}{2} + k\pi, \ k \in \mathbb{Z} $

    * $ \arcsin{x} $ e $ \arccos{x} $ apenas estão definidas se $ -1 \leq x \leq 1 $

* Resolver as condições de existência da função	e intersetar os resultados de forma a obter o domínio da função.