package com.proyectos.BookGestion.controller.libro_controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.BookGestion.dto.libro_dto.LibroResponseDTO;
import com.proyectos.BookGestion.dto.libro_dto.LibroSaveDTO;
import com.proyectos.BookGestion.dto.libro_dto.LibroUpdateDTO;
import com.proyectos.BookGestion.model.Libro;
import com.proyectos.BookGestion.service.libro_service.LibroServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v1/libro")
public class LibroController {
    private final LibroServiceImpl libroService;

    public LibroController(LibroServiceImpl libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/findAllLibros")
    public ResponseEntity<List<LibroResponseDTO>> findAllLibro() {
        return ResponseEntity.ok(libroService.findAllLibros());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<LibroResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.findByIdLibro(id));
    }

    @PostMapping("/saveLibro")
    public ResponseEntity<LibroResponseDTO> saveLibro(@RequestBody LibroSaveDTO libroSaveDTO) {
        //TODO: process POST request
        
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.saveLibro(libroSaveDTO));
    }
    
    @PutMapping("/updateLibro/{id}")
    public ResponseEntity<?> updateLibro(@PathVariable Long id, @RequestBody LibroUpdateDTO libroUpdateDTO) {
        //TODO: process PUT request
        
        return ResponseEntity.ok(this.libroService.updateLibro(id, libroUpdateDTO));
    }

  
    @DeleteMapping("/deleteLibro/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.libroService.deleteLibro(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Libro eliminado exitosamente");
    }

}