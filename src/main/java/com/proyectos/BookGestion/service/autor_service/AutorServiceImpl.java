package com.proyectos.BookGestion.service.autor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.dto.consultas_dto.AutorDTO;
import com.proyectos.BookGestion.error.autor_error.AutorNotFoundException;
import com.proyectos.BookGestion.model.Autor;
import com.proyectos.BookGestion.repository.autor_repository.AutorRepository;
import com.proyectos.BookGestion.service.tools.ToolsMethodsService;

@Service
public class AutorServiceImpl implements AutorService {

  final AutorRepository autorRepository;

  public AutorServiceImpl(AutorRepository autorRepository) {
    this.autorRepository = autorRepository;
  }

  @Override
  public List<AutorDTO> findAllAutor() {
    List<AutorDTO> autoresDTO = new ArrayList<>();
    List<Autor> listaAutores = autorRepository.findAll();
    if (listaAutores.isEmpty()) {
      throw new AutorNotFoundException("No hay autores guardardos");
    }
    listaAutores.stream().forEach(
        (data) -> new AutorDTO(data.getNombre(), data.getBiografia(), data.getFechaNacimiento(), data.getUrlFoto()));

    return autoresDTO;
  }

  @Override
  public Optional<AutorDTO> findByIdAutor(Long id) {

    if (autorRepository.findById(id).isEmpty()) {
      throw new AutorNotFoundException("Autor no encontrado");
    }
    Autor autor = autorRepository.findById(id).get();
    AutorDTO autorDTO = new AutorDTO();
    autorDTO.setNombre(autor.getNombre());
    autorDTO.setBiografia(autor.getBiografia());
    autorDTO.setFechaNacimiento(autor.getFechaNacimiento());
    autorDTO.setUrlFoto(autor.getUrlFoto());
    return Optional.of(autorDTO);

  }

  @Override
  public Autor saveAutor(AutorDTO autorDTO) {

    Autor autor = new Autor();
    autor.setNombre(autorDTO.getNombre());
    autor.setFechaNacimiento(autorDTO.getFechaNacimiento());
    autor.setUrlFoto(autorDTO.getUrlFoto());
    autor.setBiografia(autorDTO.getBiografia());
    return autorRepository.save(autor);
  }

  @Override
  public Autor updateAutor(Long id, AutorDTO autorDTO) {
    if (autorRepository.findById(id).isEmpty()) {
      throw new AutorNotFoundException("Autor no encontrado para actualizar");
    }
    ;
    Autor autor = autorRepository.findById(id).get();
    if (!ToolsMethodsService.IsEmptyOrBlankString(autorDTO.getNombre())) {
      autor.setNombre(autor.getNombre());
    }
    if (!ToolsMethodsService.IsEmptyOrBlankString(autorDTO.getBiografia())) {
      autor.setBiografia(autor.getBiografia());
    }
    if (!ToolsMethodsService.IsEmptyOrBlankString(autorDTO.getUrlFoto())) {
      autor.setUrlFoto(autor.getUrlFoto());
    }

    return autorRepository.save(autor);
  }

  @Override
  public void deleteAutor(Long id) {
    if (autorRepository.findById(id).isEmpty()) {
      return;
    }
    autorRepository.deleteById(id);
  }

}
