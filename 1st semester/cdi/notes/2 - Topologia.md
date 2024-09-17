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

## __Aderência/Fecho de um Conjunto__

> $ \overline{X} = int \ X \ \cup \ fr \ X $

## __Exemplo de Pontos de um Conjunto__

> $ X = {-\frac{1}{2}} \ \cup [1, \ 3[ $

* $ x = 2 $ é um ponto interior de $ X $

* $ x = 0 $ é um ponto exterior de $ X $

* $ x = 1 $ é um ponto fronteiro de $ X $

* $ int \ X = \ ]1, \ 3[ $

* $ ext \ X = \ ]-\infty, \ -\frac{1}{2}[ \ \cup ]-\frac{1}{2}, \ 1[ \ \cup \ ]3, \ +\infty[ $

* $ fr \ X = \{-\frac{1}{2}, \ 1, \ 3\} $

* $ \overline{X} = \ {-\frac{1}{2}} \ \cup [1, 3] $

## __Conjunto Aberto__

> $ X \subseteq \mathbb{R} $

Diz-se que $ X $ é um __conjunto aberto__ se:

$$ int \ X = X $$

## __Conjunto Fechado__

> $ X \subseteq \mathbb{R} $

Diz-se que $ X $ é um __conjunto fechado__ se:

$$ \overline{X} \ = X $$

## __Exemplos de Conjuntos__

$ X = \ ]1, \ \pi[ $

* $ int \ X = \ ]1, \ \pi[ \ = X \Rightarrow X $ é aberto

* $ fr \ X = \{1, \ \pi\} $

* $ \overline{X} = \ [1, \ \pi] \neq X \Rightarrow X $ não é fechado

$ Y = \ [1, \ \pi[ $

* $ int \ Y = \ ]1, \ \pi[ \ \neq Y \Rightarrow Y $ não é aberto

* $ fr \ Y = \{1, \ \pi\} $

* $ \overline{Y} = \ [1, \ \pi] = Y \Rightarrow Y $ é fechado

$ \mathbb{R} $

* $ int \ \mathbb{R} = \mathbb{R} = \mathbb{R} \Rightarrow \mathbb{R} $ é aberto

* $ fr \ \mathbb{R} = \emptyset $

* $ \overline{\mathbb{R}} = \mathbb{R} = \mathbb{R} \Rightarrow \mathbb{R} $ é fechado