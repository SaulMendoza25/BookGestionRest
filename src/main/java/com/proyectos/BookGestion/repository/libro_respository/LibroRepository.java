package com.proyectos.BookGestion.repository.libro_respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectos.BookGestion.model.Libro;

//Aqui va la conexion a libro y la creacion de consultas para pedir datos de los libros
public interface   LibroRepository  extends  JpaRepository<Libro, Long>{
    
}
