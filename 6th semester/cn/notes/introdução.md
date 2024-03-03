# __Introdução à Computação na Nuvem__

## __Definição__

Ato de __armazenar__, __processar__ e __usar dados__ em computadores localizados remotamente acedidos através da Internet.

* Computação e armazenamento distribuídos:
    * Hardware, middleware, plataformas, etc.;
    * Uso de hardware de forma otimizada através do uso de redes de computadores.

* Virtualização -> facilidade de mudança de requisitos de hardware.

* Economia -> possibilidade de pagar confirma a utilização (___pay-per-use___)

#

## ___Cloud Computing___

Modelo que permite __acesso conveniente__ e __sob demanda__ a uma ___pool_ partilhada__ de __recursos de computação configuráveis__ (e.g., redes, servidores, aplicações, etc.). 

Estes recursos podem ser __rapidamente provisionados e libertados__ com um __esforço de gestão mínimo__ ou __interação do provedor de serviços__.

Para além das __bases de dados__, existem vários __ambientes de execução__, tais como:

* Máquinas virtuais;
* Contentores;
* Aplicações Web;
* _Serveless_.

#

## __Modelo Económico__

* __Ambientes de execução__
* __Métricas__:
    * Horas/minutos/segundos de utilização;
    * Pedidos por intervalo;
    * Etc.

#

## __Energia__

Custo relevante quer para o fornecedor, quer para o meio ambiente.

$ Power \ Usage \ Efficiency = \frac{Total \ Facility \ Energy}{IT \ Equipment \ Energy} $

#

## __Modelos/Tipos de ___Cloud_____

* ___Private Cloud___ -> Exclusiva a uma organização, eventualmente com múltiplas unidades de negócio.

* ___Community Cloud___ -> Exclusiva a uma comunidade de consumidores que partilham os mesmos objetivos.

* ___Public Cloud___ -> Pertence a um fornecedor (envolvendo múltiplos centros de processamenteo, em vários países). Os consumidores usam a _Cloud_ segundo modelos de _pay-per-use_, com diferentes níveis de serviço (SLA - _Service Level Agreement_)

* ___Hybrid Cloud___ -> Composição de infraestruturas de _Cloud_ distintas que interoperam através de modelos e tecnologias, que facilitam a portabilidade de aplicações ou dados.

#

## ___Cloud Computing Stack___

| __Tipo de Serviço__ | __Acesso e Ferramentas__ | __Contéudo do Serviço__ |
|-----------------------|--------------------------|------------------------|
| _Software as a Service_ (__SaaS__) | Navegador _Web_ | __Aplicações__ _Cloud_ (redes sociais, _Email_, etc.) |
| _Platform as a Service_ (__PaaS__) | Ambientes de execução | __Plataformas__ _Cloud_ (linguagens de programação, _frameworks_, _Web_ APIs, modelos de armazenamento de dados, etc.) |
| _Infrastructure as a Service_ (__IaaS__) | _Virtualization Manager_ | __Infraestruturas__ _Cloud_ (servidores, armazenamento de dados, _load balancer_, VPN, etc.) |

#

## ___Cloudnomics___

* __Custos totais__ (__TCO__ - _Total Cost of Ownership_):
    * __Custos de capital/investimento__ (__CAPEX__ - _Capital Expenditure_) -> Despesas que criam benefícios futuros, normalmente com um grande investimento inicial.
    * __Custos operacionais__ (__OPEX__ - _Operational Expenditure_) -> Custo contínuo e dinâmico para a execução de um produto, empresa ou sistema.

Como __antecipar/prever__ os custos mensais:
* Licenciamento	de software;
* Contratos de manutenção de hardware e software;
* Custo de recursos humanos em ações de manutenção;
* Custos energéticos;
* Etc.

#

## __Fatores na decisão de escolha de um Servidor__

* __Servidor Físico__:
    * Infraestrutura elétrica e ar condicionado;
    * Infraestrutura de rede de comunicações;
    * Proteção contra falha de energia (UPS);
    * Custo mensal de energia;
    * Custo de manutenção/instalação.

* __Servidor Virtual__:
    * Custo mensal ou anual fixo.

#

## __Elasticidade (Auto-Scaling)__

* __Escalabilidade__ (_scale up and scale down_) __automática__.
* __Algoritmos__ para __controlar e alocar recrusos__ com as cargas associadas (_workloads_).
* Requer a __capacidade de distribuir computações e dados__ por múltiplos nós.
* A __coordenação dos nós__ é um ponto crítico.

<div align=center> 

![](../imgs/introdução-1.png)

</div>

#

## __Potencialidades e Oportunidades__

* _Pay-per-use_;
* Recursos computacionais virtuais infinitos;
* Interfaces _self-service_;
* Evita a aquisição/instalação/manutenção de centros de processamento de dados.