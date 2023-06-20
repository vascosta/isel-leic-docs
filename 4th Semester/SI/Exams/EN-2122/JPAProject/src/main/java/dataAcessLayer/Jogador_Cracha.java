package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the Cracha database table.
 *
 * CREATE TABLE IF NOT EXISTS Jogador_Crachá (
 *     id_jogador 	INTEGER NOT NULL,
 *     ref_jogo 	VARCHAR(10) NOT NULL,
 *     nome_cracha	VARCHAR(255) NOT NULL,
 *     PRIMARY KEY(id_jogador, ref_jogo, nome_cracha),
 *     FOREIGN KEY(id_jogador) REFERENCES Jogador(id),
 *     FOREIGN KEY(nome_cracha, ref_jogo) REFERENCES Crachá(nome, ref_jogo)
 * );
 **/

@Entity
@Table(name="Jogador_Cracha")
@NamedQuery(name="Jogador_Cracha.findAll", query="SELECT c FROM Jogador_Cracha c")
public class Jogador_Cracha implements Serializable {
    public Jogador_Cracha() {}

    @EmbeddedId
    private Jogador_CrachaId id;

    @ManyToOne
    @MapsId("idJogador")
    @JoinColumn(name = "id_jogador",  referencedColumnName = "id", updatable=false)
    private Jogador jogador;

    @ManyToOne
    @MapsId("cracha")
    @JoinColumns({
        @JoinColumn(name = "ref_jogo", referencedColumnName = "ref_jogo", updatable = false),
        @JoinColumn(name = "nome_cracha", referencedColumnName = "nome", updatable = false)
    })
    private Cracha cracha;

    public Jogador_CrachaId getId() { return this.id; }
    public String getNomeCracha() { return this.cracha.getNome(); }
    public Integer getIdJogador() { return this.jogador.getId(); }
    public String getRefJogo() { return this.cracha.getRefJogo(); }
    public void setId() { this.id = new Jogador_CrachaId(); }
    public void setIdJogador(Integer idJogador) { this.jogador.setId(idJogador); }
    public void setRefJogo(String refJogo) { this.cracha.setRefJogo(refJogo); }
    public void setNomeCracha(String nomeCracha) { this.cracha.setNome(nomeCracha); }
    public void setId(Jogador_CrachaId id) { this.id = id; }
    @Embeddable
    public static class Jogador_CrachaId {
        public Jogador_CrachaId() {}
        private Integer idJogador;

        // Has both refJogo and nomeCracha as foreign keys from Cracha
        private String cracha;
    }
}
