package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.UsuarioMapper;
import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.UsuarioResponse;
import com.insalud.app_test.repositorio.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServicio {

    private final UsuarioRepositorio repositorio;
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
}
