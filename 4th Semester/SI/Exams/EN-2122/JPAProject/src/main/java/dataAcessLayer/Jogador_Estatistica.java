package dataAcessLayer;

import jakarta.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the Jogador_Estatística database table.
 *
 * CREATE TABLE IF NOT EXISTS Jogador_Estatística (
 *     id_jogador 		INTEGER PRIMARY KEY NOT NULL,
 *     num_partidas 	INTEGER NOT NULL,
 *     num_jogos_difs 	INTEGER NOT NULL,
 *     total_pontos 	INTEGER NOT NULL,
 *     FOREIGN KEY(id_jogador) REFERENCES Jogador(id)
 * );
 **/


@Entity
@Table(name="Jogador_Estatistica")
@NamedQuery(name="Jogador_Estatistica.findAll", query="SELECT j FROM Jogador_Estatistica j")
public class Jogador_Estatistica implements Serializable {
    public Jogador_Estatistica() {}

    @Id
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_jogador", referencedColumnName = "id", unique=true)
    private Jogador jogador;

    @Column(name="num_partidas", nullable = false)
    private Integer numPartidas;

    @Column(name="num_jogos_difs", nullable = false)
    private Integer numJogosDif;

    @Column(name="total_pontos", nullable = false)
    private Integer totalPontos;

    public Integer getIdJogador() { return this.jogador.getId(); }
    public Integer getNumPartidas() { return this.numPartidas; }
    public Integer getNumJogosDif() { return this.numJogosDif; }
    public Integer getTotalPontos() { return this.totalPontos; }

    public void setNumPartidas(Integer novoNumPartidas) { this.numPartidas = novoNumPartidas; }
    public void setNumJogosDif(Integer novoNumJogosDif) { this.numJogosDif = novoNumJogosDif; }
    public void setTotalPontos(Integer novoTotalPontos) { this.totalPontos = novoTotalPontos; }
}
