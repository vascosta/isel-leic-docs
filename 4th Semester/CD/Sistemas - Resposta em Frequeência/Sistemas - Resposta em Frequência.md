# __Sistemas - Resposta em Frequência__

## __Resposta em frequência__

__Resposta em Frequência__ $ (HF) \rightarrow $ carateriza o comportamento no domínio da frequência

Indica __qual o ganho__ que o sistema __aplica a cada frequência__.

$ Y(f) = X(f).H(f) $

<div align=center> 

![](imgs/Resposta-em-Frequência.png)

</div>

#

### __Sistema Amplificador/Atenuador__

<div align=center> 

![](imgs/Sistema-Amplificador.png)

</div>

$ h(t) = a.\delta(t) $

<div align=center> 

![](imgs/Sistema-Amplificador-2.png)

</div>

$ Y(f) = a.X(f) $

$ H(f) = a $

#

### __Atenuador (divisor de tensão)__

<div align=center> 

![](imgs/Atenuador.png)

</div>

$ y(t) = 0,5.x(t) $

$ h(t) = 0,5.\delta(t) $

<div align=center> 

![](imgs/Atenuador-2.png)

</div>

$ Y(f) = 0,5.X(f) $

$ H(f) = 0,5 $

#

### __Circuito RC__

<div align=center> 

![](imgs/Circuito-RC.png)

</div>

$ H(f) = \frac{1}{1 + j.2.\pi.f.R.C} $

$ |H(f)| = \frac{1}{\sqrt{1 + (2.\pi.f.R.C)^2}} $

$ arg[H(f)] = atan(-2.\pi.f.R.C) $

$ h(t) = \frac{1}{RC}.e^{-\frac{t}{RC}}.u(t) $

__E.g__:

$ R = 4,7 \ k\Omega, \ C = 22 \ nF $

<div align=center> 

![](imgs/Circuito-RC-2.png)

</div>

#

## __Filtragem__

As componentes de frequência que __constam__ de $ X(f) $ e __não constam__ de $ Y(f) $ __são filtradas__ (eliminadas) pelo sistema $ \Rightarrow $ o __tipo de filtragem__ é definido pela __função__ $ H(f) $

#

## __Tipos de Filtragem__

#

### __Filtro Passa-Baixo__

__Ideal__:

<div align=center> 

![](imgs/Passa-Baixo-Ideal.png)

</div>

__Real__:

<div align=center> 

![](imgs/Passa-Baixo-Real.png)

</div>

#

### __Filtro Passa-Banda__

__Ideal__:

<div align=center> 

![](imgs/Passa-Banda.png)

</div>

#

### __Filtro Passa-Alto__

__Ideal__:

<div align=center> 

![](imgs/Passa-Alto.png)

</div>

#

### __Filtro Rejeita-Banda__

__Ideal__:

<div align=center> 

![](imgs/Rejeita-Banda.png)

</div>

#

## __Associação de Sistemas__

#

### __Série ou Cascata__

<div align=center> 

![](imgs/Série.png)

</div>

Resposta em frequência equivalente $ \rightarrow H_{eq}(f) = H_1(f).H_2(f)...H_N(f) = \Pi_{k=1}^NH_k(f) $

#

### __Paralelo__

<div align=center> 

![](imgs/Paralelo.png)

</div>

Resposta em frequência equivalente $ \rightarrow H_{eq}(f) = H_1(f) + H_2(f) + ... + H_N(f) = \sum_{k=1}^NH_k(f) $