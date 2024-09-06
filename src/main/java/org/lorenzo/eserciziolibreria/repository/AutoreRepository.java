package org.lorenzo.eserciziolibreria.repository;


import org.lorenzo.eserciziolibreria.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutoreRepository extends JpaRepository<Autore, UUID> {
}
