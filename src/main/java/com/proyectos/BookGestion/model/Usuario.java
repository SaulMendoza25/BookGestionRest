package com.proyectos.BookGestion.model;

import java.time.LocalDate;
import java.util.List;

import com.proyectos.BookGestion.model.enums.EstadoUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private LocalDate fechaRegistro;
    @Enumerated (EnumType.STRING)
    private EstadoUsuario estado;
    private Plan plan;
    @OneToMany(mappedBy = "usuario")
    private List<BibliotecaUsuario> bibliotecaUsuarios;
    
}
