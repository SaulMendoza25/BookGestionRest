package com.proyectos.BookGestion.dto.consultas_dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatosLibroDTO {
    private String titulo_libro;
    private String isbn_libro;
    private String descripcion_libro;
    private LocalDate fechaPublicacion_libro;
    private Integer numeroPaginas_libro;
    private String portada_libro;
    private String nombre_autor;
    private String biografia_autor;
    private String urlFoto;
    
}
