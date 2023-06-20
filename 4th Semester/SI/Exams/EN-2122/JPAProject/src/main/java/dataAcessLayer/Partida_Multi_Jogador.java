package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the Partida_Multi_Jogador database table.
 *
 * CREATE TABLE IF NOT EXISTS Partida_Multi_Jogador (
 *         num_partida INTEGER NOT NULL,
 *         id_jogador 	INTEGER NOT NULL,
 *         estado 		VARCHAR(25) NOT NULL CHECK (estado IN ('Por Iniciar', 'A aguardar jogadores', 'Em curso', 'Terminada')),
 *         pontuação	INTEGER NOT NULL,
 *         PRIMARY KEY(num_partida, id_jogador),
 *         FOREIGN KEY(num_partida, id_jogador) REFERENCES Partida(num, id_jogador)
 * );
 **/


@Entity
@Table(name = "Partida_Multi_Jogador")
@NamedQuery(name="Partida_Multi_Jogador.findAll", query="SELECT p FROM Partida_Multi_Jogador p")
public class Partida_Multi_Jogador implements Serializable {
    private static final List<String> estadosPossiveis = List.of("Por Iniciar", "A aguardar jogadores", "Em curso", "Terminada");
    public Partida_Multi_Jogador() {}

    @EmbeddedId
    private Partida_Multi_JogadorId id;

    @ManyToOne
    @MapsId("partida")
    @JoinColumns({
            @JoinColumn(name = "num_partida", referencedColumnName = "num", nullable = false),
            @JoinColumn(name = "id_jogador", referencedColumnName = "id_jogador", nullable = false)
    })
    private Partida partida;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "pontuação", nullable = false)
    private String pontuacao;

    public Partida_Multi_JogadorId getId() { return id; }
    public Integer getNumPartida() { return partida.getNum(); }
    public Integer getIdJogador() { return partida.getIdJogador(); }
    public String getPontuacao() { return pontuacao; }
    public String getEstado() { return estado; }

    public void setId() { this.id = new Partida_Multi_JogadorId(); }
    public void setNumPartida(Integer numPartida) { this.partida.setNum(numPartida); }
    public void setIdJogador(Integer idJogador) { this.partida.setIdJogador(idJogador); }
    public void setPontuacao(String pontuacao) { this.pontuacao = pontuacao; }
    public void setEstado(String estado) { if(estadosPossiveis.contains(estado)) this.estado = estado; }

    @Embeddable
    public static class Partida_Multi_JogadorId implements Serializable {
        public Partida_Multi_JogadorId() {}

        private Integer partida;
    }
}