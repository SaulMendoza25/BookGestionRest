package com.proyectos.BookGestion.service.categoria_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.dto.categoria_dto.CategoriaResponseDTO;
import com.proyectos.BookGestion.dto.categoria_dto.CategoriaSaveDTO;
import com.proyectos.BookGestion.dto.categoria_dto.CategoriaUpdateDTO;
import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.error.categoria_error.CategoriaNotFoundException;
import com.proyectos.BookGestion.model.Categoria;
import com.proyectos.BookGestion.repository.categoria_repository.CategoriaRepository;
import com.proyectos.BookGestion.service.tools.ToolsMethodsService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

  private CategoriaRepository categoriaRepository;

  public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
  }

  @Override
  public CategoriaResponseDTO findById(Long id) {
    Categoria categoria = categoriaRepository.findById(id).orElseThrow(()->new CategoriaNotFoundException("No se encontro la cateogria con el id:" + id));
    return mapToCategoriaResponseDTO(categoria);
  }

  @Override
  public CategoriaResponseDTO saveCategoria(CategoriaSaveDTO categoriaSaveDTO) {
    Categoria categoria = mapToCategoriaSave(categoriaSaveDTO);
    Categoria categoriaGuardada = categoriaRepository.save(categoria);
    return mapToCategoriaResponseDTO(categoriaGuardada);

  }

  @Override
  public List<CategoriaResponseDTO> findAllCategoria() {
    List<Categoria> categorias = categoriaRepository.findAll();
    if(categorias.isEmpty()){
      throw new RuntimeException("No se encontro cateogrias");
    }
    List<CategoriaResponseDTO> categoriaResponseDTOs = new ArrayList<>();

    categorias.forEach(data -> categoriaResponseDTOs.add(mapToCategoriaResponseDTO(data)));
    return categoriaResponseDTOs;
  }

  @Override
  public CategoriaResponseDTO updateCategoria(Long id, CategoriaUpdateDTO categoriaUpdateDTO) {
   Categoria categoria = categoriaRepository.findById(id).orElseThrow(()->new CategoriaNotFoundException("No se encontro la categoria con el id: " + id));

    if (!ToolsMethodsService.IsEmptyOrBlankString(categoriaUpdateDTO.nombre())) {
      categoria.setNombre(categoriaUpdateDTO.nombre());
    }
    if (!ToolsMethodsService.IsEmptyOrBlankString(categoriaUpdateDTO.descripcion())) {
      categoria.setDescripcion(categoriaUpdateDTO.descripcion());
    }
    
     Categoria categoriaGuardada = categoriaRepository.save(categoria);
    
    return mapToCategoriaResponseDTO(categoriaGuardada);

  }

  @Override
  public void deleteCategoria(Long id) {
   Categoria categoria = categoriaRepository.findById(id).orElseThrow(()->new CategoriaNotFoundException("No se pudo eliminar la categoria con el id: " +id));
   categoriaRepository.deleteById(categoria.getId());
  }
  //Metodos privados sobre categoria 
  private CategoriaResponseDTO mapToCategoriaResponseDTO(Categoria categoria){
    return new CategoriaResponseDTO(categoria.getId(), categoria.getNombre(), categoria.getDescripcion());
  }
  private Categoria mapToCategoriaSave(CategoriaSaveDTO categoriaSaveDTO){
    Categoria categoria = new Categoria();
    categoria.setNombre(categoriaSaveDTO.nombre());
    categoria.setDescripcion(categoriaSaveDTO.descripcion());
    return categoria; 
  }
}
