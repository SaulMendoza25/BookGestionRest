package com.proyectos.BookGestion.service.autor_service;

import java.util.List;

import com.proyectos.BookGestion.dto.autor_dto.AutorResponseDTO;
import com.proyectos.BookGestion.dto.autor_dto.AutorSaveDTO;
import com.proyectos.BookGestion.dto.autor_dto.AutorUpdateDTO;

public interface AutorService {
  List<AutorResponseDTO> findAllAutor();

   AutorResponseDTO findById(Long id);

  AutorResponseDTO saveAutor(AutorSaveDTO autorDTO);

  AutorResponseDTO updateAutor(Long id, AutorUpdateDTO autorUpdateDTO);

  void deleteAutor(Long id);

}
