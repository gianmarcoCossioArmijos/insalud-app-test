package com.insalud.app_test.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.UsuarioRequest;
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

    @GetMapping
    public String test() {
        log.info("---------- Llego peticion publica ----------");
        return "endpoint publico OK";
    }

    @Operation(summary = "Registrar usuario", description = "Registrar nuevo usuario")
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@Valid @RequestBody UsuarioRequest request) {
        log.info("---------- Llego peticion para registrar usuario ----------");
        log.info("Request encontrado: {}", request);
        return ResponseEntity.ok(usuarioServicio.registrarUsuario(request));
    }
}
