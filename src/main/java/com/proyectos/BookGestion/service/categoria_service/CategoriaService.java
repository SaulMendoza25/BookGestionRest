package com.proyectos.BookGestion.service.categoria_service;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.model.Categoria;

public interface CategoriaService {
  Optional<Categoria> findById(Long id);

  Categoria saveCategoria(Categoria categoria);

  List<Categoria> findAllCategoria();

  Categoria updateCategoria(Long id, Categoria categoria);

  void deleteCategoria(Long id);
}
