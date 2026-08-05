package com.proyectos.BookGestion.repository.usuario_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectos.BookGestion.model.Usuario;

public interface UsuarioRepository extends  JpaRepository<Usuario, Long> {
    
}
