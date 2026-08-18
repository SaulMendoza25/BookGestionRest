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
public class AutorServiceImpl implements  AutorService {
  
   final AutorRepository autorRepository;

   public AutorServiceImpl(AutorRepository autorRepository){
    this.autorRepository=autorRepository;
   }

    @Override
    public List<AutorDTO> findAllAutor()  {
        List<AutorDTO> autoresDTO = new ArrayList<>();
        if(autorRepository.findAll().isEmpty()){
            throw new RuntimeException("No hay autores guardardos");
        }
        for (Autor autor : autorRepository.findAll()) {
            autoresDTO.add(new AutorDTO(autor.getNombre(), autor.getBiografia(), autor.getFechaNacimiento(), autor.getUrlFoto()));
        }
        
        return autoresDTO;
    }

    @Override
    public Optional<Autor> findByIdAutor(Long id) {
        if(autorRepository.findById(id).isEmpty()){
            throw new AutorNotFoundException("Autor no encontrado");
        }
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
                throw new AutorNotFoundException("Autor no encontrado para actualizar");
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

    @Override
    public Autor findbyAutor(Autor autor) {
        // TODO Auto-generated method stub
       return null;
    }
    
}
