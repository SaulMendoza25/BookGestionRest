package com.proyectos.BookGestion.repository.relaciones_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectos.BookGestion.model.LibroAutor;

public interface LibroAutorRepository extends JpaRepository<LibroAutor,Long> {
    List<LibroAutor> findByLibroId(Long libroId);
}
