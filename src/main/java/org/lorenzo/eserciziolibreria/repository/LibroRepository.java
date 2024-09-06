package org.lorenzo.eserciziolibreria.repository;


import org.lorenzo.eserciziolibreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibroRepository extends JpaRepository<Libro, UUID> {
}
