package demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // <-- A anotação DEVE ficar aqui, no topo da classe
public class Lutador {

    @Id // <-- A anotação de ID fica em cima do atributo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String categoria;
    private String apelido;
    private String arte;

    // O JPA exige um construtor vazio para funcionar
    public Lutador() {
    }

    public Lutador(int id, String nome, String categoria, String apelido, String arte) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.apelido = apelido;
        this.arte = arte;
    }

    // Seus getters e setters abaixo estão perfeitos...
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getApelido() { return apelido; }
    public void setApelido(String apelido) { this.apelido = apelido; }
    public String getArte() { return arte; }
    public void setArte(String arte) { this.arte = arte; }

    @Override
    public String toString() {
        return "Lutador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", apelido='" + apelido + '\'' +
                ", arte='" + arte + '\'' +
                '}';
    }
}