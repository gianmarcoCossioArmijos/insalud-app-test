package com.insalud.app_test.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.AutenticacionRequest;
import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.AutenticacionResponse;
import com.insalud.app_test.servicio.AutenticacionServicio;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AutenticacionControlador {

    private final AutenticacionServicio servicio;

    @PostMapping("/login")
    public ResponseEntity<AutenticacionResponse> login(@RequestBody AutenticacionRequest request) {
        return ResponseEntity.ok(new AutenticacionResponse("token"));
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(servicio.registrarUsuario(request));
    }
}
