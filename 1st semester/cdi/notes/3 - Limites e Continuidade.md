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

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R}, \ a \in \mathbb{R} $

Diz-se que f é um infinitésimo em $ x = a $ sse $ lim_{x \to a} \ f(x) = 0 $.

## __Teorema dos Limites Enquadrados__

> $ f, g, h: D \subseteq \mathbb{R} \rightarrow \mathbb{R}, \ a \in \mathbb{R} $

Se houver pelo menos uma $ V(a) $ que tenha:

* $ f(x) \leq g(x) \leq h(x) $, $ \forall \ x \in D \cap V(a) $ 

* $ lim_{x \to a} \ f(x) = lim_{x \to a} \ h(x) = L $

Então $ lim_{x \to a} \ g(x) = L $.

### __Corolário__

> $ f, g: D \subseteq \mathbb{R} \rightarrow \mathbb{R}, \ a \in \mathbb{R} $

Se houver pelo menos uma $ V(a) $ que tenha: 

* $ 0 \leq f(x) \leq g(x) $, $ \forall \ x \in D \cap V(a) $ 

* $ g $ é um infinitésimo em $ a $

Então $ f $ é um __infinitésimo__ em $ a $.

## __Função Limitada__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} \ $ e $ \ X \subseteq \mathbb{D} $

Diz-se que $ f $ é __limitada__ em $ X $ se $ f(x) = \{ f(x): \ x \in X \} $ for um conjunto limitado.

## __Teorema do Limite da Função Composta__

> $ f: D_f \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ g: D_g \subseteq \mathbb{R} \rightarrow \mathbb{R} $

Se $ lim_{x \to a} \ g(x) = b $ e $ lim_{x \to b} \ f(x) = a $, então $ lim_{x \to a} \ f(g(x)) = c $.

## __Limites Laterais__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ a \in \mathbb{R} $

Os limites laterais, se existirem, são os limites de $ f $ segundo os conjuntos $ ]-\infty, a[ \ \cap \ D $ e $ ]a, +\infty[ \ \cap \ D $:

* $ lim_{x \to a^-} \ f(x) = f(a^-) $

* $ lim_{x \to a^+} \ f(x) = f(a^+) $

### __Exemplo__

$ h(x) = \begin{cases} 1, \ se \ x \geq 0 \\ 0, \ se \ x < 0 \end{cases} $

$ h $ é contínua em $ [0, +\infty[ $ e $ ]-\infty, 0[] $.

Em $ x = 0 $:

* $ h(0^-) = 0 $ 
* $ h(0^+) = 1 , $ logo, $ h $ não tem limite em $ x = 0 $, logo, $ h $ não é contínua em $ x = 0 $.

## __Indeterminações__

### __Possíveis de Resolver__

* $ 0^- = (-1) \cdot 0^+ $

* $ - \infty = (-1) \cdot +\infty $

* $ \frac{1}{0^-} = -\infty $ ou $ \frac{1}{0^+} = +\infty $

* sendo $ k \in \mathbb{R} \Rightarrow + \infty \pm k = +\infty $

* sendo $ k \in \mathbb{R} \Rightarrow - \infty \pm k = -\infty $

* sendo $ k \in \mathbb{R} \Rightarrow \frac{k}{\pm\infty} = 0 $

* sendo $ k \in \ ]0, \ +\infty[ \ \Rightarrow + \infty \cdot k = +\infty $

* sendo $ k \in \ ]-\infty, \ 0[ \ \Rightarrow + \infty \cdot k = -\infty $

### __Impossíveis de Resolver__

* $ +\infty -\infty $

* $ \pm\infty \cdot 0 $

* $ \frac{0}{0} $

* $ \frac{\infty}{\infty} $

* $ 1^{\infty} $

* $ 0^0 $

* $ +\infty^0 $

No entanto, existem casos em que é possível resolver estas indeterminações, e.g.:

* $ (\frac{0}{0}) \ lim_{x \to +\infty} \ \frac{x}{x^2 + 1} = lim_{x \to +\infty} \ \frac{1}{x + \frac{1}{x}} = \frac{1}{+\infty \ + 0} = 0 $

* $ (+\infty - \infty) \ lim_{x \to +\infty} \ (x^2 - x) = lim_{x \to +\infty} \ x(x - 1) = +\infty \cdot +\infty = +\infty $

## __Limites Notáveis__

### __Limite de Seno__

$ lim_{x \to 0} \ \frac{sen(x)}{x} = 1 $

### __Limite de Logaritmo Base e__

$ lim_{x \to 0} \ \frac{ln(1 + x)}{x} = 1 $

### __Limite de Exponencial__

$ lim_{x \to 0} \ \frac{e^x - 1}{x} = 1 $

## __Prolongamento por Continuidade__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ a \in D' \setminus D $

Diz-se que $ f $ é __prolongável por continuidade__ a $ x = a $ sse $ \exists \ lim_{x \to a} \ f(x) \in \mathbb{R} $, sendo a função prolongamento por continuidade de $ f $ a $ x = a $:

$$ \tilde{f}(x) = \begin{cases} f(x), \ se \ x \in D \\ lim_{x \to a} \ f(x), \ se \ x = a \end{cases} $$

$$ D_{\tilde{f}} = D \cup \{ a \} $$

### __Exemplos__

$ f(x) = \frac{sen(x^2 - 1)}{x^2 - 1}, \ D = \mathbb{R} \setminus \{ -1, 1 \} $

* $ lim_{x \to -1} \ \frac{sen(x^2 - 1)}{x^2 - 1} = 1 $

    * $ lim_{x \to -1} \ (x^2 -1) = 0, \ x^2 - 1 = u $

    * $ lim_{u \to 0} \ \frac{sen(u)}{u} = 1 $

* $ f $ é prolongável por continuidade a $ x = -1 $.

* $ lim_{x \to 1} \ \frac{sen(x^2 - 1)}{x^2 - 1} = 1 $

    * $ lim_{x \to 1} \ (x^2 -1) = 0, \ x^2 - 1 = u $

    * $ lim_{u \to 0} \ \frac{sen(u)}{u} = 1 $

* $ f $ é prolongável por continuidade a $ x = 1 $.

* $ \tilde{f}(x) = \begin{cases} \frac{sen(x^2 - 1)}{x^2 - 1}, \ se \ x \in \mathbb{R} \setminus \{ -1, 1 \} \\ 1, \ se \ x = -1 \lor x = 1 \end{cases} $

#

$ f(x) = \frac{sen \ x}{x^2}, \ D = \mathbb{R} \setminus \{ 0 \} $

* $ lim_{x \to 0} \ \frac{sen \ x}{x^2} = lim_{x \to 0} \ \frac{sen \ x}{x} \cdot \frac{1}{x} = 1 \cdot +\infty = +\infty $

* $ f $ não é prolongável por continuidade a $ x = 0 $.

#

$ f(x) = \begin{cases} \frac{sen \ x}{x}, \ se \ x \neq 0 \\ 0, \ se \ x = 0 \end{cases}, \ D = \mathbb{R} $

* $ f $ não é contínua em $ x = 0 $, logo, não é prolongável por continuidade a $ x = 0 $.



## __Teorema de Bolzano__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ [a, b] \subseteq D $

Se $ f $ for contínua no intervalo compacto $ [a, b] $, então $ f $ assume em $ [a, b] $ todos os valores compreendidos entre $ f(a) $ e $ f(b) $.

### __Corolário__

Se $ f $ é contínua no intervalo $ [a, b] $ e $ f(a)$ e $ f(b) $ têm sinais opostos, então $ \exists \ c \in \ ]a, b[ $ tal que $ f(c) = 0 $.

### __Exemplo__

$ f(x) = x^3 - 2x - 5 $

$ f(2) = -1 $ e $ f(3) = 16 $

$ f $ é contínua em $ [2, 3] $ e $ f(2) $ e $ f(3) $ têm sinais opostos, logo, $ \exists \ c \in \ ]2, 3[ $ tal que $ f(c) = 0 $.