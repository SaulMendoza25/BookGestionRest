package com.proyectos.BookGestion.dto.autor_dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorSaveDTO {
    private String nombre;
    private String biografia;
    private LocalDate fechaNacimiento;
    private String urlFoto;
}
