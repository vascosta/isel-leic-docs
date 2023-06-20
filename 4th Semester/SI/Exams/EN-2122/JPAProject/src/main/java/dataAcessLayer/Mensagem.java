package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


/**
 * The persistent class for the Mensagem database table.
 *
 * CREATE TABLE IF NOT EXISTS Mensagem (
 *   num 			SERIAL NOT NULL,
 *   id_conversa 	INTEGER NOT NULL,
 *   id_jogador 	INTEGER NOT NULL,
 *   data 			DATE NOT NULL,
 *   hora 			TIME NOT NULL,
 *   texto 		TEXT NOT NULL,
 *   PRIMARY KEY(num, id_conversa),
 *   FOREIGN KEY(id_conversa) REFERENCES Conversa(id),
 *   FOREIGN KEY(id_jogador) REFERENCES Jogador(id)
 * );
 **/


@Entity
@Table(name="Mensagem")
@NamedQuery(name="Mensagem.findAll", query="SELECT m FROM Mensagem m")
public class Mensagem implements Serializable {
    public Mensagem() {}

    @EmbeddedId
    private MensagemId id;

    @ManyToOne
    @JoinColumn(name="id_jogador", referencedColumnName = "id", updatable=false)
    private Jogador jogador;

    @ManyToOne
    @MapsId("numConversa")
    @JoinColumn(name="id_conversa", referencedColumnName = "id", nullable = false)
    private Conversa conversa;

    @Column(name="data", nullable = false)
    private Date data;

    @Column(name="hora", nullable = false)
    private Time hora;

    @Column(name="texto", nullable = false)
    private String texto;

    public MensagemId getId() { return this.id; }
    public Integer getNum() { return getId().num; }
    public Integer getNumConversa() { return conversa.getId(); }
    public Integer getJogadorId() { return jogador.getId(); }
    public Date getDate() { return this.data; }
    public Time getHora() { return this.hora; }
    public String getTexto() { return texto; }

    public void setId(MensagemId id) { this.id = id; }
    public void setNum(Integer num) { this.getId().num = num; }
    public void setNumConversa(Integer numConversa) { conversa.setId(numConversa); }
    public void setJogador(Jogador jogador) { this.jogador = jogador; }
    public void setDate(Date novaData) { this.data = novaData; }
    public void setHora(Time novaHora) { this.hora = novaHora; }
    public void setTexto(String texto) { this.texto = texto; }

    @Embeddable
    public static class MensagemId implements Serializable {
        public MensagemId() {}

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "num", nullable = false)
        private Integer num;

        private Integer numConversa;
    }
}