package dataAcessLayer;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the Jogo database table.
 *
 * CREATE TABLE IF NOT EXISTS Jogo (
 *   ref 	VARCHAR(10) PRIMARY KEY NOT NULL,
 *   nome	VARCHAR(255) UNIQUE NOT NULL,
 *   url 	VARCHAR(255) NOT NULL
 * );
 */



@Entity
@Table(name="Jogo")
@NamedQuery(name="Jogo.findAll", query="SELECT j FROM Jogo j")
public class Jogo implements Serializable {
    public Jogo() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ref;
    @Column(name="nome")
    private String nome;
    @Column(name="url")
    private String url;

    public String getRef() { return this.ref; }
    public String getNome() { return this.nome; }
    public String getUrl() { return this.url; }
    public void setRef(String newRef) { this.ref = newRef; }
    public void setNome(String novoNome) { this.nome = novoNome; }
    public void setUrl(String novoUrl) { this.url = novoUrl; }
}
