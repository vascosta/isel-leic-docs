package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the Partida_Jogador_Unico database table.
 *
 * CREATE TABLE IF NOT EXISTS Partida_Jogador_Único (
 *     num_partida  INTEGER NOT NULL,
 *     id_jogador 	INTEGER NOT NULL,
 *     dificuldade	INTEGER NOT NULL CHECK (dificuldade BETWEEN 1 AND 5),
 *     pontuação	INTEGER NOT NULL,
 *     PRIMARY KEY(num_partida, id_jogador),
 *     FOREIGN KEY(num_partida, id_jogador) REFERENCES Partida(num, id_jogador)
 * );
 **/

@Entity
@Table(name = "Partida_Jogador_Unico")
@NamedQuery(name="Partida_Jogador_Unico.findAll", query="SELECT p FROM Partida_Jogador_Unico p")
public class Partida_Jogador_Unico implements Serializable {
    public Partida_Jogador_Unico() {}

    @EmbeddedId
    @Column(nullable = false)
    private Partida_Jogador_UnicoId id;

    @ManyToOne
    @MapsId("partida")
    @JoinColumns({
            @JoinColumn(name = "num_partida", referencedColumnName = "num", nullable = false),
            @JoinColumn(name = "id_jogador", referencedColumnName = "id_jogador", nullable = false)
    })
    private Partida partida;
    @Column(name = "dificuldade", nullable = false)
    private String dificuldade;

    @Column(name = "pontuação", nullable = false)
    private String pontuacao;

    public Partida_Jogador_UnicoId getId() { return id; }
    public Integer getNumPartida() { return partida.getNum(); }
    public Integer getIdJogador() { return partida.getIdJogador(); }
    public String getPontuacao() { return pontuacao; }
    public String getDificuldade() { return dificuldade; }

    public void setId() { this.id = new Partida_Jogador_UnicoId(); }
    public void setNumPartida(Integer numPartida) { this.partida.setNum(numPartida); }
    public void setIdJogador(Integer idJogador) { this.partida.setIdJogador(idJogador); }
    public void setPontuacao(String pontuacao) {this.pontuacao = pontuacao;}
    public void setDificuldade(String dificuldade) {this.dificuldade = dificuldade;}

    @Embeddable
    public static class Partida_Jogador_UnicoId implements Serializable {
        public Partida_Jogador_UnicoId() {}
        private Integer partida;
    }
}
