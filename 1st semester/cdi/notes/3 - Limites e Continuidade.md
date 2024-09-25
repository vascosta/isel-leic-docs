# __Limites e Continuidade__

## __Função Contínua__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ a \in \mathbb{R} $

Diz-se que $ f $ é __contínua__ em $ x = a $, ou seja, $ \exists \ lim_{x \to a} \ f(x) = f(a) $, sse:

$$ \forall \ \delta > 0, \ \exists \ \epsilon > 0: \ x \in D_f \ \cap \ V_{\delta}(a) \Rightarrow f(x) \in V_{\delta}(f(a)) $$

Caso contrário, diz-se que $ f $ é __descontínua__ em $ x = a $.

### __Função Contínua num Conjunto__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ X \subseteq \mathbb{R} $

Diz-se que $ f $ é __contínua__ em $ X $ sse $ f $ for contínua em todos os pontos de $ X $.

### __Exemplo__

$ f(x) = 3x $

* $ \forall \ a \in \mathbb{R}, \ lim_{x \to a} \ 3x = 3a \Rightarrow f $ é contínua em todos os pontos de $ \mathbb{R} $

### __Propriedades__

> $ f, g: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $, $ \ a \in \mathbb{R} $, $ \ lim_{x \to a} \ f(x) = f(a) $ e $ lim_{x \to a} \ g(x) = g(a) $

* $ lim_{x \to a} \ (f(x) \pm g(x)) = lim_{x \to a} \ f(x) \pm lim_{x \to a} \ g(x) = f(a) \pm g(a) $

* $ lim_{x \to a} \ |f(x)| = |lim_{x \to a} \ f(x)| = |f(a)| $

* $ lim_{x \to a} \ (f(x) \cdot g(x)) = lim_{x \to a} \ f(x) \cdot lim_{x \to a} \ g(x) = f(a) \cdot g(a) $

* $ lim_{x \to a} \ \frac{f(x)}{g(x)} = \frac{lim_{x \to a} \ f(x)}{lim_{x \to a} \ g(x)} = \frac{f(a)}{g(a)}, $ se $ g(a) \neq 0 $

Se $ f $ e $ g $ são contínuas em $ a $, então:

* $ f \pm g $ é contínua em $ a $

* $ |f| $ é contínua em $ a $

* $ f \cdot g $ é contínua em $ a $

* $ \frac{f}{g} $ é contínua em $ a $, se $ g(a) \neq 0 $

## __Função Polinomial__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $, $ f(x) = a_0 + a_1x + a_2x^2 + \ldots + a_nx^n, a_0, a_1, \ldots, a_n \in \mathbb{R} $

f é uma __função polinomial__ de grau $ n \in \mathbb{N} \cup \{0\} $ e contínua em $ \mathbb{R} $.

### __Exemplos__

$ f(x) = 3 - x^2 + \sqrt{x^3} + \frac{1}{2}x^4  $ é uma função polinomial de grau 4 e contínua em $ \mathbb{R} $.

## __Função Racional__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $, $ f(x) = \frac{p(x)}{q(x)}, \ p(x), \ q(x) $ são polinomiais.

$ f $ é uma __função racional__ e contínua em $ \{ x \in \mathbb{R}: \ q(x) \neq 0 \} $.

### __Exemplos__

f(x) = $ \frac{x^3 - \ x + \frac{3}{2}}{x^2 + 1} $ é uma função racional e contínua em $ D = \mathbb{R} $.

#

f(x) = $ \frac{x^3 - \ x + \frac{3}{2}}{x^2 - 1} $ é uma função racional e contínua em $ D = \mathbb{R} \setminus \{ -1, 1 \} $.

## __Infinitésimo__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $, $ a \in \mathbb{R} $

Diz-se que f é um infinitésimo em $ x = a $ sse $ lim_{x \to a} \ f(x) = 0 $.

## __Teorema dos Limites Enquadrados__

> $ f, g, h: D \subseteq \mathbb{R} \rightarrow \mathbb{R}, \ a \in \mathbb{R} $

Se houver pelo menos uma $ V(a) $ que tenha:

* $ f(x) \leq g(x) \leq h(x) $, $ \forall \ x \in D \cap V(a) $ 

* $ lim_{x \to a} \ f(x) = lim_{x \to a} \ h(x) = L $

Então $ lim_{x \to a} \ g(x) = L $.

### __Corolário__

> $ f, g: D \subseteq \mathbb{R} \rightarrow \mathbb{R}, a \in \mathbb{R} $

Se houver pelo menos uma $ V(a) $ que tenha: 

* $ 0 \leq f(x) \leq g(x) $, $ \forall \ x \in D \cap V(a) $ 

* $ g $ é um infinitésimo em $ a $

Então $ f $ é um __infinitésimo__ em $ a $.