package  com.proyectos.BookGestion.controller.bookcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.BookGestion.model.Libro;
import com.proyectos.BookGestion.service.service_libro.LibroServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/book")
public class BookController{
    private final LibroServiceImpl libroService;


    BookController(LibroServiceImpl libroService) {
        this.libroService = libroService;
    }

        

        @GetMapping("/allBooks")
        public ResponseEntity <List<Libro>> findAllLibro() {
            return ResponseEntity.ok( libroService.findAllLibros());
        }
        @PostMapping("/saveBook")
        public ResponseEntity< Libro> postMethodName(@RequestBody Libro libro) {
            this.libroService.saveLibro(libro);
            return  ResponseEntity.noContent().build();            
        }
        
        

}