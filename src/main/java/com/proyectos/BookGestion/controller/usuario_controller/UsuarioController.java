package com.proyectos.BookGestion.controller.usuario_controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.BookGestion.service.usuario_service.UsuarioService;

@RestController 
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable  Long id){
        return ResponseEntity.accepted().build();
    }
}
