# __Cálculo Integral__


## __Primitiva__

> $ f: I \rightarrow \mathbb{R} $, $ I $ intervalo aberto

Uma função $ F(x) $ é primitiva de $ f(x) $ em $ I $ sse $ F'(x) = f(x), \ \forall \ x \in I $ e designa-se por:

$$ P[f(x)] = F(x) $$

O conjunto de __todas as primitivas__ de $ f(x) $ em $ I $ é designado por:

$$ \int f(x) \ dx = F(x) $$

### __Propriedades__

* Se $ F(x) $ é primitiva de $ f(x) $ em $ I $, então $ F(x) + C $ é primitiva de $ f(x) $ em $ I $, $ C \in \mathbb{R} $ constante.

* Se $ F(x) $ e $ G(x) $ são primitivas de $ f(x) $ em $ I $, então $ F(x) = G(x) + C $, $ C \in \mathbb{R} $ constante.


### __Exemplos__

Qual a primitiva de $ f(x) = \frac{1}{x} $ que verifica $ F(1) = 0 $ e $ F(-e) = 1 $?

* $ F(x) = \begin{cases} \ln (x) + K_1, \ x > 0 \\ \ln (-x) + K_2, \ x < 0 \end{cases} $

* $ F(1) = 0 \Rightarrow ln(1) + K_1 = 0 \Rightarrow K_1 = 0 $

* $ F(-e) = 1 \Rightarrow ln(e) + K_2 = 1 \Rightarrow K_2 = 1 $

    * $ F(x) = \begin{cases} \ln (x), \ x > 0 \\ \ln (-x) + 1, \ x < 0 \end{cases} $

## __Regras de Primitivação__

> $ u, v $ funções deriváveis e $ K $ constante

### __Primitivas Imediatas__

* $ P[u + v] = P[u] + P[v] $

* $ P[Ku] = KP[u] $

* $ P[K] = Kx $

* $ P[u'.u^n] = \frac{u^{n+1}}{n+1}, \ n \neq -1 $

* $ P[\frac{u'}{u}] = \ln |u| $

* $ P[\frac{u'}{1 + u^2}] = \arctan(u) $

* $ P[\frac{u'}{\sqrt{1 - u^2}}] = \arcsin(u) $

* $ P[\frac{u'}{a^2 + u^2}] = \frac{1}{a}.arctan(\frac{u}{a}) $

* $ P[u'.sen(u)] = -cos(u) $

* $ P[u'.cos(u)] = sen(u) $

* $ P[u'.sec^2(u)] = tg(u) $

* $ P[u'.cosec^2(u)] = -cotg(u) $

* $ P[u'.sec(u).tg(u)] = sec(u) $

* $ P[u'.cosec(u).cotg(u)] = -cosec(u) $

* $ P[u'.e^u] = e^u $

* $ P[u'.a^u] = \frac{a^u}{\ln a} $

* $ P[u'.sinh(u)] = cosh(u) $

* $ P[u'.cosh(u)] = sinh(u) $

#### __Exemplos__

$ \int sen(x).cos^2(x) \ dx = 
\\ \int (-(-sen(x)).(cos(x))^2)\ dx = 
\\ -\int -sen(x).cos^2(x) \ dx = - \frac{cos(x)^3}{3} 
$

#

$ \int x.e^{x^2} \ dx = 
\\ \frac{1}{2}.\int 2x.e^{x^2} \ dx = \frac{1}{2}e^{x^2} 
$

# 

$ \int 2^{x-1} \ dx = 
\\ \int (e^{ln (2)})^{x-1} \ dx = 
\\ \int e^{(x-1).ln(2)} \ dx = 
\\ \frac{1}{ln(2)}.\int ln(2).e^{(x-1).ln(2)} \ dx = \frac{e^{(x-1).ln(2)}}{ln(2)}  
$

#

$ \int \frac{x^3}{1+x^8} \ dx = 
\\ \int \frac{x^3}{1+(x^4)^2} \ dx = 
\\ \frac{1}{4}\int \frac{4x^3}{1+(x^4)^2} \ dx = \frac{arctg(x^4)}{4} 
$

#

$ \int \frac{e^x}{\sqrt{1-e^{2x}}} \ dx = 
\\ \int \frac{e^x}{\sqrt{1-(e^x)^2}} \ dx = arcsen(e^x) 
$

#

$ \int \frac{x^3}{1+x^4} \ dx =
\\ \frac{1}{4} \int \frac{4x^3}{1+x^4} \ dx = 
\\ \frac{ln(1+x^4)}{4} 
$

#

$ \int \frac{e^x}{\sqrt{1-e^x}} \ dx = 
\\ \int e^x(1-e^x)^{-\frac{1}{2}} \ dx = 
\\ \int (-(-e^x))(1-e^x)^{-\frac{1}{2}} \ dx = 
\\ - \int -e^x(1-e^x)^{-\frac{1}{2}} \ dx = 
\\ -(\frac{(1-e^x)^{-\frac{1}{2}}}{-\frac{1}{2}+1}) = -2(1-e^x)^{\frac{1}{2}} 
$

#

$ \int \frac{5x^2}{9 + x^6} \ dx = 
\\ \int \frac{1}{9}.\frac{5x^2}{1+\frac{x^6}{9}} \ dx = 
\\ \frac{5}{9} \int \frac{x^2}{1+(\frac{x^3}{3})^2} \ dx = \frac{5}{9}.arctg(\frac{x^3}{3}) 
$

### __Primitivas Quase Imediatas__

* $ P[u'.tan(u)] = -ln|cos(u)| $

* $ P[u'.cotg(u)] = ln|sen(u)| $

* $ P[u'.sec(u)] = ln|sec(u) + tg(u)| $

* $ P[u'.cosec(u)] = - ln|cosec(u) + cotg(u)| $

### __Primitivação por Partes__

* $ P[u'.v] = u.v - P[u.v'] $

#### __Exemplos__

$ \int x.ln(x) \ dx = 
\\ \frac{x^2.ln(x)}{2} - \int \frac{x^2}{2}. \frac{1}{x} \ dx = 
\\ \frac{x^2.ln(x)}{2} - \int \frac{x}{2} \ dx = \frac{x^2.ln(x)}{2} - \frac{x^2}{4} 
$

#

$ \int ln(x) \ dx = 
\\ \int 1.ln(x) \ dx = 
\\ x.ln(x) - \int x.\frac{1}{x} \ dx = 
\\ x.ln(x) - \int 1 \ dx = x.ln(x) - x 
$

#

$ \int x.sen(x) \ dx = 
\\ -x.cos(x) + \int 1.cos(x) \ dx = -x.cos(x) + sen(x) 
$

#

$ \int x^2.e^{-x} \ dx = -x^2.e^{-x} + \int 2x.e^{-x} \ dx = 
\\ -x^2.e^{-x} - 2\int x.e^{-x} \ dx = 
\\ -x^2.e^{-x} - 2(-x.e^{-x} + \int 1.e^{-x} \ dx) = -x^2.e^{-x} - 2x.e^{-x} - 2e^{-x} 
$

#

$ \int e^{-x}.cos(x) \ dx = 
\\ e^{-x}.sen(x) + \int e^{-x}.sen(x) \ dx = 
\\ e^{-x}.sen(x) + \int e^{-x}.sen(x) \ dx = 
\\ e^{-x}.sen(x) + (-e.x.cos(x) - \int -e^{-x}.cos(x) \ dx) 
$

$ \int e^{-x}.cos(x) \ dx = e^{-x}.sen(x) - e^{-x}.cos(x) - \int e^{-x}.cos(x) \ dx \ (=) 
\\ 2\int e^{-x}.cos(x) \ dx = e^{-x}(sen(x) - cos(x)) \ (=) 
\\ \int e^{-x}.cos(x) \ dx = \frac{e^{-x}(sen(x) - cos(x))}{2} 
$

#

$ \int sen^2(x) \ dx = 
\\ \int sen(x).sen(x) \ dx = 
\\ -cos(x).sen(x) + \int cos(x).cos(x) \ dx =
\\ -cos(x).sen(x) + \int 1 - sen^2(x) \ dx = 
\\ -cos(x).sen(x) + x - \int sen^2(x) \ dx \ (=)
\\ 2\int sen^2(x) \ dx = x - cos(x).sen(x) \ (=) 
\\ \int sen^2(x) \ dx = \frac{x}{2} - \frac{cos(x).sen(x)}{2} 
$

#

$ \int \frac{x}{(1+x^2)^2} \ dx = 
\\ \frac{1}{2} \int 2x(1+x^2)^{-2} dx = 
\\ \frac{1}{2} . \frac{(1+x^2)^{-2+1}}{-2+1} = 
\\ \frac{1}{2}. \frac{(1+x^2)^{-1}}{-1} = -\frac{1}{2(1+x^2)} 
$

#

$ \int \frac{x^2}{(1+x^2)^2} \ dx = 
\\ \int x.\frac{x}{(1+x^2)^2} \ dx = 
\\ x.(-\frac{1}{2(1+x^2)}) + \int 1.(\frac{1}{2(1+x^2)}) \ dx = -\frac{x}{2(1+x^2)} + 2arctg(x) $

### __Primitivação por Substituição__
* $ \int f(x) \ dx = \int f(\phi(t)) \frac{dx}{dt} \ dt $

    * Se $ f(x) $ contêm o fator $\sqrt{a^2 - x^2}$, então $ x = a.sen(t) \vee x = a.cos(t) $

    * Se $ f(x) $ contêm o fator $\sqrt{x^2 + a^2}$, então $ x = a.tg(t) $

    * Se $ f(x) = A.sen(x).cos(x), A \in \mathbb{R} \Rightarrow x = arcsen(t) \wedge t = sen(x) $

    * Se $ f(x) = A.cos(x).sen(x), A \in \mathbb{R} \Rightarrow x = arccos(t) \wedge t = cos(x) $

#### __Exemplos__

$ \int \frac{1}{e^x - 1} \ dx $

* $ t = e^x $

* $ x = ln(t) = \phi(t) $

* $ \frac{1}{t} = \phi'(t) $

$ \Rightarrow \int \frac{1}{t - 1}. \frac{1}{t} \ dt = \int \frac{1}{t(t-1)} \ dt = \frac{A}{t} + \frac{B}{t-1} $

* Reduzindo ao mesmo denominador: $ 1 = A(t-1) + Bt $

    * Com $ t = 0 $:
        * $ 1 = -A \Rightarrow A = -1 $

    * Com $ t = 1 $:
        * $ 1 = B \Rightarrow B = 1 $

$ \Rightarrow -\int \frac{1}{t} \ dt + \int \frac{1}{t-1} \ dt =
\\ -ln|t| + ln|t-1| =
\\ -ln|e^x| + ln|e^x - 1| =
\\ -x + ln(e^x - 1) + C, \ C \in \mathbb{R} $

#

$ \int \sqrt{9 - x^2} \ dx $

* $ x = 3.sen(t) = \phi(t) $

* $ x^2 = 9.sen^2(t) = \phi^2(t) $

* $ 3.cos(t) = \phi'(t) $

* $ sen(t) = \frac{x}{3} \Rightarrow t = arcsen(\frac{x}{3}) $


$ \Rightarrow \int \sqrt{9 - 9.sen^2(t)} \ \ .3.cos(t) \ dt =
\\ \int 3.\sqrt{1 - sen^2(t)} \ \ .3.cos(t) \ dt =
\\ 9.\int \sqrt{cos^2(t)} \ \ .cos(t) \ dt =
\\ 9.\int cos(t) \ \ .cos(t) \ dt =
\\ 9.\int cos^2(t) \ dt =
\\ 9.\int \frac{1}{2} + \frac{cos(2t)}{2} \ dt =
\\ 9.\frac{t}{2} + 9.\frac{sen(2t)}{4} =
\\ \frac{9}{2}.arcsen(\frac{x}{3}) + \frac{9}{4}.sen(2.arcsen(\frac{x}{3})) + C, \ C \in \mathbb{R} $
$

#

$ \int \frac{2.sen(x).cost(x)}{2 + sen(x)^2} \ dx $

* $ t = sen(x) $

* $ x = arcsen(t) = \phi(t) $

* $ \frac{1}{\sqrt{1 - t^2}} = \phi'(t) $

* $ cos(x) = \sqrt{1 - sen^2(x)} = \sqrt{1 - t^2} $

$ \Rightarrow \int \frac{2.t.\sqrt{1 - t^2}}{(2 + t)^2} \ \ .\frac{1}{\sqrt{1 - t^2}} \ dt =
\\ \int \frac{2t}{(2 + t)^2} \ dt =
\\ \frac{A}{2 + t} + \frac{B}{(2 + t)^2} $

* Reduzindo ao mesmo denominador: $ 2t = A(2 + t) + B $

    * Com $ t = -2 $:
        * $ -4 = B \Rightarrow B = -4 $

    * Com $ t = 0 $:
        * $ 0 = 2A - 4 \Rightarrow A = 2 $

$ \Rightarrow \int \frac{2}{2 + t} \ dt - \int \frac{4}{(2 + t)^2} \ dt = 
\\ 2.ln|2 + t| - 4.\int (2 + t)^{-2} \ dt =
\\ 2.ln|2 + t| + \frac{4}{2 + t} =
\\ 2.ln|2 + sen(x)| + \frac{4}{2 + sen(x)} + C, \ C \in \mathbb{R} $

#

$ \int \frac{2.ln(x) - 1}{x.ln(x).(ln(x) -1)^2} \ dx $

* $ t = ln(x) $

* $ x = e^t = \phi(t) $

* $ e^t = \phi'(t) $

$ \Rightarrow \int \frac{2t - 1}{e^t.t(t - 1)^2} \ \ .e^t \ dt = 
\\ \int \frac{2t - 1}{t(t - 1)^2} \ dt =
\\ \frac{A}{t} + \frac{B}{t - 1} + \frac{C}{(t - 1)^2} $

* Reduzindo ao mesmo denominador: $ 2t - 1 = A(t - 1)^2 + B.t(t - 1) + C.t $

    * Com $ t = 0 $:
        * $ -1 = A \Rightarrow A = -1 $

    * Com $ t = 1 $:
        * $ 1 = C \Rightarrow C = 1 $

    * Comparar os coeficientes de $ t^2 $:
        * $ 0 = A + B \Rightarrow B = 1 $

$ \Rightarrow -\int \frac{1}{t} \ dt + \int \frac{1}{t - 1} \ dt + \int \frac{1}{(t - 1)^2} \ dt = 
\\ -ln|t| + ln|t - 1| - \frac{1}{t - 1} =
\\ -ln|ln(x)| + ln|ln(x) - 1| - \frac{1}{ln(x) - 1} + C, \ C \in \mathbb{R} $
$

#

$ \int \frac{1}{tg(x) + 1} \ dx $

* $ t = tg(x) $

* $ x = arctg(t) = \phi(t) $

* $ \frac{1}{1 + t^2} = \phi'(t) $

$ \Rightarrow \int \frac{1}{t + 1} \ \ .\frac{1}{1 + t^2} \ dt =
\\ \int \frac{1}{(t + 1)(1 + t^2)} \ dt =
\\ \frac{A}{t + 1} + \frac{Bt + C}{1 + t^2} $

* Reduzindo ao mesmo denominador: $ 1 = A(1 + t^2) + (Bt + C)(t + 1) $

    * Com $ t = -1 $:
        * $ 1 = 2A \Rightarrow A = \frac{1}{2} $

    * Comparar os coeficientes de $ t ^2 $:
        * $ 0 = A + B \Rightarrow B = -\frac{1}{2} $

    * Comparar os coeficientes de $ t $:
        * $ 0 = B + C \Rightarrow C = \frac{1}{2} $

$ \Rightarrow \int \frac{\frac{1}{2}}{t + 1} \ dt - \int \frac{\frac{1}{2}t + \frac{1}{2}}{1 + t^2} \ dt =
\\ \frac{1}{2}.\int \frac{1}{t + 1} \ dt - \frac{1}{2}.\int \frac{t + 1}{1 + t^2} \ dt =
\\ \frac{1}{2}.ln|t + 1| - \frac{1}{2}.(\int \frac{t}{1 + t^2} \ dt + \int \frac{1}{1 + t^2} \ dt) =
\\ \frac{lnt|t + 1|}{2} - \frac{1}{4}.ln|1 + t^2| + \frac{1}{2}.arctg(t) =
\\ \frac{ln|tg(x) + 1|}{2} - \frac{1}{4}.ln|1 + tg^2(x)| + \frac{x}{2} + C, \ C \in \mathbb{R} $

#

$ \int \frac{1}{\sqrt{4 + x^2}} \ dx $

* $ x = 2.tg(t) = \phi(t) $

* $ x^2 = 4.tg^2(t) = \phi^2(t) $

* $ 2.sec^2(t) = \phi'(t) $

* $ tg(t) = \frac{x}{2} \Rightarrow t = arctg(\frac{x}{2}) $

$ \Rightarrow \int \frac{1}{\sqrt{4 + 4.tg^2(t)}} \ \ .2.sec^2(t) \ dt = 
\\ \int \frac{2}{\sqrt{4 + 4.tg^2(t)}} \ \ .sec^2(t) \ dt =
\\ \int \frac{1}{\sqrt{1 + tg^2(t)}} \ \ .sec^2(t) \ dt =
\\ \int \frac{sec^2(t)}{sec(t)} \ dt =
\\ \int sec(t) \ dt = 
\\ ln|sec(t) + tg(t)| =
\\ ln|sec(arctg(\frac{x}{2})) + \frac{x}{2}| + C, \ C \in \mathbb{R} $

#
#

## __Fração Própria__

> $ f(x) = \frac{N(x)}{D(x)} $

Se grau de $ N(x) < $ grau de $ D(x) $, então $ f(x) $ é uma __fração própria__.

Se grau de $ N(x) \geq $ grau de $ D(x) $, então $ f(x) $ é uma __fração imprópria__ e é possível dividir os polinómios:

$$ f(x) = Q(x) + \frac{R(x)}{D(x)} $$

Se o grau de $ R(x) < $ grau de $ D(x) $, então $ f(x) $ é uma __fração própria__.

### __Exemplos__

$ f(x) = \frac{x + 3}{x + 2} = \frac{x + 2 + 1}{x + 2} = 1 + \frac{1}{x + 2} $

* $ \int \frac{x + 3}{x + 2} \ dx = \int 1 + \frac{1}{x + 2} \ dx = x + ln|x + 2| $

#

$ f(x) = \frac{x^2 + 2x + 5}{x - 1} = $ (Regra de Ruffini) $ x + 3 + \frac{8}{x - 1} $

* $ \int \frac{x^2 + 2x + 5}{x - 1} \ dx = \int x + 3 + \frac{8}{x - 1} \ dx = \frac{x^2}{2} + 3x + 8.ln|x - 1| $

#
#

## __Decomposição de Frações Próprias em Frações Simples__

> $ f(x) = \frac{R(x)}{D(x)} $

* $ D(x) $ tem raízes reais simples $ a_1, a_2, ..., a_n \Rightarrow f(x) = \frac{A_1}{x - a_1} + \frac{A_2}{x - a_2} + ... + \frac{A_n}{x - a_n} \ $, $ A_1, A_2, ..., A_n $ constantes.

* $ D(x) $ tem raízes reais múltiplas e se admite a raiz real $ a $ com multiplicidade $ m \Rightarrow f(x) = \frac{A_1}{x - a} + \frac{A_2}{(x - a)^2} + ... + \frac{A_m}{(x - a)^m} \ $, $ A_1, A_2, ..., A_m $ constantes.

* $ D(x) $ tem as raízes complexas conjugadas $ \alpha + \beta i, \beta \neq 0, \ $ com multiplicidade m $ \Rightarrow f(x) = \frac{B_x + C}{(x - \alpha)^2 + \beta_i^2} + \frac{D_x + E}{(x - \alpha)^2 + \beta_i^2} + ... + \frac{G_x + H}{(x - \alpha)^2 + \beta_i^2} \ $, $ B_x, C, D_x, E, ..., G_x, H $ constantes.
### __Exemplos__

$ f(x) = \frac{x}{x^2 + x - 2} = $ (Fórmula Resolvente) $ \frac{x}{(x + 2)(x - 1)} = \frac{A}{x + 2} + \frac{B}{x - 1} $

* Reduzindo ao mesmo denominador: $ x = A(x - 1) + B(x + 2) $

    * Com $ x = 1 $:
        * $ 1 = 3B \Rightarrow B = \frac{1}{3} $

    * Com $ x = -2 $:
        * $ -2 = -3A \Rightarrow A = \frac{2}{3} $

* $ \int \frac{x}{x^2 + x - 2} \ dx = \int \frac{2}{3(x + 2)} + \frac{1}{3(x - 1)} \ dx = \frac{2}{3}.ln|x + 2| + \frac{1}{3}.ln|x - 1| + C, \ C \in \mathbb{R} $

#

$ f(x) = \frac{2x + 1}{(x-1)^2} = \frac{A}{x - 1} + \frac{B}{(x - 1)^2} $

* Reduzindo ao mesmo denominador: $ 2x + 1 = A(x - 1) + B $

    * Com $ x = 1 $:
        * $ 3 = B \Rightarrow B = 3 $

    * Comparando os coeficientes de $ x $:
        * $ 2 = A $

* $ \int \frac{2x + 1}{(x-1)^2} \ dx = \int \frac{2}{x - 1} + \frac{3}{(x - 1)^2} \ dx = 2.ln|x - 1| + 3.\int (x - 1)^{-2} \ dx $

    * $ \int (x - 1)^{-2} \ dx = \int \frac{(x-1)^{-2+1}}{-2+1} \ dx = \frac{(x-1)^{-1}}{-1} = -\frac{1}{x - 1} $

* $ 2.ln|x - 1| - \frac{3}{x - 1} + C, \ C \in \mathbb{R} $

#

$ f(x) = \frac{x + 3}{x^3 -2x^2 + 3x} = \frac{x + 3}{x(x^2 - 2x + 3)} = \frac{A}{x} + \frac{Bx + C}{x^2 - 2x + 3} $

* Reduzindo ao mesmo denominador: $ x + 3 = A(x^2 - 2x + 3) + (Bx + C)x $

    * Com $ x = 0 $:
        * $ 3 = 3A \Rightarrow A = 1 $

    * Comparando os coeficientes de $ x $:
        * $ 0 = A + B \Rightarrow B = -1 $

    * Comparando os coeficientes de $ x^2 $:
        * $ 1 = -2A + C \Rightarrow C = 3 $

* $ \int \frac{x + 3}{x^3 -2x^2 + 3x} \ dx = \int \frac{1}{x} + \frac{-x + 3}{x^2 - 2x + 3} \ dx = ln|x| - \int \frac{x - 3}{x^2 - 2x + 3} \ dx $

    * $ \int \frac{x - 3}{x^2 - 2x + 3} \ dx = \frac{1}{2} \int \frac{2x - 2}{x^2 - 2x + 3} \ dx = \frac{1}{2} \int \frac{2x - 2}{x^2 - 2x + 3} \ dx  = \frac{1}{2} \int \frac{2x - 2 - 4}{x^2 - 2x + 3} \ dx = \frac{1}{2} \int \frac{2x - 2}{x^2 - 2x + 3} - \frac{4}{x^2 - 2x + 3} \ dx = \frac{1}{2}.ln|x^2 - 2x + 3| - 2\int \frac{1}{x^2 - 2x + 3} \ dx $

        * $ \int \frac{1}{x^2 - 2x + 3} \ dx = \int \frac{1}{(x - 1)^2 + 2} \ dx = 2\int \frac{1}{2(1 + (\frac{(x - 1)^2}{2}))} \ dx = \int \frac{1}{1 + (\frac{(x - 1)^2}{2})} \ dx = \int \frac{1}{1 + (\frac{x - 1}{\sqrt{2}})^2} \ dx  = \sqrt{2} \int \frac{\frac{1}{\sqrt{2}}}{1 + (\frac{x - 1}{\sqrt{2}})^2} \ dx = \sqrt{2}.arctg(\frac{x - 1}{\sqrt{2}}) $

* $ ln|x| - \frac{1}{2}.ln|x^2 - 2x + 3| - \sqrt{2}.arctg(\frac{x - 1}{\sqrt{2}}) + C, \ C \in \mathbb{R} $

#

$ f(x) = \frac{x^3 - 5x^2 + 9x - 4}{x^3 - 5x^2 + 4x} = 1 + \frac{5x - 4}{x^3 - 5x^2 + 4x} = 1 + \frac{5x - 4}{x(x^2 - 5x + 4)} = $ (Fórmula Resolvente) $ 1 + \frac{5x - 4}{x(x - 1)(x - 4)} = \frac{A}{x} + \frac{B}{x - 1} + \frac{C}{x - 4} $

* Reduzindo ao mesmo denominador: $ 5x - 4 = A(x - 1)(x - 4) + Bx(x - 4) + C(x)(x - 1) $

    * Com $ x = 0 $:
        * $ -4 = 4A \Rightarrow A = -1 $

    * Com $ x = 1 $:
        * $ 1 = -3B \Rightarrow B = -\frac{1}{3} $

    * Com $ x = 4 $:
        * $ 16 = 12C \Rightarrow C = \frac{4}{3} $

* $ \int \frac{x^3 - 5x^2 + 9x - 4}{x^3 - 5x^2 + 4x} \ dx = \int 1 + \frac{1}{x} - \frac{1}{3(x - 1)} + \frac{4}{3(x - 4)} \ dx = x - ln|x| - \frac{1}{3}.ln|x - 1| + \frac{4}{3}.ln|x - 4| + C, \ C \in \mathbb{R} $

#

$ f(x) = \frac{x - 1}{x(x^2 + 1)} = \frac{A}{x} + \frac{Bx + C}{x^2 + 1} $

* Reduzindo ao mesmo denominador: $ x - 1 = A(x^2 + 1) + (Bx + C)x $

    * Com $ x = 0 $:
        * $ -1 = A \Rightarrow A = -1 $

    * Comparando os coeficientes de $ x $:
        * $ 1 = C \Rightarrow C = 1 $

    * Comparando os coeficientes de $ x^2 $:
        * $ 0 = A + B \Rightarrow B = 1 $

* $ \int \frac{x - 1}{x(x^2 + 1)} \ dx = \int -\frac{1}{x} + \frac{x + 1}{x^2 + 1} \ dx = - ln|x| + \frac{1}{2} \int \frac{2x}{x^2 + 1} \ dx + \frac{1}{2} \int \frac{2}{x^2 + 1} \ dx $

    * $ \int \frac{2x}{x^2 + 1} \ dx = ln|x^2 + 1| $
    * $ \int \frac{2}{x^2 + 1} \ dx = 2\int \frac{1}{1 + x^2} \ dx = 2.arctg(x^2 + 1) $

* $ -ln|x| + \frac{1}{2}.ln|x^2 + 1| + arctg(x^2 + 1) + C, \ C \in \mathbb{R} $

#
#

## __Integral__

> $ f(x) $ limitada em $ [a, \ b] $

* Se o integral inferior de $ f $ for igual ao integral superior de $ f \Rightarrow f $ diz-se __integrável__ em $ [a, \ b] $ e o seu __integral__ é dado por:

$$ \int_a^b f(x) \ dx $$


### __Propriedades__

> Seja $ A $ a __área limitada pela curva__ $ y = f(x) $ e o eixo $ x $.

* Se $ f(x) \geq 0 \Rightarrow \int_a^b f(x) \ dx = A $

* Se $ f(x) \leq 0 \Rightarrow \int_a^b f(x) \ dx = - A $

> Seja $ v $ e $ w $ funções integráveis em $ [a, \ b], \ c \in [a, \ b] $ e $ k $ constante.

* $ \int_a^a v(x) \ dx = 0 $

* $ \int_a^b v(x) \ dx = - \int_b^a v(x) \ dx $

* $ \int_a^b k.v(x) \ dx = k.\int_a^b v(x) \ dx $

* $ \int_a^b (v(x) + w(x)) \ dx = \int_a^b v(x) \ dx + \int_a^b w(x) \ dx $

* $ \int_a^b v(x) \ dx = \int_a^c v(x) \ dx + \int_c^b v(x) \ dx $

* $ | \int_a^b v(x) \ dx | \leq \int_a^b |v(x)| \ dx $

* Se $ v(x) \leq w(x) \ \forall \ x \in [a, \ b] \Rightarrow \int_a^b v(x) \ dx \leq \int_a^b w(x) \ dx $

### __Paridade__

> $ f(x) $ integrável em $ [a, \ b] $

* Se $ f(x) $ é __par__ em $ [a, \ b] \Rightarrow \int_{-a}^a f(x) \ dx = 0 $

* Se $ f(x) $ é __ímpar__ em $ [a, \ b] \Rightarrow \int_{-a}^a f(x) \ dx = 2.\int_0^a f(x) \ dx $

## __Integral Indefinido__

> $ f(x) $ integrável em $ I $ e $ a \in I $

> $ \phi: I \rightarrow \mathbb{R} $

$$ \phi(x) = \int_a^x f(t) \ dt $$

#
#

## __Teorema Fundamental do Cálculo__

> $ f $ contínua e primitivável em $ I $ e $ a \in I $

> $ \phi: I \rightarrow \mathbb{R} $

Se $ \phi(x) = \int_a^x f(t) \ dt \Rightarrow \phi'(x) = f(x) $

#
#

## __Regra de Barrow__

> $ f(x) $ integrável $ em [a, \ b] $

$$ \int_a^b f(x) \ dx = P[f(x)]|_a^b = P[f(x)]|_b - P[f(x)]|_a $$

### __Exemplos__

$ \int_0^2 \sqrt{x} \ dx = 
\\ [\frac{2}{3}x^{\frac{3}{2}}]_0^2 =
\\ \frac{2}{3}.2^{\frac{3}{2}} - 0 =
\\ \frac{2.\sqrt{8}}{3} =
\\ \frac{4.\sqrt{2}}{3} + C, \ C \in \mathbb{R} $

#

$ \int_2^e -\frac{1}{x} \ dx =
\\ -\int_2^e \frac{1}{x} \ dx =
\\ -[ln (x)]_2^e =
\\ -ln(e) + ln(2) =
\\ -1 + ln(2) + C, \ C \in \mathbb{R} $

#

$ \int_3^0 |x| \ dx =
\\ \int_{-3}^0 |x| \ dx + \int_0^4 |x| \ dx =
\\ \int_{-3}^0 -x \ dx + \int_0^4 x \ dx =
\\ -[\frac{x^2}{2}]_{-3}^0 + [\frac{x^2}{2}]_0^4 =
\\ \frac{9}{2} + \frac{16}{2} =
\\ \frac{25}{2} + C, \ C \in \mathbb{R} $

#

$ \int_{-3}^{3} x^3 \ dx =
\\ [\frac{x^4}{4}]_{-3}^{3} =
\\ \frac{3^4}{4} - \frac{(-3)^4}{4} =
\\ 0 + C, \ C \in \mathbb{R} $

#
#

## __Regras de Integração__

> $ u $ e $ v $ primitiváveis em $ [a, \ b] $.

### __Integração por Partes__

* $ \int_a^b u'(x) = [u(x).v(x)]_a^b - \int_a^b u(x).v'(x) \ dx $

#### __Exemplos__

$ \int_0^\pi x.sen(2x) \ dx $

* $ u = x \Rightarrow u' = 1 $

* $ v' = sen(2x) (=) v' = \frac{1}{2}.2.sen(2x) \Rightarrow v = -\frac{1}{2}.cos(2x) $

$ \Rightarrow \int_0^\pi x.sen(2x) \ dx = [x.(-\frac{1}{2}.cos(2x))]_0^\pi - \int_0^\pi -\frac{1}{2}.cos(2x) \ dx =
\\ - \frac{\pi}{2}.cos(2\pi) - 0 + \frac{1}{2}.\int_0^\pi cos(2x) \ dx $

* $ P[cos(2x)] = \frac{1}{2}.sen(2x) $

$ \Rightarrow - \frac{\pi}{2}.cos(2\pi) + [sen(2x)]_0^\pi =
\\ - \frac{\pi}{2}.1 + 0 - 0 + 0 =
\\ - \frac{\pi}{2} + C, \ C \in \mathbb{R} $

#

### __Integração por Substituição__

* $ \int_a^b v(x) \ dx = \int_{t_a}^{t_b} v(x(t)) \frac{dx}{dt} \ dt $

    * $ x(t_a) = a $
    
    * $ x(t_b) = b $

#### __Exemplos__

$ \int_{-1}^1 \sqrt{1 - x^2} \ dx $

* $ x = sen(t) \Rightarrow t = arcsen(x) $

    * $ x = 1 \Rightarrow sen(t) = 1 \Rightarrow t_b = \frac{\pi}{2} $

    * $ x = -1 \Rightarrow sen(t) = -1 \Rightarrow t_a = -\frac{\pi}{2} $

* $ \frac{dx}{dt} = cos(t) $

$ \Rightarrow \int_{-\frac{\pi}{2}}^{\frac{\pi}{2}} \sqrt{1 - sen^2(t)} \ \ .cos(t) \ dt =
\\ \int_{-\frac{\pi}{2}}^{\frac{\pi}{2}} \sqrt{cos^2(t)} \ \ .cos(t) \ dt =
\\ \int_{-\frac{\pi}{2}}^{\frac{\pi}{2}} cos(t) \ \ .cos(t) \ dt =
\\ \int_{-\frac{\pi}{2}}^{\frac{\pi}{2}} cos^2(t) \ dt =
\\ \int_{-\frac{\pi}{2}}^{\frac{\pi}{2}} \frac{1 + cos(2t)}{2} \ dt $

* $ P[\frac{1}{2} + \frac{cos(2t)}{2}] = \frac{t}{2} + P[\frac{1}{2}.\frac{1}{2}.2.cos(2t)] = \frac{t}{2} + \frac{1}{4}.sen(2t) $

$ \Rightarrow [\frac{t}{2} + \frac{1}{4}.sen(2t)]_{-\frac{\pi}{2}}^{\frac{\pi}{2}} =
\\ \frac{\frac{\pi}{2}}{2} + \frac{1}{4}.sen(\pi) - \frac{-\frac{\pi}{2}}{2} - \frac{1}{4}.sen(-\pi) =
\\ \frac{\pi}{4} + 0 + \frac{\pi}{4} + 0 =
\\ \frac{\pi}{2} + C, \ C \in \mathbb{R} $

#
#

## __Valor Médio de uma Função__

> $ f(x) $ integrável em $ [a, \ b] $

O valor médio de $ f(x) $ em $ [a, \ b] $ é dado por:

$$ \frac{\int_a^b f(x) \ dx}{b - a} $$

#
#

## __Cálculo de Áreas__

> $ f(x) $ e $ g(x) $ integráveis em $ [a, \ b] $ e $ f(x) \geq g(x) \ \forall \ x \in [a, \ b] $

> $ A = {(x, \ y) \in O_{xy} \ | \ a \leq x \leq b \ \wedge \ g(x) \leq y \leq f(x)} $

O __área__ da __região plana__ $ A $ é dada por:

$$ A = \int_a^b [f(x) - g(x)] \ dx $$

#
#

## __Integrais Impróprios__

### __1ª Espécie__

> $ f(x): [a, \ +\infty[ \ \rightarrow \mathbb{R} $ e integrável em $ [a, \ b] \ \forall \ b > a $

$$ lim_{b \rightarrow +\infty} \int_a^b f(x) \ dx = \int_a^{+\infty} f(x) \ dx $$

> $ f(x): ]-\infty, \ b] \ \rightarrow \mathbb{R} $ e integrável em $ [a, \ b] \ \forall \ a < b $

$$ lim_{a \rightarrow -\infty} \int_a^b f(x) \ dx = \int_{-\infty}^b f(x) \ dx $$

* Se este limite existir e for finito, então o integral é __convergente__ caso contrário é __divergente__.

#

### __2ª Espécie__

> $ f(x): [a, \ b] \ \rightarrow \mathbb{R} $ e integrável em $ [a, \ c], \ a \leq c < b $

$$ lim_{c \rightarrow b^-} \int_a^c f(x) \ dx = \int_a^b f(x) \ dx $$

> $ f(x): [a, \ b] \ \rightarrow \mathbb{R} $ e integrável em $ [c, \ b], \ a < c \leq b $

$$ lim_{c \rightarrow a^+} \int_c^b f(x) \ dx = \int_a^b f(x) \ dx $$

* Se este limite existir e for finito, então o integral é __convergente__ caso contrário é __divergente__.

#

### __Exemplos__

$ \int_1^{+\infty} \frac{1}{x^2} \ dx $

* $ P[\frac{1}{x^2}] = P[x^{-2}] = -\frac{1}{x} $

$ \Rightarrow lim_{b \rightarrow +\infty} \int_1^b \frac{1}{x^2} \ dx =
\\ lim_{b \rightarrow +\infty} [-\frac{1}{x}]_1^b =
\\ lim_{b \rightarrow +\infty} (-\frac{1}{b} + 1) =
\\ -0 + 1 = 1 $

$ \Rightarrow \int_1^{+\infty} \frac{1}{x^2} \ dx $ é __convergente__ e igual a __1__.

#

$ \int_1^{+\infty} \frac{1}{x} \ dx $

* $ P[\frac{1}{x}] = ln|x| $

$ \Rightarrow lim_{b \rightarrow +\infty} \int_1^b \frac{1}{x} \ dx =
\\ lim_{b \rightarrow +\infty} [ln|x|]_1^b =
\\ lim_{b \rightarrow +\infty} (ln|b| - ln|1|) =
\\ lim_{b \rightarrow +\infty} ln|b| = +\infty $

$ \Rightarrow \int_1^{+\infty} \frac{1}{x} \ dx $ é __divergente__.

#

$ \int_1^{+\infty} \frac{1}{\sqrt{x}} \ dx $

* $ P[\frac{1}{\sqrt{x}}] = P[x^{-\frac{1}{2}}] = P[\frac{x^{\frac{1}{2}}}{\frac{1}{2}}] = 2\sqrt{x} $

$ \Rightarrow lim_{b \rightarrow +\infty} \int_1^b \frac{1}{\sqrt{x}} \ dx =
\\ lim_{b \rightarrow +\infty} [2\sqrt{x}]_1^b =
\\ lim_{b \rightarrow +\infty} (2\sqrt{b} - 2\sqrt{1}) =
\\ lim_{b \rightarrow +\infty} 2\sqrt{b} - 2 =
\\ +\infty - 2 = +\infty $

$ \Rightarrow \int_1^{+\infty} \frac{1}{\sqrt{x}} \ dx $ é __divergente__.

#

$ \int_0^1 \frac{1}{x} \ dx $

* $ P[\frac{1}{x}] = ln|x| $

$ \Rightarrow lim_{c \rightarrow 0^+} \int_a^1 \frac{1}{x} \ dx =
\\ lim_{c \rightarrow 0^+} [ln|x|]_c^1 =
\\ lim_{c \rightarrow 0^+} (ln|1| - ln|c|) =
\\ lim_{c \rightarrow 0^+} 0 - ln|c| =
\\ -ln|0| = - -\infty = +\infty $

$ \Rightarrow \int_0^1 \frac{1}{x} \ dx $ é __divergente__.

#
#

## __Integrais Impróprios Mistos__

### __1ª Espécie__

> $ f(x): [-\infty, \ +\infty] \ \rightarrow \mathbb{R} $

> $ \forall \ c \in \mathbb{R}: \int_{-\infty}^c f(x) \ dx $ e $ \int_c^{+\infty} f(x) \ dx $

$$ \int_{-\infty}^{+\infty} f(x) \ dx = \int_{-\infty}^c f(x) \ dx + \int_c^{+\infty} f(x) \ dx $$

* Se ambos os integrais forem convergentes, então o integral é __convergente__ caso contrário é __divergente__.

#

### __2ª Espécie__

> $ f(x): ]a, \ b[ \ \rightarrow \mathbb{R} $

> $ \forall \ d \in \ ]a, \ b[: \int_a^d f(x) \ dx = lim_{c \rightarrow a^+} \int_c^d f(x) \ dx $ e $ \int_d^b f(x) \ dx = lim_{c \rightarrow b^-} \int_d^c f(x) \ dx $

$$ \int_a^b f(x) \ dx = \int_a^d f(x) \ dx + \int_d^b f(x) \ dx $$

* Se ambos os integrais forem convergentes, então o integral é __convergente__ caso contrário é __divergente__.