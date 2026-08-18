package com.proyectos.BookGestion.service.categoria_service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
    public Optional<Categoria> findById(Long id) {
        if (categoriaRepository.findById(id).isEmpty()) {

        }
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria savCategoria(Categoria categoria) {

        return categoriaRepository.save(categoria);

    }

    @Override
    public List<Categoria> findAllCategoria() {
        // TODO Auto-generated method stub
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria categoria) {
        if (categoriaRepository.findById(id).isEmpty()) {

        }
        Categoria categoriaCopy = categoriaRepository.findById(id).get();

        if (!ToolsMethodsService.IsEmptyOrBlankString(categoria.getNombre())) {
            categoriaCopy.setNombre(categoria.getNombre());
        }
        if (!ToolsMethodsService.IsEmptyOrBlankString(categoria.getDescripcion())) {
            categoriaCopy.setDescripcion(categoria.getDescripcion());
        }

        return categoriaCopy;

    }

    @Override
    public void deleteCategoria(Long id) {
        if (categoriaRepository.findById(id).isEmpty()) {
            return;
        }
        categoriaRepository.deleteById(id);
    }

}
