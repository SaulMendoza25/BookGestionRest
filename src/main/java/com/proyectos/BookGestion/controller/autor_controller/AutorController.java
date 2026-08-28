package com.proyectos.BookGestion.controller.autor_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.BookGestion.model.Autor;
import com.proyectos.BookGestion.service.autor_service.AutorService;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
  private final AutorService autorService;

  public AutorController(AutorService autorService) {
    this.autorService = autorService;
  }

  @GetMapping("/findById/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {

    return ResponseEntity.ok(autorService.findByIdAutor(id));
  }

  @PostMapping("/saveAutor")
  public ResponseEntity<?> saveAutor(@RequestBody Autor autor) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.autorService.saveAutor(autor));

  }

  @PutMapping("/updateAutor/{id}")
  public ResponseEntity<?> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {

    return ResponseEntity.ok(this.autorService.updateAutor(id, autor));
  }

  @DeleteMapping("deleteAutor/{id}")
  public ResponseEntity<?> deleteAutor(@PathVariable Long id) {
    return ResponseEntity.noContent().build();
  }

}
