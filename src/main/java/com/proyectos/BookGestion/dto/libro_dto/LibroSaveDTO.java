package com.proyectos.BookGestion.dto.libro_dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.proyectos.BookGestion.model.enums.Estado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public record LibroSaveDTO(

                @NotBlank(message = "El título no puede estar vacío") String titulo,

                @NotBlank(message = "El ISBN no puede estar vacío") String isbn,

                @NotBlank(message = "La descripción no puede estar vacía") String descripcion,

                @DateTimeFormat(pattern = "yyyy-MM-dd") @NotNull(message = "La fecha es obligatoria") @PastOrPresent(message = "La fecha no puede ser futura") LocalDate fechaPublicacion,

                @NotNull(message = "El número de páginas es obligatorio") @Positive(message = "Debe tener al menos una página") Integer numeroPaginas,

                MultipartFile portada,

                @NotNull(message = "Debe seleccionar un estado") Estado estado,

                @NotEmpty(message = "Debe seleccionar al menos un autor") List<Long> autores,

                @NotEmpty(message = "Debe seleccionar al menos una categoría") List<Long> categorias

) {
}