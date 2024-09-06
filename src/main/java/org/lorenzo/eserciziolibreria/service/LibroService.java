package org.lorenzo.eserciziolibreria.service;


import org.lorenzo.eserciziolibreria.model.Libro;
import org.lorenzo.eserciziolibreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getAllLibri() {
        return libroRepository.findAll();
    }

    public Libro getLibroById(UUID id) {
        return libroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Libro not found with id " + id));
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteLibro(UUID id) {
        if (!libroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Libro not found with id " + id);
        }
        libroRepository.deleteById(id);
    }
}
