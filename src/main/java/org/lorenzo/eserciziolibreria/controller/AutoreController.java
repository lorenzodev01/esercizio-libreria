package org.lorenzo.eserciziolibreria.controller;


import org.lorenzo.eserciziolibreria.model.Autore;
import org.lorenzo.eserciziolibreria.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/autori")
public class AutoreController {

    private final AutoreService autoreService;

    @Autowired
    public AutoreController(AutoreService autoreService) {
        this.autoreService = autoreService;
    }

    @GetMapping
    public List<Autore> getAllAutori() {
        return autoreService.getAllAutori();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autore> getAutoreById(@PathVariable UUID id) {
        return ResponseEntity.ok(autoreService.getAutoreById(id));
    }

    @PostMapping
    public ResponseEntity<Autore> createAutore(@RequestBody Autore autore) {
        return ResponseEntity.ok(autoreService.saveAutore(autore));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutore(@PathVariable UUID id) {
        autoreService.deleteAutore(id);
        return ResponseEntity.noContent().build();
    }
}
