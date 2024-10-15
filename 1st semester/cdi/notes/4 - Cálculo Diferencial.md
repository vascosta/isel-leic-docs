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

## __Derivadas Laterais__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ a \in D $

A derivada lateral à direita de $ f $ em $ x = a $ é:

$$ f'_d(a) = lim_{x \to a^+} \ \frac{f(x) - f(a)}{x - a} $$

A derivada lateral à esquerda de $ f $ em $ x = a $ é:

$$ f'_e(a) = lim_{x \to a^-} \ \frac{f(x) - f(a)}{x - a} $$

Se $ f $ é diferenciável em $ a $, então $ f'_d(a) = f'_e(a) = f'(a) $.

### __Exemplo__

$ f(x) = |x| $ e $ a = 0 $

* $ f'_d(0) = lim_{x \to 0^+} \ \frac{|x| - |0|}{x - 0} = lim_{x \to 0^+} \ \frac{x}{x} = 1 $

* $ f'_e(0) = lim_{x \to 0^-} \ \frac{|x| - |0|}{x - 0} = lim_{x \to 0^-} \ \frac{-x}{x} = -1 $

* Logo, $ f $ não é diferenciável em $ x = 0 $







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

## __Relação entre Diferenciabilidade e Continuidade__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ a \in int(D) $

Se $ f $ é diferenciável em $ a \Rightarrow f $ __é contínua__ em $ a $

Se $ f $ é contínua em $ a \Rightarrow f $ __não necessariamente é diferenciável__ em $ a $

### __Exemplo__

$ f(x) = |x| $ e $ a = 0 $

* $ f $ é contínua em $ x = 0 $ mas não é diferenciável em $ x = 0 $

## __Teorema de Rolle__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ [a, b] \subseteq D $

Se $ f $ é __contínua__ em $ [a, \ b] $ e __diferenciável__ em $ ]a, \ b[ $ tal que $ f(a) = f(b) $, então $ \exists \ c \in \ ]a, \ b[ $ tal que $ f'(c) = 0 $

### __Exemplo__

$ f(x) = \begin{cases} x^2.sen(\frac{1}{x}), \ se \ x \neq 0 \\ 0, \ se \ x = 0 \end{cases} $

$ [a,\  b] = [-\frac{1}{\pi}, \ \frac{1}{\pi}] $

* $ f $ é contínua em  $ \mathbb{R} $

* $ f $ é diferenciável em $ \mathbb{R} $ em particular em $ ]-\frac{1}{\pi}, \ \frac{1}{\pi}[ $

    * $ lim_{x \to 0} \ \frac{f(x) - f(0)}{x - 0} = lim_{x \to 0} \ \frac{x^2.sen(\frac{1}{x})}{x} = lim_{x \to 0} \ x.sen(\frac{1}{x}) = 0 $

    * $ f(\frac{1}{\pi}) = \frac{1}{\pi^2} \cdot sen(\pi) = 0 $

    * $ f(-\frac{1}{\pi}) = \frac{1}{\pi^2} \cdot sen(-\pi) = 0 $

        * $ \exists \ c \in \ ]-\frac{1}{\pi}, \ \frac{1}{\pi}[ $ tal que $ f'(c) = 0  \Rightarrow f'(x) $ tem pelo menos um zero em $ ]-\frac{1}{\pi}, \ \frac{1}{\pi}[ $

### __Corolário__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e diferenciável em $ ]a, \ b[ $

Entre 2 zeros de $ f(x) $, $ \exists \ $ pelo menos um zero de $ f'(x) $

Entre 2 zeros consecutivos de $ f'(x) $, $ \exists \ $ no máximo um zero de $ f(x) $

## __Teorema de Lagrange__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ [a, \ b] \subseteq D $

> $ f $ é __contínua__ em $ [a, \ b] $ e __diferenciável__ em $ ]a, \ b[ $

Então, $ \exists \ c \in \ ]a, \ b[ $ tal que:

$$ f'(c) = \frac{f(b) - f(a)}{b - a} $$

$ f'(c) $ é igual ao declive que une os pontos $ (a, \ f(a)) $ e $ (b, \ f(b)) $

### __Exemplo__

$ f(x) = sen(x) $ e $ [a, \ b] = [-x, \ x] $

* $ f $ é diferenciável em $ \mathbb{R} \Rightarrow f $ é contínua em $ \mathbb{R} \Rightarrow f $ é contínua em $ [-x, \ x] \Rightarrow \exists \ c \in \ ]-x, \ x[ $ tal que $ f'(c) = \frac{f(x) - f(-x)}{x - (-x)} $

    * $ f'(x) = cos(x) $

    * $ f(-x) = sen(-x) = -sen(x) $

    * $ f(x) = sen(x) $

    * $ f'(c) = \frac{f(x) - f(-x)}{x - (-x)} = \frac{sen(x) + sen(x)}{2x} = \frac{2sen(x)}{2x} = \frac{sen(x)}{x} $

### __Corolário__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e diferenciável em $ ]a, \ b[ $

* Se $ f'(x) = 0 \ \geq 0 \ \forall \ x \in ]a, \ b[ \ \Rightarrow f $ é crescente em $ ]a, \ b[ $

* Se $ f'(x) = 0 \ > 0 \ \forall \ x \in ]a, \ b[ \ \Rightarrow f $ é estritamente crescente em $ ]a, \ b[ $

* Se $ f'(x) = 0 \ \leq 0 \ \forall \ x \in ]a, \ b[ \ \Rightarrow f $ é decrescente em $ ]a, \ b[ $

* Se $ f'(x) = 0 \ < 0 \ \forall \ x \in ]a, \ b[ \ \Rightarrow f $ é estritamente decrescente em $ ]a, \ b[ $

## __Teorema de Couchy__

> $ f, \ g: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ [a, \ b] \subseteq D $

> $ f, \ g $ são __contínuas__ em $ [a, \ b] $ e __diferenciáveis__ em $ ]a, \ b[ $

> $ g'(x) \neq 0 \ \forall \ x \in \ ]a, \ b[ $

Então, $ \exists \ c \in \ ]a, \ b[ $ tal que:

$$ \frac{f'(c)}{g'(c)} = \frac{f(b) - f(a)}{g(b) - g(a)} $$

### __Regra de Couchy__

> $ f, \ g: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ c \in int(D) $ 

> $ f, \ g $ são __diferenciáveis__ em $ I \setminus \{c\} $ e $ g'(x) \neq 0, \ \forall \ x \in I \setminus \{c\} $

Se $ lim_{x \to c} \ \frac{f(x)}{g(x)} = \frac{0}{0} \ \vee \ \frac{\pm \infty}{\pm \infty} $ e $ \exists \ lim_{x \to c} \ \frac{f'(x)}{g'(x)} $, então:

$$ lim_{x \to c} \ \frac{f(x)}{g(x)} = lim_{x \to c} \ \frac{f'(x)}{g'(x)} $$

#### __Exemplo__

$ lim_{x \to 0} \ \frac{sen(x)}{x} = lim_{x \to 0} \ \frac{cos(x)}{1} = 1 $

$ lim_{x \to 0} \ \frac{cos(x) - 1}{x} = lim_{x \to 0} \ \frac{-sen(x)}{1} = 0 $

$ lim_{x \to 0} \ \frac{e^x - 1}{x} = lim_{x \to 0} \ \frac{e^x}{1} = 1 $

$ lim_{x \to 0} \ \frac{ln(1 + x)}{x} = lim_{x \to 0} \ \frac{\frac{1}{1 + x}}{1} = 1 $

$ lim_{x \to 0} \ \frac{ln (cos(x))}{x} = lim_{x \to 0} \ \frac{-sen(x)}{cos(x)} = 0 $

## __Derivadas de Ordem n__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $

Se $ f $ é __diferenciável__ em $ D $, então a derivada de ordem $ n $ de $ f $ é:

$$ f^{(n)}(x) = (f^{(n - 1)})'(x) $$


## __Função de Classe__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $

Diz-se que f é de Classe $ C^n $ em $ D $ se $ f^n $ é contínua em $ D $.

### __Exemplo__

$ f(x) = \begin{cases} x^2, \ se \ x > 0 \\ -x^2, \ se \ x < 0 \end{cases} $

* $ f'(x) = \begin{cases} 2x, \ se \ x > 0 \\ -2x, \ se \ x < 0 \end{cases} $

    * $ f'_d(0) = lim_{x \to 0^+} \ \frac{x^2 - 0^2}{x - 0} = lim_{x \to 0^+} \ x = 0 $

    * $ f'_e(0) = lim_{x \to 0^-} \ \frac{-x^2 - 0^2}{x - 0} = lim_{x \to 0^-} \ -x = 0 $

    * $ f'(0) $ não existe

    * $ f' $ é contínua em $ \mathbb{R} $

    * $ f'$ não é diferenciável em $ x = 0 \Rightarrow f $ não é de Classe $ C^1 $ em $ \mathbb{R} $

## __Polinómio de Taylor__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ I $ intervalo aberto

> $ f $ é  $ n $ vezes diferenciável em $ x = a \in I $

O polinómio de Taylor de ordem $ n $ de $ f $ em torno de $ x = a $ é:

$$ P_n(x) = f(a) + f'(a)(x - a) + \frac{f''(a)}{2!}(x - a)^2 + \ldots + \frac{f^{(n)}(a)}{n!}(x - a)^n $$

### __Fórmula de Taylor__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} $ e $ I $ intervalo aberto

> $ f $ é  $ n + 1 $ vezes diferenciável num intervalo aberto $ I $ que contém $ \{a, \ x\} $

A fórmula de Taylor de ordem $ n $ de $ f $ em torno de $ x = a $ é:

$$ f(x) = P_n(x) + R_n(x) = P_n(x) + \frac{f^{(n + 1)}(c)}{(n + 1)!}(x - a)^{n + 1} $$

## __Polinómio de Maclaurin__

Polinómio de Taylor de ordem $ n $ de $ f $ em torno de $ x = 0 $ é o polinómio de Maclaurin de ordem $ n $ de $ f $:

$$ P_n(x) = f(0) + f'(0)x + \frac{f''(0)}{2!}x^2 + \ldots + \frac{f^{(n)}(0)}{n!}x^n $$

### __Fórmula de Maclaurin__

Formula de Taylor de ordem $ n $ de $ f $ em torno de $ x = 0 $ é:

$$ f(x) = P_n(x) + R_n(x) = f(0) + f'(0)x + \frac{f''(0)}{2!}x^2 + \ldots + \frac{f^{(n + 1)}(c)}{(n + 1)!}(-a)^{n + 1}