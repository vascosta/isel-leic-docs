package dataAcessLayer;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * The persistent class for the Região database table.
 *
 * CREATE TABLE IF NOT EXISTS Região (
 *   nome VARCHAR(255) PRIMARY KEY NOT NULL
 * );
 **/

@Entity
@Table(name="Região")
public class Regiao implements Serializable {
    public Regiao() {}

    @Id
    @OneToMany
    @Column(name = "nome")
    private String nome;

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}