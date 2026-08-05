package com.proyectos.BookGestion.service.autor_service;

import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.model.Autor;

public interface AutorService {
        List<Autor> findAllAutor();
        Optional<Autor> findByIdAutor(Long id);
        Autor  saveAutor(Autor autor);
        Autor  updateAutor(Long id, Autor autor);
        void deleteAutor(Long id);
}
