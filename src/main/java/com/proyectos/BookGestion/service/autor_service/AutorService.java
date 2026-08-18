package com.proyectos.BookGestion.service.autor_service;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.dto.consultas_dto.AutorDTO;
import com.proyectos.BookGestion.model.Autor;

public interface AutorService {
        List<AutorDTO> findAllAutor() throws Exception;
        Optional<Autor> findByIdAutor(Long id);
        Autor  saveAutor(Autor autor);
        Autor  updateAutor(Long id, Autor autor);
        void deleteAutor(Long id);
        Autor findbyAutor(Autor autor);
}
