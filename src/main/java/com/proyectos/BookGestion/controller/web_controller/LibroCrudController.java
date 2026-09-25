package com.proyectos.BookGestion.controller.web_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectos.BookGestion.dto.libro_dto.LibroSaveDTO;
import com.proyectos.BookGestion.service.autor_service.AutorService;
import com.proyectos.BookGestion.service.categoria_service.CategoriaService;
@Controller 
@RequestMapping("/libro")
public class LibroCrudController {
    private AutorService autorService;
    private CategoriaService categoriaService;
    public LibroCrudController(AutorService autorService){
        this.autorService=autorService;
    }

    @GetMapping("/formulario")
    public String getFormularioLibro(@ModelAttribute("libro") LibroSaveDTO libroSaveDTO,Model model){
        model.addAttribute("autores", autorService.findAllAutor());
        model.addAttribute("categorias",categoriaService.findAllCategoria());
        return "libros/saveLibro";
    }


}
