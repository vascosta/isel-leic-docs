package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the Jogo_Estatistica database table.
 *
 * CREATE TABLE IF NOT EXISTS Jogo_Estatistica (
 *     ref_jogo 		VARCHAR(10) PRIMARY KEY NOT NULL,
 *     num_partidas 	INTEGER NOT NULL,
 *     num_jogadores	INTEGER NOT NULL,
 *     total_pontos 	INTEGER NOT NULL,
 *     FOREIGN KEY(ref_jogo) REFERENCES Jogo(ref)
 * );
 **/


@Entity
@Table(name="Jogo_Estatistica")
@NamedQuery(name="Jogo_Estatistica.findAll", query="SELECT j FROM Jogo_Estatistica j")
public class Jogo_Estatistica implements Serializable {
    public Jogo_Estatistica() {}

    @Id
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="ref_jogo", referencedColumnName = "ref", unique=true)
    private Jogo jogo;

    @Column(name="num_partidas", nullable = false)
    private Integer numPartidas;

    @Column(name="num_jogadores", nullable = false)
    private Integer numJogadores;

    @Column(name="total_pontos", nullable = false)
    private Integer totalPontos;

    public String getRefJogo() { return this.jogo.getRef(); }
    public Integer getNumPartidas() { return this.numPartidas; }
    public Integer getNumJogadores() { return this.numJogadores; }
    public Integer getTotalPontos() { return this.totalPontos; }

    public void setRefJogo(String novoRefJogo) { this.jogo.setRef(novoRefJogo); }
    public void setNumPartidas(Integer novoNumPartidas) { this.numPartidas = novoNumPartidas; }
    public void setNumJogadores(Integer novoNumJogadores) { this.numJogadores = novoNumJogadores; }
    public void setTotalPontos(Integer novoTotalPontos) { this.totalPontos = novoTotalPontos; }
}
