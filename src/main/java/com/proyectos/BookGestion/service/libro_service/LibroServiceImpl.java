package com.proyectos.BookGestion.service.libro_service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.model.Libro;
import com.proyectos.BookGestion.repository.libro_respository.LibroRepository;
import com.proyectos.BookGestion.service.tools.ToolsMethodsService;

@Service
public class LibroServiceImpl implements LibroService {
    
    final LibroRepository libroRepository;
    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Optional<Libro> findByIdLibro(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> findAllLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro updateLibro(Long id, Libro libro) {
        Libro libroCopy = libroRepository.findById(id).get();
        if (!ToolsMethodsService.IsEmptyOrBlankString(libro.getTitulo())) {
            libroCopy.setTitulo(libro.getTitulo());
        }
        if (!ToolsMethodsService.IsEmptyOrBlankString(libro.getIsbn())) {
            libroCopy.setIsbn(libro.getIsbn());
        }
        if (!ToolsMethodsService.IsEmptyOrBlankString(libro.getDescripcion())) {
            libroCopy.setDescripcion(libro.getDescripcion());
        }

        if (!ToolsMethodsService.IsEmptyOrBlankString(libro.getPortada())) {
            libroCopy.setPortada(libro.getPortada());
        }
        if (libro.getNumeroPaginas() != 0 || libro.getNumeroPaginas() > 0) {
            libroCopy.setNumeroPaginas(libro.getNumeroPaginas());
        }

        return libroRepository.save(libroCopy);
    }

    @Override
    public void deleteLibro(Long id) {
        if (!libroRepository.findById(id).isEmpty()) {
            libroRepository.deleteById(id);
        }

    }

}
