package com.proyectos.BookGestion.dto.categoria_dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaSaveDTO(
                @NotBlank(message = "El nombre no puede estar vacio") String nombre,
                @NotBlank(message = "La descripcion no puede estar vacia") String descripcion) {
}
