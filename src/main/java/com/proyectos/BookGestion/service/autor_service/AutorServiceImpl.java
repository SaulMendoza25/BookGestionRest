package com.proyectos.BookGestion.service.autor_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.dto.autor_dto.AutorResponseDTO;
import com.proyectos.BookGestion.dto.autor_dto.AutorSaveDTO;
import com.proyectos.BookGestion.dto.autor_dto.AutorUpdateDTO;
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
  public List<AutorResponseDTO> findAllAutor() {
    List<AutorResponseDTO> autoresResponseDTOs = new ArrayList<>();
    List<Autor> listaAutores = autorRepository.findAll();
    if (listaAutores.isEmpty()) {
      throw new AutorNotFoundException("No hay autores guardardos");
    }
    listaAutores.stream().forEach(
        (data) -> autoresResponseDTOs.add(mapToAutorResponseDTO(data)));

    return autoresResponseDTOs;
  }

  @Override
  public AutorResponseDTO findById(Long id) {
    Autor autor = autorRepository.findById(id)
        .orElseThrow(() -> new AutorNotFoundException("No se encontro el autor con el id: " + id));

    return mapToAutorResponseDTO(autor);

  }

  @Override
  public AutorResponseDTO saveAutor(AutorSaveDTO autorSaveDTO) {

    Autor autor = mapToAutorSave(autorSaveDTO);
    Autor autorGuardado = autorRepository.save(autor);
    return mapToAutorResponseDTO(autorGuardado);
  }

  @Override
  public AutorResponseDTO updateAutor(Long id, AutorUpdateDTO autorUpdateDTO) {

    
    Autor autor = autorRepository.findById(id).orElseThrow(()->new AutorNotFoundException("El autor para actualizar con el id:" + id+" no fuen encontrado"));
    if (!ToolsMethodsService.IsEmptyOrBlankString(autorUpdateDTO.nombre())) {
      autor.setNombre(autorUpdateDTO.nombre());
    }
    if (!ToolsMethodsService.IsEmptyOrBlankString(autorUpdateDTO.biografia())) {
      autor.setBiografia(autorUpdateDTO.biografia());
    }
    if (!ToolsMethodsService.IsEmptyOrBlankString(autorUpdateDTO.urlFoto())) {
      autor.setUrlFoto(autorUpdateDTO.urlFoto());
    }
    Autor autorGuardado = autorRepository.save(autor);
    return mapToAutorResponseDTO(autorGuardado);
  }

  @Override
  public void deleteAutor(Long id) {
    autorRepository.findById(id).orElseThrow(()->new AutorNotFoundException("No se encontro el id: " + id + " del autor a eliminar"));
    autorRepository.deleteById(id);
  }
  // Metodos para convertir DTOS

  // Metodo para convertir un DTO en una entidad autor
  private Autor mapToAutorSave(AutorSaveDTO autorSaveDTO) {
    Autor autor = new Autor();
    autor.setNombre(autorSaveDTO.nombre());
    autor.setUrlFoto(autorSaveDTO.urlFoto().getOriginalFilename());
    autor.setFechaNacimiento(autorSaveDTO.fechaNacimiento());
    autor.setBiografia(autorSaveDTO.biografia());
    return autor;
  }

  // Metodo para convertir datos de Autor a un autorResponseDTO
  private AutorResponseDTO mapToAutorResponseDTO(Autor autor) {
    return new AutorResponseDTO(autor.getId(), autor.getNombre(), autor.getFechaNacimiento(), autor.getBiografia(),
        autor.getUrlFoto());
  }

}
