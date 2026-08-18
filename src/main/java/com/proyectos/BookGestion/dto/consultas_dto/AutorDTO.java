package com.proyectos.BookGestion.dto.consultas_dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
     private String nombre;
    private String biografia;
    private LocalDate fechaNacimiento;
    private String urlFoto;
}
