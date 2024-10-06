# __Cálculo Diferencial__

## __Derivada__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ a \in int(D) $

A __derivada__ de $ f $ em $ x = a $ é:

$$ f'(a) = lim_{x \to a} \ \frac{f(x) - f(a)}{x - a} = lim_{h \to 0} \ \frac{f(a + h) - f(a)}{h} $$

### __Exemplo__

$ f(x) = x^2 $

* $ f'(a) = lim_{x \to a} \ \frac{x^2 - a^2}{x - a} = lim_{x \to a} \ \frac{(x - a)(x + a)}{x - a} = lim_{x \to a} \ (x + a) = 2a $

* $ f'(x) = 2x $

## __Função Diferenciável__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ a \in int(D) $

Se $ \exists \ f'(a) \in \mathbb{R} $, então $ f $ é __diferenciável__ em $ x = a $.

Se $ f $ é __diferenciável__ em $ x = a $, então $ f $ é __contínua__ em $ x = a $.

Se $ f $ é __diferenciável__ em todos os pontos de $ S \subseteq \mathbb{R} $, então $ f $ é __diferenciável__ em $ S $.

#### __Reta Tangente__

$$ y = f(a) + f'(a)(x - a) $$

#### __Reta Normal__

$$ y = f(a) - \frac{1}{f'(a)}(x - a) $$

#### __Exemplo__

$ f(x) = x^2 $ e $ a = 2 $

* $ f'(x) = 2x $

* $ f'(2) = 4 $

* Reta tangente: $ y = 4x + 4(x - 2) $

* Reta normal: $ y = 4x - \frac{1}{4}(x - 2) $

## __Propriedades__

> $ f, g: D \subseteq \mathbb{R} \rightarrow \mathbb{R}, \ a \in int(D) $ e $ f, \ g \ $ diferenciáveis em $ a $

* Se $ f \pm g $ é diferenciável em $ a \Rightarrow (f \pm g)'(a) = f'(a) \pm g'(a) $

* Se $ f \cdot g $ é diferenciável em $ a \Rightarrow(f \cdot g)'(a) = f'(a) \cdot g(a) + f(a) \cdot g'(a) $

* Se $ \frac{f}{g} $ é diferenciável em $ a \Rightarrow (\frac{f}{g})'(a) = \frac{f'(a) \cdot g(a) - f(a) \cdot g'(a)}{g^2(a)} $

* Se $ f $ é constante em $ D $, e $ a \in D \Rightarrow f'(a) = 0 $

* Se $ f(x) = x^n, \ n \in \mathbb{N} \cup \{0\} $ e $ a \in \mathbb{R} \Rightarrow f'(a) = n \cdot a^{n - 1}, \ \forall \ a \in \mathbb{R} $

* Se $ f(x) = \sqrt[k]{x} \ \vee \ f(x) = |x| \Rightarrow f $ é diferenciável em $ D \setminus \{0\} $

* Se $ f(x) = arcsin(x) \ \vee \ f(x) = arccos(x) \Rightarrow f $ é diferenciável em $ D \setminus \{-1, 1\} $

## __Função Polinomial__

> $ P(x) $ é diferenciável $ \ \forall \ x \in \mathbb{R} $

A derivada de $ P(x) $ é:

$$ P'(x) = a_1 + 2a_2x + 3a_3x^2 + \ldots + na_nx^{n - 1} $$

Se $ P(x) $ tiver grau $ n \Rightarrow P'(x) $ terá grau $ n - 1 $

## __Função Racional__

> $ R(x) $ é diferenciável em $ D = \{ x \in \mathbb{R}: q(x) \neq 0 \} $

A derivada de $ R(x) $ é:

$$ R'(x) = \frac{P'(x) \cdot Q(x) - P(x) \cdot Q'(x)}{Q^2(x)} $$

## __Teorema da Derivada da Função Composta__

> $ f: D_f \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e diferenciável em $ a \in int(D_f) $

> $ g: D_g \subseteq \mathbb{R} \rightarrow \mathbb{R}, \ f(D_f) \subseteq D_g, $ e $ \ g \ $ diferenciável em $ f(a) $

$ g \circ f: D_f \subseteq \mathbb{R} \rightarrow \mathbb{R} $ é diferenciável em $ a $ e:

$$ (g \circ f)'(a) = g'(f(a)) \cdot f'(a) $$

## __Teorema da Derivada da Função Inversa__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ injetiva, $ a \in int(D) $ e $ f $ é diferenciável em $ a $

> $ f(a) = b \in int(f(D)) $

Se $ f^{-1} $ é diferenciável em $ b $, então:

$$ (f^{-1})'(b) = \frac{1}{f'(a)}, \ f'(a) \neq 0 $$

## __Regras de Derivação__

> $ u $ e $ v $ funções de $ x $

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ a, \ b \in \mathbb{R} $`

* $ (u \pm v)' = u' \pm v' $

* $ (u \cdot v)' = u' \cdot v + u \cdot v' $

* $ (\frac{u}{v})' = \frac{u' \cdot v - u \cdot v'}{v^2} $

* $ (\int_{u}^{v} f(t) \ dt)' = f(v) \cdot v' - f(u) \cdot u' $

* $ (a \cdot u)' = a \cdot u' $

* $ (u^a)' = a \cdot u^{a - 1} \cdot u' $

* $ (e^{u})' = e^{u} \cdot u' $

* $ (b^{u})' = b^{u} \cdot ln(b) \cdot u' $

* $ (u^v)' = e^{v \cdot ln(u)} \cdot (v' \cdot ln(u) + \frac{u'}{u} \cdot v) $

* $ (ln(u))' = \frac{u'}{u} $

* $ (log_{b}(u))' = \frac{u'}{u \cdot ln(b)} $

* $ (sen(x))' = cos(x) $

* $ (cos(x))' = -sen(x) $

* $ (sin(u))' = cos(u) \cdot u' $

* $ (cos(u))' = -sen(u) \cdot u' $

* $ (tan(u))' = \frac{u'}{cos^2(u)} \ \vee sec^2(u) \cdot u' $

* $ (cot(u))' = -\frac{u'}{sen^2(u)} \ \vee -cosec^2(u) \cdot u' $

* $ (sec(u))' = sec(u) \cdot tan(u) \cdot u' $

* $ (arcsin(u))' = \frac{u'}{\sqrt{1 - u^2}} $

* $ (arccos(u))' = -\frac{u'}{\sqrt{1 - u^2}} $

* $ (arctan(u))' = \frac{u'}{1 + u^2} $

* $ (f(u))' = f'(u) \cdot u' $