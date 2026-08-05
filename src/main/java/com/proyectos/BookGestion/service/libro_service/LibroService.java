package com.proyectos.BookGestion.service.libro_service;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.model.Libro;

public interface LibroService {
    Optional<Libro> findByIdLibro(Long id);
    Libro saveLibro(Libro libro);
    List<Libro> findAllLibros();
    Libro updateLibro(Long id,Libro libro);
    void deleteLibro(Long id);
}
