package com.proyectos.BookGestion.controller.usuario_controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.BookGestion.dto.usuario_dto.UsuarioResponseDTO;
import com.proyectos.BookGestion.dto.usuario_dto.UsuarioSaveDTO;
import com.proyectos.BookGestion.dto.usuario_dto.UsuarioUpdateDTO;
import com.proyectos.BookGestion.service.usuario_service.UsuarioService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findByIdUsuario(@PathVariable Long id) {
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/findAllUsuario")
    public ResponseEntity<List<UsuarioResponseDTO>> findAllUsuario() {
        return ResponseEntity.ok(usuarioService.findAllUsuarios());
    }

    @PostMapping("/saveUsuario")
    public ResponseEntity<UsuarioResponseDTO> saveUsuario(@RequestBody UsuarioSaveDTO usuarioSaveDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(usuarioSaveDTO));
    }

    @PutMapping("/updateUsuario/{id}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@PathVariable Long id,
            @RequestBody UsuarioUpdateDTO usuarioUpdateDTO) {
        // TODO: process PUT request
        return ResponseEntity.ok(usuarioService.updateByIdUsuario(id, usuarioUpdateDTO));
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteIdUsuario(id);
        return ResponseEntity.noContent().build();
        
    }

}
