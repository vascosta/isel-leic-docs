package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * The persistent class for the conversa database table.
 *
 * CREATE TABLE IF NOT EXISTS Conversa (
 *   id 			INTEGER PRIMARY KEY NOT NULL,
 *   id_jogador 	INTEGER NOT NULL,
 *   nome 			VARCHAR(255) NOT NULL,
 *   FOREIGN KEY(id_jogador) REFERENCES Jogador(id)
 * );
 **/


@Entity
@Table(name="Conversa")
@NamedQuery(name="Conversa.findAll", query="SELECT c FROM Conversa c")
public class Conversa implements Serializable {
    public Conversa() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_jogador", referencedColumnName = "id", nullable = false)
    private Jogador jogador;

    @Column(name="nome", nullable = false)
    private String nome;

    public Integer getId() { return this.id; }
    public Integer getJogadorId() { return this.jogador.getId(); }
    public String getNome() { return this.nome; }

    public void setId(Integer id) { this.id = id; }
    public void setJogador(Jogador novoJogador) { this.jogador = novoJogador; }
    public void setNome(String novoNome) { this.nome = novoNome; }
}
