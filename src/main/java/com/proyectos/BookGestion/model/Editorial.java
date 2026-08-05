package com.proyectos.BookGestion.model;

import java.util.List;

import com.proyectos.BookGestion.model.enums.Pais;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Pais pais;
    private String sitioWeb;
    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;
}
