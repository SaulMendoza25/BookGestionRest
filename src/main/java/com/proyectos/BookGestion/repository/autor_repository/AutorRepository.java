package com.proyectos.BookGestion.repository.autor_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectos.BookGestion.model.Autor;

public interface  AutorRepository extends  JpaRepository<Autor, Long> {

}
