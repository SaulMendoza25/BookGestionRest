package com.proyectos.BookGestion.controller.rest_controller.autor_controller;

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

import com.proyectos.BookGestion.dto.autor_dto.AutorResponseDTO;
import com.proyectos.BookGestion.dto.autor_dto.AutorSaveDTO;
import com.proyectos.BookGestion.dto.autor_dto.AutorUpdateDTO;
import com.proyectos.BookGestion.service.autor_service.AutorService;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {
  private final AutorService autorService;

  public AutorController(AutorService autorService) {
    this.autorService = autorService;
  }
  

  @GetMapping("/findById/{id}")
  public ResponseEntity<AutorResponseDTO> findById(@PathVariable Long id) {

    return ResponseEntity.ok(autorService.findById(id));
  }

  @PostMapping("/saveAutor")
  public ResponseEntity<AutorResponseDTO> saveAutor(@RequestBody AutorSaveDTO autorSaveDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.autorService.saveAutor(autorSaveDTO));
  }
  @PutMapping("/updateAutor/{id}")
  public ResponseEntity<AutorResponseDTO> updateAutor(@PathVariable Long id, @RequestBody AutorUpdateDTO autorUpdateDTO) {

    return ResponseEntity.ok(this.autorService.updateAutor(id, autorUpdateDTO));
  }

  @DeleteMapping("deleteAutor/{id}")
  public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
    autorService.deleteAutor(id);
    return ResponseEntity.noContent().build();
  }

}
