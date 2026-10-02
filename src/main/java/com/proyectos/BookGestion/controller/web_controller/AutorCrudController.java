package  com.proyectos.BookGestion.controller.web_controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectos.BookGestion.dto.autor_dto.AutorSaveDTO;
import com.proyectos.BookGestion.service.autor_service.AutorService;

import jakarta.validation.Valid;

@Controller 
@RequestMapping("/autor")
public class AutorCrudController{
    private final AutorService autorService;

    public AutorCrudController(AutorService autorService){
        this.autorService= autorService;

    }

    @GetMapping("/saveAutor")
    public String saveAutor(@ModelAttribute("autor") AutorSaveDTO autorSaveDTO){
        
        return "autor/saveAutor";
    }

    @PostMapping("/guardado")
    public String savedAutor(@Valid  @ModelAttribute("autor") AutorSaveDTO autorSaveDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "autor/saveAutor";
        }
        autorService.saveAutor(autorSaveDTO);
        return "redirect:/";
    }
}