package com.proyectos.BookGestion.dto.autor_dto;

import java.time.LocalDate;

public record AutorResponseDTO(

   Long id,
   String nombre,
   LocalDate fechaNacimiento,
   String biografia,
   String urlFoto
) { }
