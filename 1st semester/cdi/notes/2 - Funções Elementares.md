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

E.g.:

$ f(x) = 2x \ \text{e} \ D = \mathbb{R} $

$ f([0, 1]) = [0, \ 2] $

$ CD = f(D) = f(\mathbb{R}) = \mathbb{R} $

### __Injetividade__

Uma função é injetiva se cada ponto do CD corresponder a um único ponto do D:

* $ \forall \ z \in CD: z = f(x) \ \wedge \ z = f(y) \Rightarrow x = y $

E.g.:

$ f(x) = 2x $ é injetiva

$ g(x) = x^2 $ não é injetiva

### __Função Inversa__

Se $ f $ é uma função injetiva, então a função inversa de $ f $ é a função $ f^{-1} $ tal que:	

$$ f^{-1}: f(D) \rightarrow D $$

$$ f^{-1}(f(x)) = x, \ \forall \ x \in D $$

E.g.:

$ f(x) = 2x $ é injetiva logo tem inversa

* $ f^{-1}(x) = \frac{x}{2} $

* $ f^{-1}(f(x)) = x \ (=) \ f(\frac{x}{2}) = x \ (=) \ x = x $

$ g(x) = x^2 $ não é injetiva logo não tem inversa

Sendo h a restrição de g a $ \mathbb{R}^+ $, então h é injetiva e tem inversa

## __Função Exponencial__

> $ f(x) = a^x $

* $ f: \mathbb{R} \rightarrow \mathbb{R}^+ $ com $ CD = f(\mathbb{R}) = \mathbb{R}^+ \ \text{e injetiva} $

## __Função Exponencial Potência__

> $ f(x) = e^x $

* $ f: \mathbb{R} \rightarrow \mathbb{R}^+ $ com $ CD = f(\mathbb{R}) = \mathbb{R}^+ \ \text{e injetiva} $

### __Propriedades__

* $ e^0 = 1 $

* $ e^{x + y} = e^x \cdot e^y \ \forall \ x, y \in \mathbb{R} $

* $ e^{x - y} = \frac{e^x}{e^y} \ \forall \ x, y \in \mathbb{R} $

* $ e^{x \cdot y} = (e^x)^y = (e^y)^x \ \forall \ x, y \in \mathbb{R} $

* $ a^x = e^{x \cdot \ln a} \ \forall \ a > 0 \wedge a \neq 1 \wedge x \in \mathbb{R} $

## __Função Logarítmica__

> $ f(x) = \log_a x $ ou $ f(x) = \ln x $ com $ a > 0 \wedge a \neq 1 $

__Função inversa da função exponencial__, logo:

* $ f: \mathbb{R}^+ \rightarrow \mathbb{R} $

### __Propriedades__

Para $ a > 0 \wedge a \neq 1 $:

* $ \log_a 1 = 0 $

* $ \log_a a^x = x $

* $ \log_a (x \cdot y) = \log_a x + \log_a y $ se $ x, y > 0 $

* $ \log_a \frac{x}{y} = \log_a x - \log_a y $ se $ x, y > 0 $

* $ \log_a x^y = y \cdot \log_a x $

* $ a^{\log_a x} = x \ \forall \ x > 0 $

* $ a^{\log_a x + \log_a y} = x \cdot y \ \forall \ x, y > 0 $	

* $ \log_a x = \frac{\ln x}{\ln a} $

* $ \ln x = \ln a \cdot \log_a x $

* $ \ln (x \cdot y) = \ln x + \ln y $ se $ x, y > 0 $

* $ \ln \frac{x}{y} = \ln x - \ln y $ se $ x, y > 0 $

* $ \ln x^y = y \cdot \ln x $

## __Funções Trigonométricas Inversas__

> Uma vez que as funções trigonométricas são periódicas, não são injetivas, logo é necessário restringir o seu domínio para que sejam injetivas

### __Função Arco Seno__
> __Restrição principal__ da função seno é $ f: [-\frac{\pi}{2}, \ \frac{\pi}{2}] \rightarrow \mathbb{R} $ com $ CD = f([-\frac{\pi}{2}, \ \frac{\pi}{2}]) = [-1, \ 1] $

A função __arco seno é a função inversa da função seno__ definida por:

$$ f^{-1} = \arcsin x, \ \forall \ x \in [-1, \ 1] $$

$$ \arcsin x = y \Leftrightarrow \sin y = x, \ y \in [-\frac{\pi}{2}, \ \frac{\pi}{2}] $$

### __Função Arco Cosseno__

> __Restrição principal__ da função cosseno é $ f: [0, \ \pi] \rightarrow \mathbb{R} $ com $ CD = f([0, \ \pi]) = [-1, \ 1] $

A função __arco cosseno é a função inversa da função cosseno__ definida por:

$$ f^{-1} = \arccos x, \ \forall \ x \in [-1, \ 1] $$

$$ \arccos x = y \Leftrightarrow \cos y = x, \ y \in [0, \ \pi] $$

### __Função Arco Tangente__

> __Restrição principal__ da função tangente é $ f: ]-\frac{\pi}{2}, \ \frac{\pi}{2}[ \rightarrow \mathbb{R} $ e $ \cos x \neq 0 $

A função __arco tangente é a função inversa da função tangente__ definida por:

$$ f^{-1} = \arctg x, \ \forall \ x \in \mathbb{R} $$

$$ \arctg x = y \Leftrightarrow \tan y = x, \ y \in \ ]-\frac{\pi}{2}, \ \frac{\pi}{2}[ $$

### __Função Arco Cotangente__

> __Restrição principal__ da função cotangente é $ f: ]0, \ \pi[ \rightarrow \mathbb{R} $ e $ \sin x \neq 0 $

A função __arco cotangente é a função inversa da função cotangente__ definida por:

$$ f^{-1} = arccotg \ x, \ \forall \ x \in \mathbb{R} $$

$$ arccotg \ x = y \Leftrightarrow \cotg \ y = x, \ y \in \ ]0, \ \pi[ $$

### __Propriedades__

* $ \cos^2 x + \sin^2 x = 1 $

* $ \sin(x \pm y) = \sin x \cos y \pm \cos x \sin y $

* $ \sin 2x = 2 \sin x \cos x $

* $ \cos(x \pm y) = \cos x \cos y \mp \sin x \sin y $

* $ \cos 2x = \cos^2 x - \sin^2 x $

* $ \sin^2 x = \frac{1 - \cos 2x}{2} $

* $ \cos^2 x = \frac{1 + \cos 2x}{2} $

* $ \sin x = \frac{2 \tan \frac{x}{2}}{1 + \tan^2 \frac{x}{2}} $

* $ \cos x = \frac{1 - \tan^2 \frac{x}{2}}{1 + \tan^2 \frac{x}{2}} $