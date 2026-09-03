package com.proyectos.BookGestion.dto.libro_dto;

import java.time.LocalDate;
import java.util.List;

import com.proyectos.BookGestion.dto.releaciones_dto.libroAutor_dto.LibroAutorSaveDTO;
import com.proyectos.BookGestion.model.enums.Estado;

public record LibroUpdateDTO(
    String titulo,
        String isbn,
        String descripcion,
        LocalDate fechaPublicacion,
        Integer numeroPaginas,
        String portada,
        Estado estado,
        List<LibroAutorSaveDTO> autores

) {
}
