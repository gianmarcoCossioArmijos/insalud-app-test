package com.insalud.app_test.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.AutenticacionRequest;
import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.AutenticacionResponse;
import com.insalud.app_test.servicio.AutenticacionServicio;
import com.insalud.app_test.servicio.UsuarioServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Tag(name = "Autenticacion", description = "Autenticacion de usuarios")
@RequiredArgsConstructor
@RequestMapping("/api/v1/autenticacion")
@RestController
public class AutenticacionControlador {

    private final UsuarioServicio usuarioServicio;
    private final AutenticacionServicio servicio;

    @Operation(summary = "Iniciar sesion", description = "Iniciar sesion con usuario")
    @PostMapping("/login")
    public ResponseEntity<AutenticacionResponse> login(@Valid @RequestBody AutenticacionRequest request) {
        log.info("LOGIN INFO: llegada de request a controlador {}", request);
        return ResponseEntity.ok(servicio.login(request));
    }

    @Operation(summary = "Registrar usuario", description = "Registrar nuevo usuario")
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@Valid @RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(usuarioServicio.registrarUsuario(request));
    }
}
