package com.proyectos.BookGestion.service.libro_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.dto.libro_dto.LibroResponseDTO;
import com.proyectos.BookGestion.dto.libro_dto.LibroSaveDTO;
import com.proyectos.BookGestion.dto.libro_dto.LibroUpdateDTO;
import com.proyectos.BookGestion.dto.releaciones_dto.libroAutor_dto.LibroAutorSaveDTO;
import com.proyectos.BookGestion.error.autor_error.AutorNotFoundException;
import com.proyectos.BookGestion.error.libro_error.LibroNotFoundException;
import com.proyectos.BookGestion.model.Autor;
import com.proyectos.BookGestion.model.Libro;
import com.proyectos.BookGestion.model.LibroAutor;
import com.proyectos.BookGestion.repository.autor_repository.AutorRepository;
import com.proyectos.BookGestion.repository.libro_respository.LibroRepository;
import com.proyectos.BookGestion.repository.relaciones_repository.LibroAutorRepository;
import com.proyectos.BookGestion.service.tools.ToolsMethodsService;

import jakarta.transaction.Transactional;

@Service
public class LibroServiceImpl implements LibroService {

    final LibroRepository libroRepository;
    final LibroAutorRepository libroAutorRepository;
    final AutorRepository autorRepository;

    public LibroServiceImpl(LibroRepository libroRepository, LibroAutorRepository libroAutorRepository,
            AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.libroAutorRepository = libroAutorRepository;
        this.autorRepository = autorRepository;
    }

    // Encontrar un libro mediante su ID en caso de no ecnontrar dar una exception
    // de tipo LibroNotFoundException
    @Override
    public LibroResponseDTO findByIdLibro(Long id) {
        Libro libro = libroRepository.findById(id).orElseThrow(() -> new LibroNotFoundException("Libro no encontrado"));
        return mapToResponseDTO(libro);
    }

    // Guardar libro primero pasar los datos de un LibroSaveDTO a libro tambien ver
    // si los id de los autores de los librosSaveDTO existe en el
    // repositorio de autores para luego guardarlos en el repositorio de libroAutor
    @Override
    @Transactional
    public LibroResponseDTO saveLibro(LibroSaveDTO libroSaveDTO) {
        Libro libro = mapToLibroSave(libroSaveDTO);
        Libro libroGuardado = libroRepository.save(libro);
        for (LibroAutorSaveDTO autorDTO : libroSaveDTO.autores()) {
            Autor autor = autorRepository.findById(autorDTO.autorId()).orElseThrow(
                    () -> new AutorNotFoundException("Autor no encontrando con ID: " + autorDTO.autorId()));

            LibroAutor libroAutor = new LibroAutor();
            libroAutor.setLibro(libroGuardado);
            libroAutor.setAutor(autor);
            libroAutor.setFechaParticipacion(autorDTO.fechaParticipacion());
            libroAutor.setPorcentajeAutoria(autorDTO.porcentajeAutoria());
            libroAutorRepository.save(libroAutor);
        }
        return mapToResponseDTO(libroGuardado);
    }

    @Override
    public List<LibroResponseDTO> findAllLibros() {
        List<Libro> libros = libroRepository.findAll();
        if (libros.isEmpty()) {
            throw new RuntimeErrorException(new Error("No se encontro ningun libro"));
        }
        List<LibroResponseDTO> librosDTO = new ArrayList<>();
        libros.forEach((libro) -> librosDTO.add(mapToResponseDTO(libro)));
        return librosDTO;
    }

    @Override
    public LibroResponseDTO updateLibro(Long id, LibroUpdateDTO libroUpdateDTO) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("El libro con el id:" + id + " no encontrado"));
        if (!ToolsMethodsService.IsEmptyOrBlankString(libroUpdateDTO.titulo())) {
            libro.setTitulo(libroUpdateDTO.titulo());
        }
        if (!ToolsMethodsService.IsEmptyOrBlankString(libroUpdateDTO.isbn())) {
            libro.setIsbn(libroUpdateDTO.isbn());
        }
        if (!ToolsMethodsService.IsEmptyOrBlankString(libroUpdateDTO.descripcion())) {
            libro.setDescripcion(libroUpdateDTO.descripcion());
        }
        //
        if (!ToolsMethodsService.IsEmptyOrBlankString(libroUpdateDTO.portada())) {
            libro.setPortada(libroUpdateDTO.portada());
        }
        if (libroUpdateDTO.numeroPaginas() != 0 || libroUpdateDTO.numeroPaginas() > 0) {
            libro.setNumeroPaginas(libroUpdateDTO.numeroPaginas());
        }
        libro.setEstado(libroUpdateDTO.estado());
        if (!libroUpdateDTO.autores().isEmpty()) {
            for (LibroAutorSaveDTO autorDTO : libroUpdateDTO.autores()) {
                Autor autor = autorRepository.findById(autorDTO.autorId()).orElseThrow(
                        () -> new AutorNotFoundException("Autor no encontrando con ID: " + autorDTO.autorId()));

                LibroAutor libroAutor = new LibroAutor();
                libroAutor.setLibro(libro);
                libroAutor.setAutor(autor);
                libroAutor.setFechaParticipacion(autorDTO.fechaParticipacion());
                libroAutor.setPorcentajeAutoria(autorDTO.porcentajeAutoria());
                libroAutorRepository.save(libroAutor);
            }
        }
        Libro libroActualizado = libroRepository.save(libro);
        return mapToResponseDTO(libroActualizado);
    }

    @Override
    public void deleteLibro(Long id) {

        libroRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("No se encontro el libro con el id: " + id));
        libroAutorRepository.deleteById(id);
    }

    // Metodos privados para la logica de negocio de libro

    // Mostrar todo los datos de un libro
    private LibroResponseDTO mapToResponseDTO(Libro libro) {
        List<String> autores = new ArrayList<>();
        for (LibroAutor libroAutor : libroAutorRepository.findByLibroId(libro.getId())) {
            autores.add(libroAutor.getAutor().getNombre());
        }
        return new LibroResponseDTO(libro.getId(), libro.getTitulo(), libro.getIsbn(),
                libro.getDescripcion(), libro.getFechaPublicacion(), libro.getNumeroPaginas(), libro.getPortada(),
                libro.getEstado(), autores);
    }

    private Libro mapToLibroSave(LibroSaveDTO libroSaveDTO) {
        Libro libro = new Libro();
        libro.setTitulo(libroSaveDTO.titulo());
        libro.setIsbn(libroSaveDTO.isbn());
        libro.setDescripcion(libroSaveDTO.descripcion());
        libro.setFechaPublicacion(libroSaveDTO.fechaPublicacion());
        libro.setNumeroPaginas(libroSaveDTO.numeroPaginas());
        libro.setPortada(libroSaveDTO.portada());
        libro.setEstado(libroSaveDTO.estado());

        return libro;
    }

}
