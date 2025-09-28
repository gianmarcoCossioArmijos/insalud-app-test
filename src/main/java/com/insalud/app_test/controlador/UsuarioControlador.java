package com.insalud.app_test.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.UsuarioResponse;
import com.insalud.app_test.servicio.UsuarioServicio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/usuarios")
@RestController
public class UsuarioControlador {

    private final UsuarioServicio servicio;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> obtenerTodasLasPersonas() {
        return ResponseEntity.ok(servicio.obtenerTodosLosUsuarios());
    }
    
    @PostMapping
    public String registrarUsuario(@Valid @RequestBody UsuarioRequest request) {
        return servicio.registrarUsuario(request);
    }
}
