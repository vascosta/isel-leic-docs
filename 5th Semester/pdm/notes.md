# __Manifesto__

* Usado para indicar os componentes (e.g. activities) que constituem a aplicação.
* Usado para indicar as permissões necessárias à aplicação.
* Usado para indicar o nome completo da classe derivada de Application a ser instanciada.
* Usado para caracterizar os requisitos da aplicação.
* Usado para identificar os requisitos para os dispositivos alvo da aplicação.
* Incluído no APK resultante do procedimento de build.

#

# ___Resources___

* Usado para facilitar a adequação da aplicação à configuração do dispositivo onde está a ser executada (e.g. idioma).


``Num dispositivo Android, ao ser mudada a definição global da língua do sistema são destruídas todas as instâncias de Activity existentes para que assumam a nova configuração na sua reconstrução``

#

# ___Intents___

A activação de uma activity pode ser realizada passando um intent startActivity.

## __Implícito__

* Define pelo menos um intent-filter no manifesto da aplicação de destino.
* Identifica uma acção a ser realizada.

## __Explícito__

* Identifica o componente de destino (e.g com o nome completo da classe do componente de destino)



## __Extras de um__ ___Intent___

* Admite o uso de tipos primitivos
* Admite o uso de tipos Parcelable
* Admite o uso de tipos anotados com @Parcelize

A passagem de dados entre __activities__ usando tipos definidos pela aplicação como extras de intents só é possível em extras de intents __explícitos__.

A passagem de dados entre __apps__ usando tipos definidos pela aplicação como extras de intents só é possível em extras de intents __implícitos__.

