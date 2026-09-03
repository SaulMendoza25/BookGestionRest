package com.proyectos.BookGestion.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.proyectos.BookGestion.model.enums.Estado;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "libro")
    private List<BibliotecaUsuario> bibliotecaUsuarios= new ArrayList<>();
    @OneToMany(mappedBy = "libro")
    private List<LibroAutor> libroAutores=new ArrayList<>();
    @OneToMany(mappedBy="libro")
    private List<LibroCategoria> libroCategorias= new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;
    @ManyToOne
    @JoinColumn(name="idioma_id")
    private Idioma idioma;

}
