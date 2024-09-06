package org.lorenzo.eserciziolibreria.controller;

import org.lorenzo.eserciziolibreria.model.Libro;
import org.lorenzo.eserciziolibreria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/libri")
public class LibroController {

    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getAllLibri() {
        return libroService.getAllLibri();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable UUID id) {
        return ResponseEntity.ok(libroService.getLibroById(id));
    }

    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.saveLibro(libro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable UUID id) {
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }
}
