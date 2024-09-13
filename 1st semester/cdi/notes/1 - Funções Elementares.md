# __Funções Elementares__

## __Função Módulo__

$$ |x| = \begin{cases} x, & \text{se } x \geq 0 \\ -x, & \text{se } x < 0 \end{cases} $$

E.g.:

$$ |3| = 3 $$
$$ |-3| = -(-3) = 3 $$

### __Propriedades__

* $ |x| \geq 0, \ \forall \ x \in \mathbb{R} $

* $ |x| = 0 \Leftrightarrow x = 0 $

* $ \forall \ x, y \in \mathbb{R} \ |x \cdot y| = |x| \cdot |y| $
    * E.g.: $ |-3 \cdot 4| = |-12| = 12 = 3 \cdot 4 = |3| \cdot |4| $

* $ \forall \ x, y \in \mathbb{R} \ |x + y| \leq |x| + |y| $

### __Generalização__

* $ 
|x| \leq a \ \rightarrow \begin{cases} 
\text{Impossível em } \mathbb{R}, & \text{se } a < 0 
\\ x = a, & \text{se } a = 0
\\ -a \leq x \leq a, \ \text{com } x \in [-a, a], & \text{se } a > 0 \end{cases} 
$

* $
|x| < a \ \rightarrow \begin{cases}
-a < x < a, \ \text{com } x \in \ ]-a, a[, & \text{se } a > 0 \end{cases}
$


* $
|x| \geq a \ \rightarrow \begin{cases}
|x| \ge a <=> x \in \mathbb{R} \ (\text{Condição Universal }), & \text{se } a < 0
\\ x \leq -a \ \text{ou} \ x \geq a, \text{com } x \in \ ]-\infty, -a] \cup [a, +\infty[, & \text{se } a > 0 \end{cases}
$

* $
|x| > a \ \rightarrow \begin{cases}
x < -a \ \text{ou} \ x > a, \text{com } x \in \ ]-\infty, -a[ \cup ]a, +\infty[, & \text{se } a > 0 \end{cases}
$

## __Funções Reais de uma Variável Real__

> $ f: D \rightarrow \mathbb{R}, \ \text{com } D \subseteq \mathbb{R} $

Se $ D $ não for explicitamente indicado e a função for definida por uma expressão, então $ D $ é o __conjunto de todos os pontos__ em que a expressão pode ser calculada.

### __Restrição de Domínio__

Diz-se que uma função $ g: A \subseteq \mathbb{R} \rightarrow \mathbb{R} $ é uma __restrição__ de $ f: B \subseteq \mathbb{R} \rightarrow \mathbb{R} $ se:

* $ A \subseteq B \Rightarrow \forall \ x \in A, \ g(x) = f(x) $

E.g.:

$$

f(x) = \frac{1}{x}, D_f = \mathbb{R} \setminus \{0\}

\\ g: \mathbb{R}^+ \rightarrow \mathbb{R}, \ g(x) = \frac{1}{x}

\\ D_g = \mathbb{R}^+ \setminus \{0\} \ \text{logo g é uma restrição de } f \ \text{ao intervalo } \mathbb{R}^+

$$

### __Transformações de Intervalos__

> $ f: D \subseteq \mathbb{R} \rightarrow \mathbb{R} \ \text{e } A \subseteq D $

O __transformado__ do conjunto $ A $ é definido por:

* $ f(A) = \{ y \in \mathbb{R} \ | \ \exists \ x \in A, \ f(x) = y \} $







## __Função Exponencial__

> $ f(x) = e^x $

* $ f: \mathbb{R} \rightarrow \mathbb{R}^+ \ \text{e injetiva} $

## __Função Logarítmica__

> $ f(x) = \log_e x $

__Função inversa da função exponencial__, logo:

* $ f: \mathbb{R}^+ \rightarrow \mathbb{R} $

### __Propriedades__

* $ e^{\log_e x} = x, \ \forall \ x \in \mathbb{R}^+ $

* $ \log_e e^x = x, \ \forall \ x \in \mathbb{R} $

## __Funções Trigonométricas Inversas__

