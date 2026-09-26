package com.proyectos.BookGestion.dto.libro_dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.proyectos.BookGestion.model.enums.Estado;

public record LibroSaveDTO(
        String titulo,
        String isbn,
        String descripcion,
        LocalDate fechaPublicacion,
        Integer numeroPaginas,
        MultipartFile portada,
        Estado estado,
        List<Long> autores,
        List<Long> categorias
    ) {
}
