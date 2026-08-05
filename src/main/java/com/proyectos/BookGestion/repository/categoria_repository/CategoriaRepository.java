package com.proyectos.BookGestion.repository.categoria_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectos.BookGestion.model.Categoria;

public interface  CategoriaRepository extends  JpaRepository<Categoria, Long>
{

}
