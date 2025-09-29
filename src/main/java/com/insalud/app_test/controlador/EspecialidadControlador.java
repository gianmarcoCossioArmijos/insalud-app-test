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

import com.insalud.app_test.dto.request.EspecialidadRequest;
import com.insalud.app_test.dto.response.EspecialidadResponse;
import com.insalud.app_test.servicio.EspecialidadServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Especialidades", description = "Gestion de especialidades")
@RequiredArgsConstructor
@RequestMapping("/api/v1/especialidades")
@RestController
public class EspecialidadControlador {

    private final EspecialidadServicio servicio;

    @Operation(summary = "Listar especialidades", description = "Listar todas las especialidades")
    @GetMapping
    public ResponseEntity<List<EspecialidadResponse>> obtenerTodasLasEspecialidades() {
        return ResponseEntity.ok(servicio.obtenerTodasLasEspecialidades());
    }

    @Operation(summary = "Listar especialidades activas", description = "Listar todas las especialidades activas")
    @GetMapping("/activo")
    public ResponseEntity<List<EspecialidadResponse>> obtenerEspecialidadesActivas() {
        return ResponseEntity.ok(servicio.obtenerEspecialidadesActivas());
    }
    
    @Operation(summary = "Registrar especialidad", description = "Registrar nueva especialidad")
    @PostMapping
    public ResponseEntity<String> registrarEspecialidad(@Valid @RequestBody EspecialidadRequest request) {
        return ResponseEntity.ok(servicio.registrarEspecialidad(request));
    }

    @Operation(summary = "Listar especialidad", description = "Listar especialidad por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EspecialidadResponse> obtenerEspecialidadPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.obtenerEspecialidadPorId(id));
    }

    @Operation(summary = "Actualizar especialidad", description = "Actualizar especialidad por ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEspecialidad(@Valid @RequestBody EspecialidadRequest request, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.actualizarEspecialidad(id, request));
    }

    @Operation(summary = "Eliminar especialidad", description = "Eliminar especialidad por ID")
    @PatchMapping("/{id}")
    public ResponseEntity<String> eliminarEspecialidad(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.eliminarEspecialidad(id));
    }
}
