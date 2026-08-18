package com.proyectos.BookGestion.controller.categoria_controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.BookGestion.model.Categoria;
import com.proyectos.BookGestion.service.categoria_service.CategoriaService;



@RestController
public class CategoriaController {
    private final CategoriaService categoriaService;
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }

    @GetMapping("/allCategorias")
    public ResponseEntity<?> findAllCategorias(@RequestParam String param) {
        return ResponseEntity.ok(categoriaService.findAllCategoria());
    }

    @PostMapping("/saveCategorias")
    public ResponseEntity<?> saveCategoria(@RequestBody Categoria categoria) {
        //TODO: process POST request      
        return ResponseEntity.ok(categoria);
    }
    
    

}
