package com.proyectos.BookGestion.service.libro_service;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.dto.libro_dto.LibroResponseDTO;
import com.proyectos.BookGestion.dto.libro_dto.LibroSaveDTO;
import com.proyectos.BookGestion.dto.libro_dto.LibroUpdateDTO;
import com.proyectos.BookGestion.model.Libro;

public interface LibroService {
    LibroResponseDTO findByIdLibro(Long id);
    LibroResponseDTO saveLibro(LibroSaveDTO libro);
    List<LibroResponseDTO> findAllLibros();
    LibroResponseDTO updateLibro(Long id,LibroUpdateDTO libro);
    void deleteLibro(Long id);
}
