# __Investimento num Projeto__

## __Mapa de Amortizações__

| Descrição | Taxa (%) | Valor de Aquisição | Ano 1 | ... | Ano N |
|------------|------|---------------------|-------|-----|-------|
| ...        | ...  | ... | ... | ... | Valor de Aquisição * Taxa |
| Amortização Anual | - | - | ... | ... | Somatório das Amorizações (Ano N) |
| Valor Contabilístico | - | Somatório dos Valores de Aquisição | ... | ... | Valor Contabilístico (Ano N-1) - Amortização Anual (Ano N) |

## __Mapa de Investimento em Necessidades de Fundo de Maneio__

* Exemplo de critério de __Crédito a clientes__ -> "dar aos clientes __3 meses de crédito__ de pagamento do valor das __vendas__";

* Exemplo de critério de __Exist. final de prod. acab.__ -> "período de armazenagem de existências de produtos acabados de __15 dias__ das __vendas__";

* Exemplo de critério de __Custo das matérias consumidas__ -> "o custo das matérias primas representa __40%__ da __produção__";

* Exemplo de critério de __Exist. final de matérias primas__ -> "ter __2 meses de matérias primas em stock__ para fabricação";

* Exemplo de critério de __Crédito de fornecedores__ -> "pretendem obter dos fornecedores de matérias primas __1 mês de crédito__ do valor das __compras de matérias primas__"

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

* Exemplo de __Encargos financeiros__ -> "vencendo __juros__ a uma __taxa anual de 5%__";

| Descrição | Ano 0 | Ano 1 | ... | Ano N-1 | Ano N |
|------------|---------------------|-------|-----|-----|-------|
| Emprésitmo | 0,70 * (Valor Contabilístico Total - Valor de Aquisição do Terreno) | - | - | - | - |
| Reembolsos | - | - | - | 0.2 * Valor do Empréstimo | 0.8 * Valor do Empréstimo |
| Capital em dívida no final do ano | Valor do Empréstimo (Ano 0) | ... | ... | ... | Valor do Capital em dívida no final do ano (N-1) - Reembolso (Ano N) |
| Encargos financeiros | - | ... | ... | ... | 0,05 * Valor do Capital em dívida no final do ano (N-1) |
| Serviço da dívida | - | ... | ... | ... | Reembolso (Ano N) + Encargos financeiros (Ano N) |

