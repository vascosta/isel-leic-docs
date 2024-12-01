# __Modelos e Políticas para Controlo de Acessos__

## __Monitor de Referências__

<div align=center>

![](imgs/48.png)

</div>

### __Propriedades do PEP__

* Não deve ser possível __alterá-lo__.

* Não deve ser possível __contorná-lo__.

* __Deve ser pequeno__ e estar confinado ao núcleo de segurança do sistema por forma a facilitar a verificação da sua correção.

#
#

## __Elementos do Sistema de Controlo de Acessos__

* PEP depende dos __mecanismos de seguranç__.

* PDP depende das __políticas de segurança__ e do __modelo de segurança__.

### __Modelo de Segurança__

> Formalização da forma de aplicação das políticas de segurança.

### __Política de Segurança__

> Define as regras de controlo de acessos.

### __Mecanismos de Segurança__

> Funções de baixo nível que dão suporte à implementação de modelos e políticas de segurança.

#
#

## __Modelo Matriz de Acessos__

<div align=center>

![](imgs/49.png)

</div>

* $ S \rightarrow $ sujeitos.

* $ O \rightarrow $ objetos.

* $ A \rightarrow $ operações.

* $ M_{SO} \rightarrow $ matriz de operações.

    * $ M_{SO}[s][o] \rightarrow $ permissões do sujeito $ s $ sobre o objeto $ o $.

### __Tabela de Autorização__

<div align=center>

![](imgs/50.png)

</div>

#

### ___Capabilities___

<div align=center>

![](imgs/51.png)

</div>

* As permissões são guardadas junto dos sujeitos.

* A __capacidade__ (_capability_) de cada sujeito corresponde à sua __linha__ na matriz.

#### __Vantagens__

* Facilidade na obtenção das permissões associadas a um sujeito.

* Em ambientes distribuídos __elimina a necessidade de múltiplas autenticações__.

#### __Desvantagens__

* Para obter lista de acessos a objetos obriga a __pesquisar todas as capacidades__.

* Possibilidade de __cópia__ e uso __fraudulento__.

#

### ___Access Control Lists___

<div align=center>

![](imgs/52.png)

</div>

* As permissões são guardadas junto dos objetos.

* A __ACL__ de cada objeto corresponde à sua __coluna__ na matriz.

#### __Vantagens__

* Facilidade na obtenção das permissões associadas a um objeto.

* Ao eliminar um objeto elimina-se __todas as permissões a ele associadas__.

#### __Desvantagens__

* Para saber todas as permissões de um sujeito é necessário __pesquisar todas as ACLs__.

#
#

## __Permissões para Grupos__

<div align=center>

![](imgs/53.png)

</div>

* Os grupos funcionam como uma __camada intermédia__ na definição de controlos de acesso.

* As permissões podem ser associadas a grupos ou individualmente aos sujeitos.

* A __verificação de controlo de acesso__ passa a ser feita também em __função do sujeito ser membro ou não de um grupo__.

* É possível usar __permissões negativas__ para um __determinado sujeito dentro de um grupo__.

### __Exemplo - Windows__

* Após _login_ é atribuído ao utilizador um _access token_.

    * Em cada _access token_ estão presentes _security identifiers_ (SID) com a identificação do utilizador e dos grupos a que pertence.

* Após a criação de um objeto (recurso) é lhe associado um _security descriptor_ com:

    * O SID do seu done.

    * _Discretionary Access Control List_ (DACL).

    * _System Access Control List_ (SACL) com a política do sistema para auditar o acesso ao objeto e o "nível de integridade" do mesmo.

* Uma ACL é uma lista de _Access Control Entry_ (ACE) com:

    * O SID do sujeito ou grupo.

    * Permissões ou negações.

    * Ações.

#
#

## __Controlo de Acessos através de DACL__

> Para determinar se o acesso é autorizado ou não, a DACL é percorrida até __à negação de uma das ações__ ou __permissão de todas as ações requeridas__.

<div align=center>

![](imgs/54.png)

</div>

* À cabeça ficam as ACE que negam acesso.