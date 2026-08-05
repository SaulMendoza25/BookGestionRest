package com.proyectos.BookGestion.service.usuario_service;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.model.Usuario;

/**
 * UsuarioService
 */
public interface UsuarioService {
    Optional<Usuario> findByIdUsuario(Long id);
    Usuario saveUsuario(Usuario usuario);
    List<Usuario> findAllUsuarios();
    Usuario updateUsuario(Long id, Usuario usuario);
    void deleteUsuario(Long id);

}