package com.proyectos.BookGestion.service.service_libro;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.model.Libro;

public interface LibroService {
    Optional<Libro> findById(Long id);
    Libro saveLibro(Libro libro);
    List<Libro> findAllLibros();
}
