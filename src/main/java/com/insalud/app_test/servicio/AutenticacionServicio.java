package com.insalud.app_test.servicio;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.AutenticacionRequest;
import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.AutenticacionResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AutenticacionServicio {

    private final UsuarioServicio usuarioServicio;

    public AutenticacionResponse login(AutenticacionRequest request) {
        return new AutenticacionResponse("token");
    }

    public String registrarUsuario(UsuarioRequest request) {
         return usuarioServicio.registrarUsuario(request);
    }
}
