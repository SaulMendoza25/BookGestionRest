package com.proyectos.BookGestion.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class LibroAutor {
    @ManyToOne
    private Long idLibro;
    @ManyToOne
    private Long idAutor;
    
    private LocalDate fechaParticipacion;
    private Integer porcentajeAutoria;

}
