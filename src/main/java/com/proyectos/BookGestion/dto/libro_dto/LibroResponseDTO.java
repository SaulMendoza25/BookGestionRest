package com.proyectos.BookGestion.dto.libro_dto;

import java.time.LocalDate;
import java.util.List;

import com.proyectos.BookGestion.dto.autor_dto.AutorResponseDTO;
import com.proyectos.BookGestion.dto.releaciones_dto.libroCategoria_dto.LibroCategoriaResponseDTO;
import com.proyectos.BookGestion.model.BibliotecaUsuario;
import com.proyectos.BookGestion.model.Categoria;
import com.proyectos.BookGestion.model.Editorial;
import com.proyectos.BookGestion.model.Idioma;
import com.proyectos.BookGestion.model.LibroAutor;
import com.proyectos.BookGestion.model.LibroCategoria;
import com.proyectos.BookGestion.model.enums.Estado;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public record LibroResponseDTO(
        Long id,
        String titulo,
        String isbn,
        String descripcion,
        LocalDate fechaPublicacion,
        Integer numeroPaginas,
        String portada,
        Estado estado,
        List<String> autores,
        List<LibroCategoriaResponseDTO> categorias
   ) {

}
