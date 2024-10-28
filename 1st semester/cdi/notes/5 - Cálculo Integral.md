# __Cálculo Integral__


## __Primitiva__

> $ f: I \rightarrow \mathbb{R} $, $ I $ intervalo aberto

Uma função $ F(x) $ é primitiva de $ f(x) $ em $ I $ sse $ F'(x) = f(x), \ \forall \ x \in I $ e designa-se por:

$$ P[f(x)] = F(x) $$

O conjunto de __todas as primitivas__ de $ f(x) $ em $ I $ é designado por:

$$ \int f(x)dx = F(x) $$

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

* $ P[u^n] = \frac{u^{n+1}}{n+1}, \ n \neq -1 $

* $ P[u'.u^n] = \frac{u^{n+1}}{n+1}, \ n \neq -1 $

* $ P[\frac{u'}{u}] = \ln |u| $

* $ P[\frac{u'}{1 + u^2}] = \arctan(u) $

* $ P[\frac{u'}{\sqrt{1 - u^2}}] = \arcsin(u) $

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

$ \int sen(x).cos^2(x) \ dx = \int (-(-sen(x)).(cos(x))^2)\ dx = -\int -sen(x).cos^2(x) \ dx = - \frac{cos(x)^3}{3} $

#

$ \int x.e^{x^2} \ dx = \frac{1}{2}.\int 2x.e^{x^2} \ dx = \frac{1}{2}e^{x^2} $

# 

$ \int 2^{x-1} \ dx = \int (e^{ln (2)})^{x-1} \ dx = \int e^{(x-1).ln(2)} \ dx = \frac{1}{ln(2)}.\int ln(2).e^{(x-1).ln(2)} \ dx = \frac{e^{(x-1).ln(2)}}{ln(2)}  $

#

$ \int \frac{x^3}{1+x^8} \ dx = \int \frac{x^3}{1+(x^4)^2} \ dx = \frac{1}{4}\int \frac{4x^3}{1+(x^4)^2} \ dx = \frac{arctg(x^4)}{4} $

#

$ \int \frac{e^x}{\sqrt{1-e^{2x}}} \ dx = \int \frac{e^x}{\sqrt{1-(e^x)^2}} \ dx = arcsen(e^x) $

#

$ \int \frac{x^3}{1+x^4} \ dx = \frac{1}{4} \int \frac{4x^3}{1+x^4} \ dx = \frac{ln(1+x^4)}{4} $

#

$ \int \frac{e^x}{\sqrt{1-e^x}} \ dx = \int e^x(1-e^x)^{-\frac{1}{2}} \ dx = \int (-(-e^x))(1-e^x)^{-\frac{1}{2}} \ dx = - \int -e^x(1-e^x)^{-\frac{1}{2}} \ dx = -(\frac{(1-e^x)^{-\frac{1}{2}}}{-\frac{1}{2}+1}) = -2(1-e^x)^{\frac{1}{2}} $

#

$ \int \frac{5x^2}{9 + x^6} \ dx = \int \frac{1}{9}.\frac{5x^2}{1+\frac{x^6}{9}} \ dx = \frac{5}{9} \int \frac{x^2}{1+(\frac{x^3}{3})^2} \ dx = \frac{5}{9}.arctg(\frac{x^3}{3}) $

### __Primitivas Quase Imediatas__

* $ P[u'.tan(u)] = -ln|cos(u)| $

* $ P[u'.cotg(u)] = ln|sen(u)| $

* $ P[u'.sec(u)] = ln|sec(u) + tg(u)| $

* $ P[u'.cosec(u)] = - ln|cosec(u) + cotg(u)| $

### __Primitivação por Partes__

* $ P[u'.v] = u.v - P[u.v'] $

#### __Exemplos__

$ \int x.ln(x) \ dx = \frac{x^2.ln(x)}{2} - \int \frac{x^2}{2}. \frac{1}{x} \ dx = \frac{x^2.ln(x)}{2} - \int \frac{x}{2} \ dx = \frac{x^2.ln(x)}{2} - \frac{x^2}{4} $

#

$ \int ln(x) \ dx = \int 1.ln(x) \ dx = x.ln(x) - \int x.\frac{1}{x} \ dx = x.ln(x) - \int 1 \ dx = x.ln(x) - x $

#

$ \int x.sen(x) \ dx = -x.cos(x) + \int 1.cos(x) \ dx = -x.cos(x) + sen(x) $

#

$ \int x^2.e^{-x} \ dx = -x^2.e^{-x} + \int 2x.e^{-x} \ dx = -x^2.e^{-x} - 2\int x.e^{-x} \ dx = -x^2.e^{-x} - 2(-x.e^{-x} + \int 1.e^{-x} \ dx) = -x^2.e^{-x} - 2x.e^{-x} - 2e^{-x} $

#

$ \int e^{-x}.cos(x) \ dx = e^{-x}.sen(x) + \int e^{-x}.sen(x) \ dx = e^{-x}.sen(x) + \int e^{-x}.sen(x) \ dx = e^{-x}.sen(x) + (-e.x.cos(x) - \int -e^{-x}.cos(x) \ dx) $

$ \int e^{-x}.cos(x) \ dx = e^{-x}.sen(x) - e^{-x}.cos(x) - \int e^{-x}.cos(x) \ dx \ (=) \ 2\int e^{-x}.cos(x) \ dx = e^{-x}(sen(x) - cos(x)) \ (=) \ \int e^{-x}.cos(x) \ dx = \frac{e^{-x}(sen(x) - cos(x))}{2} $

#

$ \int sen^2(x) \ dx = \int sen(x).sen(x) \ dx = -cos(x).sen(x) + \int cos(x).cos(x) \ dx = -cos(x).sen(x) + \int 1 - sen^2(x) \ dx = -cos(x).sen(x) + x - \int sen^2(x) \ dx \ (=) \ 2\int sen^2(x) \ dx = x - cos(x).sen(x) \ (=) \ \int sen^2(x) \ dx = \frac{x}{2} - \frac{cos(x).sen(x)}{2} $

#

$ \int \frac{x}{(1+x^2)^2} \ dx = \frac{1}{2} \int 2x(1+x^2)^{-2} dx = \frac{1}{2} . \frac{(1+x^2)^{-2+1}}{-2+1} = \frac{1}{2}. \frac{(1+x^2)^{-1}}{-1} = -\frac{1}{2(1+x^2)} $

#

$ \int \frac{x^2}{(1+x^2)^2} \ dx = \int x.\frac{x}{(1+x^2)^2} \ dx = x.(-\frac{1}{2(1+x^2)}) + \int 1.(\frac{1}{2(1+x^2)}) \ dx = -\frac{x}{2(1+x^2)} + 2arctg(x) $

### __Primitivação por Substituição__


