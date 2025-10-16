package com.insalud.app_test.servicio;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.AutenticacionMapper;
import com.insalud.app_test.dto.request.AutenticacionRequest;
import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.AutenticacionResponse;
import com.insalud.app_test.seguridad.JwtServicio;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class AutenticacionServicio {

    private final UsuarioServicio usuarioServicio;
    private final AutenticacionMapper mapper;
    private final AuthenticationManager auth;

    public AutenticacionResponse login(AutenticacionRequest request) {
        log.info("LOGIN INFO: llegada de request a servicio {}", request);
        auth.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        String token = JwtServicio.generateToken(request.username());
        log.info("LOGIN INFO: token generado {}", token);
        return mapper.autenticacionRespuesta(token);
    }

    public String registrarUsuario(UsuarioRequest request) {
        return usuarioServicio.registrarUsuario(request);
    }
}
