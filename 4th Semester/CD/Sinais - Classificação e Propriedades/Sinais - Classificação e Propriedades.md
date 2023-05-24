# __Sinais - Classificação e Propriedades__

## __Classificação de Sinais__

__Suporte__:
* Analógico/Contínuo;
* Discreto;
* Digital.

__Periodicidade__:
* Periódico;
* Não periódico.

__Energia/Potência__:
* Energia (sinal não periódico);
* Potência (sinal periódico).

## __Sinais Contínuos, Discretos e Digitais__
Em termos gerais, um sinal é algo que __codifica informação__.

Em __termos físicos__, representa uma __corrente ou tensão elétrica__.

#

### __Contínuo ($ x(t) $)__

É uma função real de variável real -> $ x(t): R \rightarrow R $

<div align=center> 

![](imgs\Sinal-Contínuo.png)

</div>

Eg.:

<div align=center> 

![](imgs\Sinal-Contínuo-Exemplo.png)

</div>

#

### Discreto

É uma função real de variável inteira relativa -> $ x[n]: Z_0 \rightarrow R $

Os __valores de amplitude__ de $ x[n] $ são obtidos:

* Por amostragem ao ritmo Fs (_frequency of samplying_);
* A cada Ts (_time of sampling_) é obtida nova amostra.

Eg.:

<div align=center> 

![](imgs\Sinal-Discreto-Exemplo.png)

</div>

#

### __Digital__

É uma função com:
* Valores inteiros relativos (um subconjunto de $ 2^n $ valores);
* Variável inteira relativa;
* $ x[n]: Z_0 \rightarrow Z_0 $.

Eg.:

<div align=center> 

![](imgs\Sinal-Digital-Exemplo.png)

</div>

#

## __Sinais Não Periódicos e Periódicos__

#

### __Não periódicos ou Aperiódicos__
__Não se repetem__ ao longo do tempo.    
Eg.:
* Pulso Retangular;
<div align=center> 

![](imgs\Sinal-Retangular-Exemplo.png)

</div>

* Pulso Sinusoidal.
<div align=center> 

![](imgs\Sinal-Sinusoidal-Exemplo.png)

</div>

#

###  __Periódicos__
__Repetem-se__ a cada período fundamental $ T_0 $ -> __menor valor de tempo para o qual o sinal se repete__. 

Domínio __Contínuo__ (período de $ T_0 $ seg) -> $ x(t) = x(t + kT_0) $

Domínio __Discreto__ (período de N amostras) -> $ x[n] = x(n + kN) $

__Frequência temporal__ $ f_0 $ -> $ \frac{1}{T_0} $

$ T_0 = mmc(T_1, T_2, ...) $

Eg.:
* Sinusóide;
<div align=center> 

![](imgs\Sinal-Sinusóide-Exemplo.png)

</div>

* Onda Quadrada.
<div align=center> 

![](imgs\Sinal-Onda-Quadrada-Exemplo.png)

</div>

#

## __Sinais de Energia e de Potência__

__Potência Instantânea__ -> $ p(t) = x^2(t) $

Energia:
* Domínio __Contínuo__ -> $ Ex = \int ^ {+ \infty }_{- \infty } x^2(t) \ dt $

* Domínio __Discreto__ -> $ Ex = \sum ^ {+ \infty }_{- \infty } x^2[n] $

* $ 0 \leq E < + \infty $