package com.proyectos.BookGestion.service.autor_service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.model.Autor;
import com.proyectos.BookGestion.repository.autor_repository.AutorRepository;
import com.proyectos.BookGestion.service.tools.ToolsMethodsService;

@Service
public class AutorServiceImpl implements  AutorService {
  
   final AutorRepository autorRepository;

   public AutorServiceImpl(AutorRepository autorRepository){
    this.autorRepository=autorRepository;
   }

    @Override
    public List<Autor> findAllAutor() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> findByIdAutor(Long id) {
       return autorRepository.findById(id);

    }

    @Override
    public Autor saveAutor(Autor autor) {
        // TODO Auto-generated method stub
       return autorRepository.save(autor);
    }

    @Override
    public Autor updateAutor(Long id, Autor autor) {
            if(autorRepository.findById(id).isEmpty()){

            };
            Autor autorCopy = autorRepository.findById(id).get();
            if(!ToolsMethodsService.IsEmptyOrBlankString(autor.getNombre())){
                autorCopy.setNombre(autor.getNombre());
            }
            if(!ToolsMethodsService.IsEmptyOrBlankString(autor.getBiografia())){
                autorCopy.setBiografia(autor.getBiografia());
            }
            if(!ToolsMethodsService.IsEmptyOrBlankString(autor.getUrlFoto())){
                autorCopy.setUrlFoto(autor.getUrlFoto());
            }
            
            return autorRepository.save(autorCopy);        
    }

    @Override
    public void deleteAutor(Long id) {
        if(autorRepository.findById(id).isEmpty()){
        return;
        }
        autorRepository.deleteById(id);
    }
    
}
