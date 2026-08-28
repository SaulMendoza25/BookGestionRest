package com.proyectos.BookGestion.service.autor_service;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.dto.consultas_dto.AutorDTO;
import com.proyectos.BookGestion.model.Autor;

public interface AutorService {
  List<AutorDTO> findAllAutor() throws Exception;

  Optional<AutorDTO> findByIdAutor(Long id);

  Autor saveAutor(AutorDTO autorDTO);

  Autor updateAutor(Long id, AutorDTO autorDTO);

  void deleteAutor(Long id);

}
