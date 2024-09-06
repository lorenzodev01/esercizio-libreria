package org.lorenzo.eserciziolibreria.model;



import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Libro {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "autore_id", nullable = false)
    private Autore autore;

    @Column(length = 255)
    private String sinossi;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public String getSinossi() {
        return sinossi;
    }

    public void setSinossi(String sinossi) {
        this.sinossi = sinossi;
    }
}
