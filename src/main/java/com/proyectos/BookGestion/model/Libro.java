package com.proyectos.BookGestion.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String isbn;
    private String descripcion;
    private LocalDate fechaPublicacion;
    private Integer numeroPaginas;
    private String portada;
    private Enum estado;

    @OneToMany(mappedBy = "libro")
    private List<BibliotecaUsuario> bibliotecaUsuarios;
    @OneToMany(mappedBy = "libro")
    private List<LibroAutor> libroAutores;
    @OneToMany(mappedBy="libro")
    private List<LibroCategoria> libroCategorias;
    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
    @ManyToOne
    @JoinColumn(name="idioma_id")
    private Idioma idioma;

}
