package com.proyectos.BookGestion.service.usuario_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.Tool;
import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.dto.usuario_dto.UsuarioResponseDTO;
import com.proyectos.BookGestion.dto.usuario_dto.UsuarioSaveDTO;
import com.proyectos.BookGestion.dto.usuario_dto.UsuarioUpdateDTO;
import com.proyectos.BookGestion.error.usuario_error.UsuarioNotFoundException;
import com.proyectos.BookGestion.model.Usuario;
import com.proyectos.BookGestion.repository.plan_repository.PlanRepository;
import com.proyectos.BookGestion.repository.usuario_repository.UsuarioRepository;
import com.proyectos.BookGestion.service.tools.ToolsMethodsService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PlanRepository planRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PlanRepository planRepository) {
        this.usuarioRepository = usuarioRepository;
        this.planRepository = planRepository;
    }

    @Override
    public UsuarioResponseDTO findByIdUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado"));
        return mapToUsuarioResponse(usuario);
    }

    @Override
    public UsuarioResponseDTO saveUsuario(UsuarioSaveDTO usuarioSaveDTO) {
        Usuario usuario = mapToUsuarioSave(usuarioSaveDTO);
        Usuario usuarioGuardado = this.usuarioRepository.save(usuario);
        return mapToUsuarioResponse(usuarioGuardado);
    }

    @Override
    public List<UsuarioResponseDTO> findAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new RuntimeException("No hay usuario guardados");
        }
        List<UsuarioResponseDTO> usuarioResponseDTOs = new ArrayList<>();
        usuarios.forEach(data -> usuarioResponseDTOs.add(new UsuarioResponseDTO(data.getId(), data.getNombre(),
                data.getApellido(), data.getCorreo(), data.getFechaRegistro(), data.getEstado(), data.getPlan())));
        return usuarioResponseDTOs;
    }

    @Override
    public UsuarioResponseDTO updateByIdUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) {
        // TODO Auto-generated method stub
        
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new UsuarioNotFoundException("Usuario no encontrado"));

        if (!ToolsMethodsService.IsEmptyOrBlankString(usuarioUpdateDTO.nombre())) {
            usuario.setNombre(usuario.getNombre());
        }
        if (!ToolsMethodsService.IsEmptyOrBlankString(usuarioUpdateDTO.apellido())) {
            usuario.setApellido(usuario.getApellido());
        }
        if (!ToolsMethodsService.IsEmptyOrBlankString(usuarioUpdateDTO.correo())) {
            usuario.setCorreo(usuario.getCorreo());
        }
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        return mapToUsuarioResponse(usuarioGuardado);
    }

    @Override
    public void deleteIdUsuario(Long id) {
        if (usuarioRepository.findById(id).isEmpty()) {
            return;
        }
        usuarioRepository.deleteById(id);

    }

    // Metodos privados de Usuario service
    private UsuarioResponseDTO mapToUsuarioResponse(Usuario usuario) {

        return new UsuarioResponseDTO(usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(),
                usuario.getFechaRegistro(), usuario.getEstado(), usuario.getPlan());
    }

    private Usuario mapToUsuarioSave(UsuarioSaveDTO usuarioSaveDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioSaveDTO.nombre());
        usuario.setApellido(usuarioSaveDTO.apellido());
        usuario.setCorreo(usuarioSaveDTO.correo());
        usuario.setFechaRegistro(usuarioSaveDTO.fechaRegistro());
        usuario.setEstado(usuarioSaveDTO.estado());
        usuario.setPlan(usuarioSaveDTO.plan());
        return usuario;
    }

}
