package com.insalud.app_test.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.UsuarioResponse;
import com.insalud.app_test.servicio.UsuarioServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Usuarios", description = "Gestión de usuarios")
@RequiredArgsConstructor
@RequestMapping("/api/v1/usuarios")
@RestController
public class UsuarioControlador {

    private final UsuarioServicio servicio;

    @Operation(summary = "Listar usuarios", description = "Listar todos los usuarios")
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> obtenerTodosLosUsuarios() {
        return ResponseEntity.ok(servicio.obtenerTodosLosUsuarios());
    }
    
    @Operation(summary = "Registrar usuario", description = "Registrar nuevo usuario")
    @PostMapping
    public ResponseEntity<String> registrarUsuario(@Valid @RequestBody UsuarioRequest request) {
        return  ResponseEntity.ok(servicio.registrarUsuario(request));
    }

    @Operation(summary = "Listar usuario", description = "Listar usuario por ID")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerUsuarioPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.obtenerUsuarioPorId(id));
    }

    @Operation(summary = "Actualizar usuario", description = "Actualizar un usuario por ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarUsuario(@Valid @RequestBody UsuarioRequest request, @PathVariable("id") Integer id) {
        return  ResponseEntity.ok(servicio.actualizarUsuario(id, request));
    }

    @Operation(summary = "Eliminar usuario", description = "Eliminar un usuario por ID")
    @PatchMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable("id") Integer id) {
        return  ResponseEntity.ok(servicio.eliminarUsuario(id));
    }
}
