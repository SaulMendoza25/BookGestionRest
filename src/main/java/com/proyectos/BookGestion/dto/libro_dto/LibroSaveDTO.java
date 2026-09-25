package com.proyectos.BookGestion.dto.libro_dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.proyectos.BookGestion.dto.categoria_dto.CategoriaSaveDTO;
import com.proyectos.BookGestion.dto.releaciones_dto.libroAutor_dto.LibroAutorSaveDTO;
import com.proyectos.BookGestion.dto.releaciones_dto.libroCategoria_dto.LibroCategoriaSaveDTO;
import com.proyectos.BookGestion.model.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record LibroSaveDTO(
        String titulo,
        String isbn,
        String descripcion,
        LocalDate fechaPublicacion,
        Integer numeroPaginas,
        MultipartFile portada,
        Estado estado,
        List<Long> autores,
        List<Long> categorias
    ) {
}
