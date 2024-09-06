package org.lorenzo.eserciziolibreria.service;


import org.lorenzo.eserciziolibreria.model.Autore;
import org.lorenzo.eserciziolibreria.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AutoreService {

    private final AutoreRepository autoreRepository;

    @Autowired
    public AutoreService(AutoreRepository autoreRepository) {
        this.autoreRepository = autoreRepository;
    }

    public List<Autore> getAllAutori() {
        return autoreRepository.findAll();
    }

    public Autore getAutoreById(UUID id) {
        return autoreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Autore not found with id " + id));
    }

    public Autore saveAutore(Autore autore) {
        return autoreRepository.save(autore);
    }

    public void deleteAutore(UUID id) {
        if (!autoreRepository.existsById(id)) {
            throw new ResourceNotFoundException("Autore not found with id " + id);
        }
        autoreRepository.deleteById(id);
    }
}
