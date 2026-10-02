package com.proyectos.BookGestion.controller.web_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectos.BookGestion.dto.libro_dto.LibroSaveDTO;
import com.proyectos.BookGestion.service.autor_service.AutorService;
import com.proyectos.BookGestion.service.categoria_service.CategoriaService;
import com.proyectos.BookGestion.service.libro_service.LibroService;

import jakarta.validation.Valid;
@Controller 
@RequestMapping("/libro")
public class LibroCrudController {
    private final AutorService autorService;
    private final CategoriaService categoriaService;
    private final LibroService libroService;
    public LibroCrudController(AutorService autorService,CategoriaService categoriaService,LibroService libroService){
        this.categoriaService=categoriaService;
        this.autorService=autorService;
        this.libroService=libroService;
    }

    @GetMapping("/saveLibro")
    public String getFormularioLibro( @ModelAttribute("libro") LibroSaveDTO libroSaveDTO,Model model){

        model.addAttribute("autores", autorService.findAllAutor());
        model.addAttribute("categorias",categoriaService.findAllCategoria());

        return "libro/saveLibro";
    }
    @PostMapping("/guardado")
    public String saveLibro(@Valid @ModelAttribute("libro") LibroSaveDTO libroSaveDTO,BindingResult bindingResult,Model model){
                if(bindingResult.hasErrors()){
            model.addAttribute("autores",autorService.findAllAutor());
            model.addAttribute("categorias",categoriaService.findAllCategoria());

            return "libro/saveLibro";
        }
        libroService.saveLibro(libroSaveDTO);
        return "redirect:/";
    }

}
