package com.proyectos.BookGestion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroCategoria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private  Libro libro;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private  Categoria categoria;
}
