# __Introdução__

## __Fundamentos de Segurança Informática__

### __Proteção da Informação__

> Prevenir e __detetar__ ações não autorizadas.

Dados e informação estão guardados em:
* __Dispositivos de armazenamento__ (discos rígidos, pen drives, etc.)

* __Redes de computadores__ (Internet, intranets, etc.)

A proteção pode ser a nível de:
* ___Hardware___ -> Dispositivos de armazenamento, redes de computadores, etc

* ___Software___ -> Sistemas operativos, aplicações, etc

* __Dados__ -> Ficheiros, bases de dados, passwords, etc

* __Comunicação__ -> Ligações de comunicação local ou de longa distância, _router_, etc


### __Confidencialidade__

> Prevenir a divulgação não autorizada da informação.

* Esconder conteúdo de utilizadores não autorizados

* Informação não pode ser vista nem analisada

* Inclur meios para garantir quais informações podem ser divulgadas e para quem

### __Integridade__

> Garantir que a informação recebida é exatamente a mesma que foi enviada por uma entidade autorizada.

* Conteúdo não pode ser modificado, corrompido ou perdido por terceiros

* Garantir autenticidade da informação

* Impedir que entidades neguem a geração ou receção da informação

### __Disponibilidade__

> Garantir que a informação está acessível e utilizável sob pedido de uma entidade autorizada.

* Prevenir ___Denial of Service (DoS)___

### __Exemplos de Ataques__

#### __Passsivos__

* __Divulgação de Conteúdo__: O atacante lê o conteúdo da mensagem de A para B.

* __Análise de Tráfego__: O atacante observa o padrão das mensagens de A para B.

#### __Ativos__

* __Disfarce__: O atacante envia mensagens para B fazendo-se passar por A.

* __Repetição__: O atacante captura mensagens de A para B e, mais tarde, envia-as para B.

* __Modificação de Mensagem__: O atacante altera o conteúdo da mensagem de A para B.

* __Negação de Serviço__: O atacante impede que A e B comuniquem entre si.

## __Introdução à Criptografia__

### __Criptografia__

> Ciência de escrever mensagens codificadas.

### __Criptoanálise__

> Ciência de quebrar códigos e decifrar mensagens.

### __Criptologia__

> Ciência que reúne criptografia e criptoanálise.

### __Composição__

* __Cifra (E)__ -> Função que gera criptograma c a partir de mensagem m.

* __Decifra (D)__ -> Função que gera mensagem m' a partir de criptograma c (espera-se que m' = m).

* __Chave (K)__ -> Parâmetro que determina a cifra e a decifra.

* __(G)__ -> Função que gera chaves.

### __Cifra de César__

> Cifra de substituição simples.

* __E__: Cada letra da mensagem é substituída por outra letra que se encontra a um número fixo de posições à frente no alfabeto.
    * $ E(k, \ m) = (m + k) \ mod \ 26 = c $

* __D__: Cada letra do criptograma é substituída pela letra que se encontra a um número fixo de posições atrás no alfabeto.
    * $ D(k, \ c) = (c - k) \ mod \ 26 = m $

* __K__: Número de posições à frente ou atrás no alfabeto.