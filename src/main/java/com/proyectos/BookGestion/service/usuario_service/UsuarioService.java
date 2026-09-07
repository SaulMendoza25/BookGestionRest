package com.proyectos.BookGestion.service.usuario_service;

//import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import com.proyectos.BookGestion.dto.usuario_dto.UsuarioResponseDTO;
import com.proyectos.BookGestion.dto.usuario_dto.UsuarioSaveDTO;
import com.proyectos.BookGestion.dto.usuario_dto.UsuarioUpdateDTO;
import com.proyectos.BookGestion.model.Usuario;

/**
 * UsuarioService
 */
public interface UsuarioService {
  UsuarioResponseDTO findByIdUsuario(Long id);

  UsuarioResponseDTO saveUsuario(UsuarioSaveDTO usuario);

  List<UsuarioResponseDTO> findAllUsuarios();

  UsuarioResponseDTO updateByIdUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO);

  void deleteIdUsuario(Long id);

}
