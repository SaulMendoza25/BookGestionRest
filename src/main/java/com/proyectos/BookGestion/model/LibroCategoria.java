package com.proyectos.BookGestion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class LibroCategoria {
    @ManyToOne
    private  Long idLibro;
    @ManyToOne
    private  Long idCategoria;
}
