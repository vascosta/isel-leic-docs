package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the amizade database table.
 *
 * CREATE TABLE IF NOT EXISTS Amizade (
 *   id_jogador_1 	INTEGER NOT NULL,
 *   id_jogador_2 	INTEGER NOT NULL,
 *   PRIMARY KEY(id_jogador_1, id_jogador_2),
 *   FOREIGN KEY(id_jogador_1) REFERENCES Jogador(id),
 *   FOREIGN KEY(id_jogador_2) REFERENCES Jogador(id)
 * );
 */


@Entity
@Table(name = "Amizade")
@NamedQuery(name="Amizade.findAll", query="SELECT a FROM Amizade a")
public class Amizade implements Serializable {
    public Amizade() {}

    @EmbeddedId
    private AmizadeId id;

    @ManyToOne
    @MapsId("idJogador1")
    @JoinColumn(name = "id_jogador_1", referencedColumnName = "id", nullable = false)
    private Jogador jogador1;

    @ManyToOne
    @MapsId("idJogador2")
    @JoinColumn(name = "id_jogador_2", referencedColumnName = "id", nullable = false)
    private Jogador jogador2;

    public AmizadeId getId() { return id; }
    public Integer getJogador1() { return jogador1.getId(); }
    public Integer getJogador2() { return jogador2.getId(); }
    public void setId(AmizadeId id) { this.id = id; }
    public void setJogador1(Integer idJogador1) { this.jogador1.setId(idJogador1); }
    public void setJogador2(Integer idJogador2) { this.jogador2.setId(idJogador2); }
    @Embeddable
    public static class AmizadeId implements Serializable {
        public AmizadeId() {}
        private Integer idJogador1;
        private Integer idJogador2;
    }
}
