# __Investimento num Projeto__

## __Mapa de Amortizações__

| Descrição | Taxa (%) | Valor de Aquisição | Ano 1 | ... | Ano N |
|------------|------|---------------------|-------|-----|-------|
| ...        | ...  | ... | ... | ... | Valor de Aquisição * Taxa |
| Amortizações | - | - | ... | ... | Somatório das Amorizações (Ano N) |
| Valor Contabilístico | - | Somatório dos Valores de Aquisição | ... | ... | Valor Contabilístico (Ano N-1) - Amortização Anual (Ano N) |

## __Mapa de Investimento em Necessidades de Fundo de Maneio__

* Exemplo de critério de __Crédito a clientes__ -> "dar aos clientes __3 meses de crédito__ de pagamento do valor das __vendas__";

* Exemplo de critério de __Exist. final de prod. acab.__ -> "período de armazenagem de existências de produtos acabados de __15 dias__ das __vendas__";

* Exemplo de critério de __Custo das matérias consumidas__ -> "o custo das matérias primas representa __40%__ da __produção__";

* Exemplo de critério de __Exist. final de matérias primas__ -> "ter __2 meses de matérias primas em stock__ para fabricação";

* Exemplo de critério de __Crédito de fornecedores__ -> "pretendem obter dos fornecedores de matérias primas __1 mês de crédito__ do valor das __compras de matérias primas__".

| Descrição | Critério | Ano 0 | Ano 1 | ... | Ano N |
|------------|------|---------------------|-------|-----|-------|
| Vendas (V) | -  | - | ... | ... | Vendas (Ano N) |
| Crédito a clientes (Cl) | 3 meses de V | - | ... | ... | $ (\frac{3}{12}) $ * Vendas (Ano N) |
| Exist. final de prod. acab. (PA) | 0,5 meses de V | - | ... | ... | $ (\frac{0,5}{12}) $ * Vendas (Ano N) |
| Produção (P) | - | - | ... | ... | V + PA (ambos Ano N) - PA (Ano N-1) |
| Custo das matérias consumidas (CMC) | 40% de P | - | ... | ... | 0,4 * Produção (Ano N) |
| Exist. final de matérias primas (MP) | 2 meses de CMC | - | ... | ... | $ (\frac{2}{12}) $ * CMC (Ano N) |
| Compras de matéria prima (CMP) | - | - | ... | ... | CMC + MP (ambos Ano N) - MP (Ano N-1) |
| Crédito de fornecedores (F) | 1 mês de CMP | - | ... | ... | $ (\frac{1}{12}) $ * CMP (Ano N) |
| Nec. de Fun. de Maneio (NFM) | - | - | ... | ... | Cl + PA + MP - F (todos Ano N) |
| Investimento em NFM | - | NFM (Ano 1) | ... | ... | NFM (Ano N) - NFM (Ano N-1) |

## __Mapa de Financiamento do Investimento__

* Exemplo de __Empréstimo__ -> "a empresa prevê recorrer a um empréstimo bancário no __final do ano 0__ correspondente a __70%__ do __investimento em imobilizado (excepto o terreno)__";

* Exemplo de __Reembolso__ -> "o respectivo reembolso será efectuado nos __2 últimos anos de vida do projecto__, em __parcelas de 20% e 80%__ respectivamente";

* Exemplo de __Encargos financeiros__ -> "vencendo __juros__ a uma __taxa anual de 5%__".

| Descrição | Ano 0 | Ano 1 | ... | Ano N-1 | Ano N |
|------------|---------------------|-------|-----|-----|-------|
| Emprésitmo | 0,7 * (Valor Contabilístico Total - Valor de Aquisição do Terreno) | - | - | - | - |
| Reembolsos | - | - | - | 0,2 * Valor do Empréstimo | 0,8 * Valor do Empréstimo |
| Capital em dívida no final do ano | Valor do Empréstimo (Ano 0) | ... | ... | ... | Valor do Capital em dívida no final do ano (N-1) - Reembolso (Ano N) |
| Encargos financeiros | - | ... | ... | ... | 0,05 * Valor do Capital em dívida no final do ano (N-1) |
| Serviço da dívida | - | ... | ... | ... | Reembolso (Ano N) + Encargos financeiros (Ano N) |

## __Mapa de Demonstração de Resultados Previsionais__

* Exemplo de __Materiais e Serviços__ -> "as __aquisições de materiais e serviços__ deverão ser de cerca de __10% das venda__";

* Exemplo de __Ajustamentos e Provisões__ -> "é corrente na indústria, dada a existência de dívidas incobráveis, manter uma provisão (ajustamento) para cobranças duvidosas no montante de __10% da variação das vendas do período__";

* Exemplo de __Imposto sobre Rendimentos (IRC)__ -> "a taxa de imposto sobre os rendimentos será de __25%__".

| Descrição | Ano 0 | Ano 1 | ... | Ano N |
|------------|---------------------|-------|-----|-------|
| Vendas | - | ... | ... | Vendas (Ano N) |
| CMC | - | - | - | Calculado no __Mapa de Amortizações__ |
| Materiais e Serviços | - | ... | ... | 0,10 * Vendas (Ano N) |
| Custos com Pessoal | - | ... | ... | Custos com Pessoal (Ano N) |
| Amortizações | - | ... | ... | Calculado no __Mapa de Amortizações__ |
| Ajustamentos/Provisões | - | ... | ... | 0,1 * (Vendas (Ano N) - Vendas (Ano N-1)) |
| Encargos Financeiros | - | ... | ... | Calculado no __Mapa de Financiamento do Investimento__ |
| Resultados antes de impostos (RAI) | - | ... | ... | Vendas - CMC - Materiais e Serviços - Custos com Pessoal - Amortizações - Provisões - Encargos Financeiros (Tudo Ano N) |
| Matéria Colectável | - | ... | ... | RAI (Ano N) + Matéria Colectável (Ano N-1) |
| Imposto sobre Rendimentos (IRC) | - | ... | ... | 0,25 * Matéria Colectável (Ano N e com valor positivo) |
| Resultado Líquido | - | ... | ... | RAI - IRC (Ambos Ano N) |

## __Mapa de Valor Residual do Investimento__

* Exemplo de __Valor de Mercado do Imobilizado__ -> "a __totalidade do imobilizado__ será vendido por __360 000 no fim do projeto__";

| Descrição | Ano 0 | Ano 1 | ... | Ano N |
|------------|---------------------|-------|-----|-------|
| Valor de Mercado do Imobilizado | - | - | - | Valor de venda no fim do projeto |
| Valor Contabilístico | - | - | - | Calculado no __Mapa de Amortizações__ |
| Menos/Mais Valia | - | - | - | Valor de Mercado do Imobilizado - Valor Contabilístico (Ambos Ano N) |
| Poupança Fiscal | - | - | - | Taxa do IRC * Menos/Mais Valia (Ano N e Valor positivo) |
| Valor Residual do Imobilizado | - | - | - | Valor de Mercado do Imobilizado + Poupança Fiscal (Ambos Ano N) |
| Fundos de Maneio a recuperar | - | - | - | Calculado no __Mapa de Investimento em Necessidades de Fundo de Maneio__ |
| Provisões acumuladas | - | - | - | Somatório das Provisões (Ano 1..N) |
| Valor Residual do Activo Circulante | - | - | - | Fundos de Maneio a recuperar - Provisões acumuladas |

## __Mapa de Cálculo dos Cash Flows__

Exemplo de __Valor de Mercado do Imobilizado__ -> "a __totalidade do imobilizado__ será vendido por __360 000 no fim do projeto__";

| Descrição | Ano 0 | Ano 1 | ... | Ano N |
|------------|---------------------|-------|-----|-------|
| Resultado Líquido Previsional | - | ... | ... | Calculado no __Mapa de Demonstração de Resultados Previsionais__ |
| Amortizações | - | ... | ... | Calculado no __Mapa de Amortizações__ |
| Ajustamentos/Provisões | - | ... | ... | Calculado no __Mapa de Demonstração de Resultados Previsionais__ |
| Encargos Financeiros | - | ... | ... | Calculado no __Mapa de Financiamento do Investimento__ |
| Cash Flow de Exploração | - | ... | ... | Valor Residual do Activo Circulante + Amortizações + Ajustamentos/Provisões + Encargos Financeiros (Todos Ano N) |
| Investimento em Imobilizado | Valor de Aquisição (Calculado no __Mapa de Financiamento do Investimento__) | - | - | - |
| Investimento em NFM | ... | ... | ... | Calculado no __Mapa de Investimento em Necessidades de Fundo de Maneio__ |
| Valor Residual do Imobilizado | - | - | - | Calculado no __Mapa de Valor Residual do Investimento__ |
| Valor Residual do Activo Circulante | - | - | - | Calculado no __Mapa de Valor Residual do Investimento__ |
| Cash Flow Global | ... | ... | ... | Cash Flow de Exploração + Investimento em Imobilizado + Investimento em NFM - Valor Residual do Imobilizado - Valor Residual do Activo Circulante (Todos Ano N) |
| Emprésitmo | Calculado no __Mapa de Financiamento do Investimento__ | - | - | - |
| Valores a Pagar a Financiadores | - | ... | ... | Serviço da dívida (Ano N) (Calculado no __Mapa de Financiamento do Investimento__) |
| Cash Flow Global do Accionista | ... | ... | ... | Cash Flow Global + Empréstimo - Valores a Pagar a Financiadores (Todos Ano N) |

## __Cálculo do Valor Actual Líquido (VAL) e da Taxa Interna de Rentabilidade (TIR)__

### __Calculadora__ ___CASIO fx-9060GII___

* __VAL/NPV e TIR/IRR__:
    * ``MENU``
    * ``TVM``
    * ``Cash Flow``
        * ``I%`` -> Taxa de Actualização
        * ``Csh`` -> Lista com os Cash Flows Globais
            * ``NPV`` -> Valor Actual Líquido
            * ``IRR`` -> Taxa Interna de Rentabilidade