package com.proyectos.BookGestion.service.autor_service;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.dto.autor_dto.AutorResponseDTO;
import com.proyectos.BookGestion.dto.autor_dto.AutorSaveDTO;
import com.proyectos.BookGestion.dto.autor_dto.AutorUpdateDTO;
import com.proyectos.BookGestion.model.Autor;

public interface AutorService {
  List<AutorResponseDTO> findAllAutor() throws Exception;

   AutorResponseDTO findById(Long id);

  AutorResponseDTO saveAutor(AutorSaveDTO autorDTO);

  AutorResponseDTO updateAutor(Long id, AutorUpdateDTO autorUpdateDTO);

  void deleteAutor(Long id);

}
