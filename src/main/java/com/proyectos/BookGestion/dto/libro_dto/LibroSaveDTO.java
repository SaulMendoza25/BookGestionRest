package com.proyectos.BookGestion.dto.libro_dto;

import java.time.LocalDate;

import com.proyectos.BookGestion.model.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroSaveDTO {
    private String titulo;
    private String isbn;
    private String descripcion;
    private LocalDate fechaPublicacion;
    private Integer numeroPaginas;
    private String portada;
    private Estado estado;
    
}
