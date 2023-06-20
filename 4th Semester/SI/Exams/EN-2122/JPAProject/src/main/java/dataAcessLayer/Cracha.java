package dataAcessLayer;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;
import java.io.Serializable;

/**
 * The persistent class for the Cracha database table.
 *
 * CREATE TABLE IF NOT EXISTS Crachá (
 *   nome 			VARCHAR(255) NOT NULL,
 *   ref_jogo 		VARCHAR(10) NOT NULL,
 *   limite_pontos	INTEGER NOT NULL,
 *   url 			VARCHAR(255) NOT NULL,
 *   PRIMARY KEY(nome, ref_jogo),
 *   FOREIGN KEY(ref_jogo) REFERENCES Jogo(ref)
 * );
 **/

@Entity
@Table(name="Cracha")
@NamedQuery(name="Cracha.findAll", query="SELECT c FROM Cracha c")
@OptimisticLocking(type= OptimisticLockingType.CHANGED_COLUMNS)
public class Cracha implements Serializable {
    public Cracha() {}
    @EmbeddedId
    private CrachaId id;

    @ManyToOne
    @MapsId("refJogo")
    @JoinColumn(name = "ref_jogo",  referencedColumnName = "ref", updatable = false)
    private Jogo jogo;

    @Embeddable
    public static class CrachaId {
        public CrachaId(){}
        public CrachaId(String nome_cracha, String ref_jogo) {
            nome = nome_cracha;
            refJogo = ref_jogo;
        }
        @Column(name = "nome")
        private String nome;
        private String refJogo;
    }

    @Column(name="limite_pontos", nullable = false)
    private Integer limite_pontos;

    @Column(name="url", nullable = false)
    private String url;

    public CrachaId getId() { return this.id; }
    public String getNome() { return getId().nome; }
    public String getRefJogo() { return jogo.getRef(); }
    public Integer getLimitePontos() { return this.limite_pontos; }
    public String getUrl() { return this.url; }

    public void setId(CrachaId id) { this.id = id; }
    public void setNome(String novoNome) { getId().nome = novoNome; }
    public void setRefJogo(String refJogo) { jogo.setRef(refJogo); }
    public void setLimitePontos(Integer novoLimitePontos) { this.limite_pontos = novoLimitePontos; }
    public void setUrl(String novoUrl) { this.url = novoUrl; }
}