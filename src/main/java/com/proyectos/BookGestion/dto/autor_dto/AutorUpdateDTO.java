package com.proyectos.BookGestion.dto.autor_dto;

import java.time.LocalDate;

public record AutorUpdateDTO(
        String nombre,
        String biografia,
        LocalDate fechaNacimiento,
        String urlFoto) {

}
