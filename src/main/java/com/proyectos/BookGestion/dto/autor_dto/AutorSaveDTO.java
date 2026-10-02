package com.proyectos.BookGestion.dto.autor_dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public record AutorSaveDTO(
       @NotEmpty(message = "El nombre no puede estar vacio") String nombre,
       @NotEmpty(message="La Biografia no puede estar vacia") String biografia,
        LocalDate fechaNacimiento,
        MultipartFile urlFoto

) {
}
