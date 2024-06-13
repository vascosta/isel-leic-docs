# 1
````
F -> Um sistema é escalável se ele poder aumentar a sua capacidade sem que isso afete o desempenho.

F ->

F -> O Teorema CAP apenas garante 2 dos 3 requisitos: Consistência, Disponibilidade e Tolerância a Partições.

V
````

# 2
````
V

V

F -> Um bucket fine-grained tem uma ACL específica para cada blob.

F -> Tem sim custos extras no armazenamento e no transporte de dados.
````

# 3
````
V

V

V

V
````

# 4
````
V

V

F -> Deveria ser definida como "(Mensagem) returns (Mensagem)".

V
````

# 5
````
F -> Um instance group é criado através de uma template.

V/F -> Se considerarmos que a escalabilidade não é obrigatóriamente automática (pode ser controlada por uma aplicação), então pode ser F.

V

F -> Uma Cloud function com trigger Pub/Sub é ativada quando é publicada uma mensagem num tópico.
````

# 6
````
Limitações:

- Falta de consistência -> Uma Cloud Function não guarda estado entre chamadas, ou seja, se guardármos um valor de um inteiro como um campo de instância da classe, ele será perdido na próxima chamada.

Solução:

- Usar uma base de dados (e.g. Firestore) para guardar o valor de um inteiro, que a cada ativação da Cloud Function, esta iria aceder à base de dados para ler, atualizar e retornar o valor.
````

# 7
````
a) Pode receber as mensagens de reclamação (m1, m2 e m3)

b) Assim como "a)", pode também receber as mensagens de reclamação (m1, m2 e m3)

c), d) e e) Podem tratar as mensagens de reclamação (m1, m2 e m3), visto que ambas as subscrições (rec-sub1 e rec-sub2) foram feitas no mesmo tópico (reclamações).

Este padrão é conhecido como Fan-out, onde várias subscrições são feitas no mesmo tópico, permitindo que várias aplicações (c1, c2 e c3) possam receber as mensagens do tópico.
````

# 8
````
Concordo com esta afirmação.

Usar o mesmo contrato protobuf permite que a distribuição de carga seja feita de forma mais eficiente, visto que o contrato é igual para todos os servidores.

Se um servidor não conseguir processar uma imagem, esta pode ser reencaminhada para outro servidor que consiga processar a imagem, sem que seja necessário fazer alterações no contrato protobuf, visto que todos partilham o mesmo contrato.
````