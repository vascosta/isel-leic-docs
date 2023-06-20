# __Acesso a Dados__

## __Jakarta Persistence API (JPA)__

### ___Entity Manager___

```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExemplo");
EntityManager em = emf.createEntityManager();

em.close();                 // fecha o entity manager
em.persist(Object o)        // persiste (adiciona ao em) a entidade o
em.remove(Object o)         // atualiza a entidade o

// procura a entidade o da classe c
em.find(Class c, Object o, LockModeType lockMode)  

// procura a entidade o da classe c e, ao contrário do find, sem carregar toda a entidade
em.getReference(Class c, Object o) 

EntityTransaction transaction = em.getTransaction();
transaction.begin();    // inicia uma transação
transaction.commit();   // faz commit da transação
transaction.rollback(); // faz rollback da transação
transaction.close();    // fecha a transação
```

---

## __Mapeamento__

```sql
CREATE TABLE cacifos (
    numCac SERIAL PRIMARY KEY,
    descrCac VARCHAR(80)
);

CREATE TABLE alunos (
    numAl NUMERIC(6) PRIMARY KEY, 
    nomeAl VARCHAR(80),
    aluga_cac INT UNIQUE REFERENCES cacifos
);

CREATE TABLE hobbies (
    numAl NUMERIC(6) REFERENCES alunos, 
    numHb INT,
    descr VARCHAR(100), 
    PRIMARY KEY(numAl, numHb)
);
    
CREATE TABLE disciplinas (
    codDisc CHAR(6) PRIMARY KEY,
    descrDisc VARCHAR(80)
);

CREATE TABLE inscr (
    numAl NUMERIC(6) REFERENCES alunos,
    codDisc CHAR(6) REFERENCES disciplinas,
    nota INTEGER CHECK (nota BETWEEN 0 AND 20),
    PRIMARY KEY(numAl, CodDisc)
);

CREATE TABLE eventos (
    idEv SERIAL PRIMARY KEY,
    descrEv VARCHAR(80),
    numAl NUMERIC(6), 
    codDisc CHAR(6),
    foreign KEY(numAl, codDisc) REFERENCES inscr
);
```

``Privilegiou-se a navegação de aluno para cacifo``

---

### __Entidades__

__Anotações__:
* ___@Entity___ $ \rightarrow $ __entidade__
* ___@Table___ (opcional) $ \rightarrow $ __tabela__ a que a __entidade__ está associada
* ___@Id___ $ \rightarrow $ __atributo__ é uma __chave primária__
* ___@EmbeddedId___ $ \rightarrow $ __atributo__ é uma __chave primária composta__
* ___@GeneratedValue___ $ \rightarrow $ __valor__ do __atributo__ é __gerado automaticamente__

```java
@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    private long numal;

    private String nomeal;

    public Aluno() {}

    // Getters
    public long getNumal() {return this.numal;}
    public String getNomeal() {return this.nomeal;}

    // Setters
    public void setNumal(long numal) {this.numal = numal;}
    public void setNomeal(String nomeal) {this.nomeal = nomeal;}
}
```

```java
@Entity
@Table(name = "cacifos")
public class Cacifo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // SERIAL
    private Integer numcac;

    private String descrcac;

    public Cacifo() {}

    // Getters e Setters
}
```

```java
@Entity
@Table(name = "hobbies")
public class Hobby {
    @EmbeddedId // Chave primária composta
    private HobbyPK id;

    private String descr;

    public Hobby() {}
    
    // Getters e Setters

    @Embeddable
    public class HobbyPK {
        private long numal;

        private Integer numhb;

        public HobbyPK() {}
        
        // Getters e Setters
    }
}
```

---

### __Associações__

Anotações:
* ___@OneToOne___ $ \rightarrow $ 1-1
* ___@OneToMany___ $ \rightarrow $ 1-M
* ___@ManyToOne___ (não usado) $ \rightarrow $ M-1
* ___@ManyToMany___ $ \rightarrow $ M-M
* ___@JoinColumn___ $ \rightarrow $ indica a coluna que é uma chave estrangeira


__1-1__:
```java
@Entity
@Table(name = "alunos")
public class Aluno {
    ...

    @OneToOne
    @JoinColumn(name = "aluga_cac“, unique = true) // Chave estrangeira
    private Cacifo cacifo;

    ...
}
```

```java
@Entity
@Table(name = "cacifos")
public class Cacifo {
    ...

    @OneToOne(mappedBy = "cacifo") 
    // Atributo que representa a associação do lado da entidade Aluno
    private Aluno aluno;
    ...
}
```

__1-M__:
```java
@Entity
@Table(name = "alunos")
public class Aluno {
    ...
    
    @OneToMany(
        mappedBy = "aluno", 
        cascade = CascadeType.PERSIST, orphanRemoval = true
    )
    // Atributo que representa a associação do lado da entidade Hobby
    private List<Hobby> hobies;
    
    ...
}
```

```java
@Entity
@Table(name = "hobbies")
public class Hobby {
    ...

    @MapsId("numal")
    @ManyToOne
    @JoinColumn(name = "numal")
    private Aluno aluno;

    ...
}
```

```java
@Entity
@Table(name = "inscr")
public class Inscr {
    ...

    @OneToMany(mappedBy = "inscr")
    private List<Evento> eventos;
    
    ...
}
```

```java
@Entity
@Table(name = "eventos")
public class Evento {
    ...

    @ManyToOne
    // Chave estrangeira composta
    @JoinColumns({
    @JoinColumn(name = "coddisc", referencedColumnName = "coddisc"),
    @JoinColumn(name = "numal", referencedColumnName = "numal")
    }) // referencedColumnName é necessário em JoinColumns
    private Inscr inscr;
}
```

__M-M__:

De modo a evitar o uso de __@ManyToMany__, tratamos as __associações__ __M:M__ como __entidades associativas__ com __associações M:1__ para as __entidades__ nelas
__envolvidas__ e com __associações de 1:M__ do lado dos __participantes__ para a __associação__.

```java
@Entity
@Table(name = "alunos")
public class Aluno {
    ...
    
    @OneToMany(
        mappedBy = "aluno", 
        cascade = CascadeType.PERSIST, orphanRemoval = true
    )
    // Atributo que representa a associação do lado da entidade Inscr
    private List<Inscr> inscrs;
    
    ...
}
```

```java
@Entity
@Table(name = "disciplinas")
public class Disciplina {
    ...

    @OneToMany(
        mappedBy = "disciplina", 
        cascade = CascadeType.PERSIST, orphanRemoval = true
    )
    // Atributo que representa a associação do lado da entidade Inscr
    private List<Inscr> inscrs;
    
    ...
}
```

```java
@Entity
@Table(name = "inscr")
public class Inscr {
    ...

    @ManyToOne
    @MapsId("numal")
    @JoinColumn(name = "numal")
    private Aluno aluno;

    @ManyToOne
    @MapsId("coddisc")
    @JoinColumn(name = "coddisc")
    private Disciplina disciplina;
    
    ...
}
```

## __Transações__

__E.g.__:

``Inserir um aluno com um cacifo associado``
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExemplo");
EntityManager em = emf.createEntityManager();
EntityTransaction tr = em.getTransaction();
try
{
    tr.begin();

    // Criação de um aluno
    Aluno a = new Aluno();
    a.setNumal(555);
    a.setNomeal("rui silva");

    // Criação de um cacifo
    Cacifo c = new Cacifo();
    c.setDescrcac("Cacifo 1");
    
    a.setCacifo(c); // Associação do cacifo ao aluno
    
    em.persist(a);  // Inserção do aluno
    tr.commit();
} catch (Exception e) {
    tr.rollback();
    throw new RuntimeException(e);
}
```

__E.g.__:

``Inserir um aluno com vários hobbies``
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExemplo");
EntityManager em = emf.createEntityManager();
EntityTransaction tr = em.getTransaction();
try
{
    tr.begin();

    // Criação de um aluno
    Aluno a = new Aluno();
    a.setNumal(555); 
    a.setNomeal("rui silva");

    // Criação do array de hobbies
    List<Hobby> lh = new ArrayList<Hobby>();
    Hobby h1 = new Hobby();

    // Criação de um hobby
    h1.setDescr("hobby 1");
    HobbyPK ch = new HobbyPK(); // Criação da chave primária
    ch.setNumhb(1);
    h1.setId(ch); 
    h1.setAluno(a);             // Associação do aluno ao hobby

    ...                         // Criação de outros hobbies

    lh.add(h1);                 // Adição do hobby ao array
    a.setHobbies(lh);           // Associação dos hobbies ao aluno
    em.persist(a);              // Inserção do aluno
    tr.commit();
} catch (Exception e) {
    tr.rollback();
    throw new RuntimeException(e);
}

```

__E.g.__:

``Inscrever um aluno numa disciplina``
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExemplo");
EntityManager em = emf.createEntityManager();
EntityTransaction tr = em.getTransaction();

try {
    tr.begin();

    //Usado em vez de find para evitar carregar toda a entidade
    Disciplina d = em.getReference(Disciplina.class, "isi");

    // Busca de um aluno
    Aluno a = em.getReference(Aluno.class,Long.valueOf(222));
    
    // Criação de uma inscrição
    Inscr i = new Inscr();
    i.setNota(19);
    i.setAluno(a);
    i.setDisciplina(d);
    em.persist(i);
    em.getTransaction().commit();
} catch (Exception e) {
    tr.rollback();
    throw new RuntimeException(e);
}
```

---

## ___Queries___

```java	
Query q = em.createQuery(query);

// Parâmetros
q.setParameter("param", valor);

// Resultados
q.getResultList();
(Tipo) q.getSingleResult();
```

---

## __Procedimentos__

Níveis de isolamento:
* ___Connection.TRANSACTION_READ_UNCOMMITTED___
* ___Connection.TRANSACTION_READ_COMMITTED___
* ___Connection.TRANSACTION_REPEATABLE_READ___
* ___Connection.TRANSACTION_SERIALIZABLE___

```java
 public Tipo nomeProcedimento(Tipo param1, Tipo param2) {
    EntityTransaction transaction = em.getTransaction();
    em.getTransaction().begin();
    Connection cn = em.unwrap(Connection.class);
    try {
        cn.setTransactionIsolation(nívelIsolamento);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    try (CallableStatement cs = cn.prepareCall("call nomeProcedimento(?,?,?)")) {
        cs.registerOutParameter(1, Types.TIPO); // Parâmetro de saída (OUT)
        // Atribuir valores aos parametros de entrada
        cs.setTipo(2, param1);
        cs.setTipo(3, param2);
        cs.execute();         // Executa o procedimento
        transaction.commit();
        return cs.getTipo(1); // Retorna o parâmetro de saída (opcional)
    } catch (Exception e) {
        transaction.rollback();
        throw new RuntimeException(e);
    }
}
```


---

## __Funções__

``Não necessitam de transação``

```java
public Tipo nomeFunção(Tipo param1, Tipo param2) {
    try {
        StoredProcedureQuery q = em.createStoredProcedureQuery("nomeFunção");
        // Registar os parametros de entrada e saída
        q.registerStoredProcedureParameter(1, Tipo.class, ParameterMode.IN);
        q.registerStoredProcedureParameter(2, Tipo.class, ParameterMode.IN);
        q.registerStoredProcedureParameter(3, Tipo.class, ParameterMode.OUT);
        // Atribuir valores aos parametros de entrada
        q.setParameter(1, param1);
        q.setParameter(2, param2);
        q.execute();                                // Executa a função
        
        return (Tipo) q.getOutputParameterValue(3); // Retorna o parâmetro de saída
        // Caso seja retornado uma lista de resultados
        return (List<Object[]>) q.getResultList();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
```

---

## __Controlo de Concorrência__

```java
public Tipo nomeFuncao(Tipo param1, Tipo param2) {
    try {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAExemplo");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tr = em.getTransaction();
        tr.begin();

        ...
        
        tr.commit();
        return ...
    } catch (RollbackException | PessimisticLockException e) {
        if(e instanceof PessimisticLockException) {
            if (em.getTransaction().isActive())
                rollbackBusinessTransaction();
            throw new RuntimeException("Erro de concorrência");
        }
        else throw e;
    }
}
```

### __Optimista__

---

### __Pesimista__

__Tipo de lock__ (_LockModeType_):
* _LockModeType.PESSIMISTIC_READ_
* _LockModeType.PESSIMISTIC_WRITE_