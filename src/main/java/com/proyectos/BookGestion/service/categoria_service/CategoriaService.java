package com.proyectos.BookGestion.service.categoria_service;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.dto.categoria_dto.CategoriaResponseDTO;
import com.proyectos.BookGestion.dto.categoria_dto.CategoriaSaveDTO;
import com.proyectos.BookGestion.dto.categoria_dto.CategoriaUpdateDTO;
import com.proyectos.BookGestion.model.Categoria;

public interface CategoriaService {
  CategoriaResponseDTO findById(Long id);

  CategoriaResponseDTO saveCategoria(CategoriaSaveDTO categoria);

  List<CategoriaResponseDTO> findAllCategoria();

  CategoriaResponseDTO updateCategoria(Long id, CategoriaUpdateDTO categoria);

  void deleteCategoria(Long id);
}
