package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.UsuarioMapper;
import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.UsuarioResponse;
import com.insalud.app_test.repositorio.PersonaRepositorio;
import com.insalud.app_test.repositorio.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServicio {

    private final UsuarioRepositorio repositorio;
    private final PersonaRepositorio personaRepositorio;
    private final UsuarioMapper mapper;

    public List<UsuarioResponse> obtenerTodosLosUsuarios() {
        return repositorio.findAll()
                .stream()
                .map(mapper::aUsuarioRespuesta)
                .toList();
    }

    public String registrarUsuario(UsuarioRequest request) {
        var usuario = mapper.aUsuarioEntidad(request);
        return String.format("Usuario con ID %s registrado exitosamente",repositorio.save(usuario).getId_usuario());
    }

    public UsuarioResponse obtenerUsuarioPorId(Integer id) {
        var usuario = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Usuario con ID %s no encontrado", id)));
        return mapper.aUsuarioRespuesta(usuario);
    }

    public String actualizarUsuario(Integer id, UsuarioRequest request) {
        var usuario = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Usuario con ID %s no encontrado", id)));
        usuario.setUsuario(request.usuario());
        usuario.setContraseña(request.contraseña());
        var persona = personaRepositorio.findById(request.id_persona())
                .orElseThrow(() -> new RuntimeException(String.format("Usuario con ID de persona %s no encontrada", request.id_persona())));
        usuario.setPersona(persona);
        repositorio.save(usuario);
        return String.format("Usuario con ID %s actualizado exitosamente", id);
    }

    public String eliminarUsuario(Integer id) {
        var usuario = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Usuario con ID %s no encontrado", id)));
        repositorio.delete(usuario);
        return String.format("Usuario con ID %s eliminado exitosamente", id);
    }
}
