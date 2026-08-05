package com.proyectos.BookGestion.service.usuario_service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.Tool;

import com.proyectos.BookGestion.model.Usuario;
import com.proyectos.BookGestion.repository.usuario_repository.UsuarioRepository;
import com.proyectos.BookGestion.service.tools.ToolsMethodsService;

public class UsuarioServiceImpl implements UsuarioService{

    UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository= usuarioRepository;
    }

    @Override
    public Optional<Usuario> findByIdUsuario(Long id) {
        if(usuarioRepository.findById(id).isEmpty()){

        }
        return usuarioRepository.findById(id);
        
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        

        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        // TODO Auto-generated method stub
        if(usuarioRepository.findById(id).isEmpty()){

        }
        Usuario usuarioCopy = usuarioRepository.findById(id).get();

        if(!ToolsMethodsService.IsEmptyOrBlankString(usuario.getNombre())){
            usuarioCopy.setNombre(usuario.getNombre());
        }
        if(!ToolsMethodsService.IsEmptyOrBlankString(usuario.getApellido())){
            usuarioCopy.setApellido(usuario.getApellido());
        }
        if(!ToolsMethodsService.IsEmptyOrBlankString(usuario.getCorreo())){
            usuarioCopy.setCorreo(usuario.getCorreo());
        }
        if(!ToolsMethodsService.IsEmptyOrBlankString(usuario.getPassword())){
            usuarioCopy.setPassword(usuario.getPassword());
        }


        return usuarioCopy;
    }

    @Override
    public void deleteUsuario(Long id) {
        if(usuarioRepository.findById(id).isEmpty()){
            return;
        }
        usuarioRepository.deleteById(id);

    }
    
}
