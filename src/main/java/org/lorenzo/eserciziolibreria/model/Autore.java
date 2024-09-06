package org.lorenzo.eserciziolibreria.model;


import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Autore {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String cognome;

    @OneToMany(mappedBy = "autore", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Libro> listaOpere;

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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<Libro> getListaOpere() {
        return listaOpere;
    }

    public void setListaOpere(List<Libro> listaOpere) {
        this.listaOpere = listaOpere;
    }
}
