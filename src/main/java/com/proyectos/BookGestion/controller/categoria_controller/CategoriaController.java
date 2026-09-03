package com.proyectos.BookGestion.controller.categoria_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyectos.BookGestion.dto.categoria_dto.CategoriaSaveDTO;
import com.proyectos.BookGestion.dto.categoria_dto.CategoriaUpdateDTO;
import com.proyectos.BookGestion.model.Categoria;
import com.proyectos.BookGestion.service.categoria_service.CategoriaService;



@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }

    @GetMapping("/allCategorias")
    public ResponseEntity<?> findAllCategorias() {
        return ResponseEntity.ok(categoriaService.findAllCategoria());
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findById(id));
    }
    @PostMapping("/saveCategoria")
    public ResponseEntity<?> saveCategoria(@RequestBody CategoriaSaveDTO categoriaSaveDTO) {
        //TODO: process POST request      
        return ResponseEntity.ok(categoriaService.saveCategoria(categoriaSaveDTO));
    }
    @PutMapping("/updateCategoria/{id}")
    public ResponseEntity<?> updateCategoria(@PathVariable Long id,@RequestBody CategoriaUpdateDTO categoriaUpdateDTO){
        return ResponseEntity.ok(categoriaService.updateCategoria(id, categoriaUpdateDTO));
    }
     @DeleteMapping("/deleteCategoria/{id}")
     public ResponseEntity<?> deleteCategoria(@PathVariable Long id){
        categoriaService.deleteCategoria(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Categoria eliminada");
     }
    } 