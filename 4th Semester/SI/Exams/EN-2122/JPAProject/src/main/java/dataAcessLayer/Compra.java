package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;


/**
 * The persistent class for the compra database table.
 *
 * CREATE TABLE IF NOT EXISTS Compra (
 *   id_jogador 	INTEGER NOT NULL,
 *   ref_jogo 		VARCHAR(10) NOT NULL,
 *   data			DATE NOT NULL,
 *   preço 		    DECIMAL(6, 2) NOT NULL CHECK (preço > 0),
 *   PRIMARY KEY(id_jogador, ref_jogo),
 *   FOREIGN KEY(id_jogador) REFERENCES Jogador(id),
 *   FOREIGN KEY(ref_jogo) REFERENCES Jogo(ref)
 * );
 */


@Entity
@Table(name="Compra")
@NamedQuery(name="Compra.findAll", query="SELECT c FROM Compra c")
public class Compra implements Serializable {
    public Compra() {}

    @EmbeddedId
    private CompraPK id;

    @ManyToOne
    @MapsId("idJogador")
    @JoinColumn(name="id_jogador", referencedColumnName = "id", updatable=false)
    private Jogador jogador;

    @ManyToOne
    @MapsId("refJogo")
    @JoinColumn(name="ref_jogo", referencedColumnName = "ref", updatable=false)
    private Jogo jogo;

    @Embeddable
    public static class CompraPK {
        public CompraPK() {}
        private Integer idJogador;
        private String refJogo;
    }
    @Column(name="data")
    private Date data;
    @Column(name="preço")
    private Float preco;

    public CompraPK getId() { return this.id; }
    public Integer getIdJogador() { return jogador.getId(); }
    public String getRefJogo() { return jogo.getRef(); }
    public Date getData() { return this.data; }
    public Float getPreco() { return this.preco; }
    public void setId(CompraPK id) { this.id = id; }
    public void setIdJogador(Integer idJogador) { this.jogador.setId(idJogador); }
    public void setRefJogo(String refJogo) { this.jogo.setRef(refJogo); }
    public void setData(Date data) { this.data = data; }
    public void setPreco(Float preco) { this.preco = preco; }
}
