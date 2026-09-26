package com.proyectos.BookGestion.dto.autor_dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public record AutorSaveDTO(
        String nombre,
        String biografia,
        LocalDate fechaNacimiento,
        MultipartFile urlFoto

) {
}
