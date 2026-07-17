package com.proyectos.BookGestion.service.service_libro;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.model.Libro;
import com.proyectos.BookGestion.repository.repository_libro.LibroRepository;
@Service
public class LibroServiceImpl implements LibroService {

    final LibroRepository libroRepository;

    LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Optional<Libro> findById(Long id) {
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
    
}
