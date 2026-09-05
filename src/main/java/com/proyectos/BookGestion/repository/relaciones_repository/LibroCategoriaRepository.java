package com.proyectos.BookGestion.repository.relaciones_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectos.BookGestion.model.LibroCategoria;

public interface LibroCategoriaRepository extends JpaRepository<LibroCategoria,Long> {

    List<LibroCategoria> findByLibroId(Long id);
} 
