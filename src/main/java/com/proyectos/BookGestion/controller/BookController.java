package  com.proyectos.BookGestion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/book")
public class BookController{

        @GetMapping("/allBooks")
        public String getMethodName(@RequestParam String param) {
            return new String();
        }
        

}