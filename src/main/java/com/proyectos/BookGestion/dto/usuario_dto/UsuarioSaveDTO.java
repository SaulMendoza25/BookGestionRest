package com.proyectos.BookGestion.dto.usuario_dto;

import java.time.LocalDate;

import com.proyectos.BookGestion.model.Plan;
import com.proyectos.BookGestion.model.enums.EstadoUsuario;

public record UsuarioSaveDTO(

        String nombre,
        String apellido,
        String correo,
        LocalDate fechaRegistro,
        EstadoUsuario estado,
        Plan plan
    ) {

}
