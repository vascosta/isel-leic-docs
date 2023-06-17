# __Processamento Transacional__

## __Transações__

### __O Porquê de Transações?__

<div align=center> 

![](imgs/1.png)

</div>

---

### __Tipos de ações__

* Não protegidas
* Protegidas
* Reais

__Ação atómica__ $ \rightarrow $ quando __executada num determinado nível de
abstração mais elevado__, ou __é executada completamente com sucesso__, (produzindo todos os seus efeitos), ou, então, __não produz quaisquer efeitos__ diretos ou laterais.

---

### __Propriedades ACID__

* Atomicidade
* Consistência
* Isolamento
* Durabilidade.

---

### __Escalonamentos__

Um escalonamento de um __conjunto de transações__ $ (T_1, ... ,T_n) $ é
uma __ordenação__ $ S $ das __operações__ em cada um dos $ T_i $,  tal que __todas as ações__ de cada $ T_i $ aparecem em $ S $ pela __mesma ordem em que ocorrem__ em $ T_i $.

__E.g.__:

$ \color{green} T_1 = \ <r(x1),w(x2),r(x3)> $

$ \color{yellow} T_2 = \ <w(x1),r(x2),w(x4)> $

__Escalonametos__ de $ (T_1, T_2) $:
* $ S1 = \ \color{green} <r(t1,x1),w(t1,x2),r(t1,x3), \color{yellow} w(t2,x1),r(t2,x2),w(t2,x4)> $
* $ S2 = \ \color{yellow} <w(t2,x1),r(t2,x2),w(t2,x4), \color{green}r(t1,x1),w(t1,x2),r(t1,x3)> $
* $ S3 = \ \color{green} <r(t1,x1), \color{yellow} w(t2,x1), \color{green} w(t1,x2), \color{yellow} r(t2,x2),\color{green} r(t1,x3), \color{yellow} w(t2,x4)> $

__Não é__ escalonamento de $ (T1,T2) $:
$ \color{green} <w(t1,x2),r(t1,x1), \color{yellow} w(t2,x4), \color{green} r(t1,x3), \color{yellow} w(t2,x1),r(t2,x2)> $

__2 operações__ num escalonamento $ S $ __conflituam__ se verificarem, simultaneamente, as seguintes condições:
* As operações __pertencem__ a $ T_i $ __diferentes__
* Ambas as operações __acedem__ ao __mesmo item de dados__
* Pelo menos __1__ das operações é __w(x)__

---

### __Tipos de Escalonamentos__

___Cascadeless___ $ \rightarrow $ __nenhuma__ das suas transações __lê um item__ escrito por __outra transação__ ainda __não terminada__ $ \Rightarrow $ não contém ___dirty reads___

__E.g.__:

__Não é__ _cascadeless_:
$ S1 = \color{blue} <r(t1,x1), \color{red} {w(t1,x1)}, \color{green} r(t2,x1), \color{blue} r(t1,x2),w(t2,x1),w(t1,x2),a(t1),a(t2) \rightarrow $ quando $ t1 $ __aborta__, $ t2 $ tem de __abortar também__ (efeito cascata)

__É__ _cascadeless_:
$ S2 = \ \color{yellow} <w(t2,x1),r(t2,x2),w(t2,x4), \color{green}r(t1,x1),w(t1,x2),r(t1,x3)> $