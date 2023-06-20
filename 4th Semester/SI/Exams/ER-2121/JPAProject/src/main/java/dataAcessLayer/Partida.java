package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the Partida database table.
 *
 * CREATE TABLE IF NOT EXISTS Partida (
 *   num 			SERIAL NOT NULL,
 *   id_jogador 	INTEGER NOT NULL,
 *   ref_jogo 		VARCHAR(10) NOT NULL,
 *   nome_região 	VARCHAR(255) NOT NULL,
 *   data_início 	DATE,
 *   data_fim 		DATE CHECK (data_início <= data_fim),
 *   hora_início 	TIME,
 *   hora_fim 		TIME CHECK (hora_início < hora_fim),
 *   PRIMARY KEY(num, id_jogador),
 *   FOREIGN KEY(id_jogador) REFERENCES Jogador(id),
 *   FOREIGN KEY(ref_jogo) REFERENCES Jogo(ref),
 *   FOREIGN KEY(nome_região) REFERENCES Região(nome)
 * );
 **/


@Entity
@Table(name = "Partida")
@NamedQuery(name="Partida.findAll", query="SELECT p FROM Partida p")
public class Partida implements Serializable {
    public Partida() {}

    @EmbeddedId
    @Column(nullable = false)
    private PartidaId id;

    @ManyToOne
    @MapsId("idJogador")
    @JoinColumn(name = "id_jogador", referencedColumnName = "id", nullable = false)
    private Jogador jogador;
    @ManyToOne
    @JoinColumn(name = "ref_jogo", referencedColumnName = "ref", nullable = false)
    private Jogo jogo;

    @ManyToOne
    @JoinColumn(name = "nome_região", referencedColumnName = "nome", nullable = false)
    private Regiao regiao;

    @Column(name = "data_início")
    private Date dataInicio;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(name = "hora_início")
    private Time horaInicio;

    @Column(name = "hora_fim")
    private Time horaFim;

    public PartidaId getId() { return id; }
    public Integer getNum() {return getId().num;}
    public Integer getIdJogador() {return jogador.getId();}
    public String getRefJogo() { return jogo.getRef(); }
    public String getRegiao() { return regiao.getNome(); }
    public Date getDataInicio() { return dataInicio; }
    public Date getDataFim() { return dataFim; }
    public Time getHoraInicio() { return horaInicio; }
    public Time getHoraFim() { return horaFim; }

    public void setId(PartidaId id) { this.id = id; }
    public void setNum(Integer num) { getId().num = num; }
    public void setIdJogador(Integer idJogador) { getId().idJogador = idJogador; }
    public void setRefJogo(String refJogo) { jogo.setRef(refJogo); }
    public void setDataInicio(Date dataInicio) { this.dataInicio = dataInicio; }
    public void setDataFim(Date dataFim) { this.dataFim = dataFim; }
    public void setHoraInicio(Time horaInicio) { this.horaInicio = horaInicio; }
    public void setHoraFim(Time horaFim) { this.horaFim = horaFim; }

    @Embeddable
    public static class PartidaId implements Serializable {
        public PartidaId() {}

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "num", nullable = false)
        private Integer num;

        private Integer idJogador;
    }
}
