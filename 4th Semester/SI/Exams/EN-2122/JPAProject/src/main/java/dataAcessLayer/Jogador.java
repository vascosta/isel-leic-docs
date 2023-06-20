package dataAcessLayer;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the Jogador database table.
 *
 * CREATE TABLE IF NOT EXISTS Jogador (
 *   id 			INTEGER PRIMARY KEY,
 *   username 		VARCHAR(255) UNIQUE NOT NULL,
 *   email 		    VARCHAR(255) UNIQUE NOT NULL,
 *   estado 		VARCHAR(25) NOT NULL CHECK (estado IN ('Ativo', 'Inativo', 'Banido')),
 *   nome_região	VARCHAR(255) NOT NULL,
 *   FOREIGN KEY(nome_região) REFERENCES Região(nome)
 * );
 **/

@Entity
@Table(name="Jogador")
@NamedQuery(name="Jogador.findAll", query="SELECT j FROM Jogador J")
public class Jogador implements Serializable {
    public Jogador() {}
    private static final List<String> estadosPossiveis = List.of("Ativo", "Inativo", "Banido");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable=false)
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;
    
    @Column(name="estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name="nome_região", referencedColumnName = "nome", nullable = false)
    private Regiao regiao;

    public Integer getId() { return this.id; }
    public String getUsername() { return this.username; }
    public String getEmail() { return this.email; }
    public String getEstado() { return this.estado; }
    public String getNomeRegiao() { return this.regiao.getNome(); }

    public void setId(Integer id) { this.id = id; }
    public void setUsername(String newUsername) { this.username = newUsername; }
    public void setEmail(String newEmail) { this.email = newEmail; }
    public void setEstado(String estado) { if(estadosPossiveis.contains(estado)) this.estado = estado; }
}