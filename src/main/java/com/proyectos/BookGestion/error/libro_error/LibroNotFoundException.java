package com.proyectos.BookGestion.error.libro_error;

public class LibroNotFoundException extends RuntimeException {

    public LibroNotFoundException(String message) {
        super(message);
    }
    
}
