package com.proyectos.BookGestion.controller.web_controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectos.BookGestion.dto.categoria_dto.CategoriaSaveDTO;
import com.proyectos.BookGestion.service.categoria_service.CategoriaService;

import jakarta.validation.Valid;

@Controller 
@RequestMapping("/categoria")
public class CategoriaCrudController {
    CategoriaService categoriaService;
    public CategoriaCrudController(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }
    @GetMapping("/saveCategoria")
    public String saveCategoria(@ModelAttribute("categoria") CategoriaSaveDTO categoriaSaveDTO){
        return "categoria/saveCategoria";
    }
    @PostMapping("/guardado")
    public String guardadoCategoria(@Valid  @ModelAttribute("categoria") CategoriaSaveDTO categoriaSaveDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/categoria/saveCategoria";
        }
        categoriaService.saveCategoria(categoriaSaveDTO);
        return "redirect:/";
    }
}
