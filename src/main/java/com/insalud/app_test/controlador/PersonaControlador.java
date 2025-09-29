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

import com.insalud.app_test.dto.request.PersonaRequest;
import com.insalud.app_test.dto.response.PersonaResponse;
import com.insalud.app_test.servicio.PersonaServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Personas", description = "Gestión de personas")
@RequiredArgsConstructor
@RequestMapping("/api/v1/personas")
@RestController
public class PersonaControlador {

    private final PersonaServicio servicio;
    
    @Operation(summary = "Listar personas", description = "Listar todas las personas")
    @GetMapping
    public ResponseEntity<List<PersonaResponse>> obtenerTodasLasPersonas() {
        return ResponseEntity.ok(servicio.obtenerTodasLasPersonas());
    }

    @Operation(summary = "Listar personas activas", description = "Listar todas las personas activas")
    @GetMapping("/activo")
    public ResponseEntity<List<PersonaResponse>> obtenerPersonasActivas() {
        return ResponseEntity.ok(servicio.obtenerPersonasActivas());
    }
    
    @Operation(summary = "Registrar persona", description = "Registrar nueva persona")
    @PostMapping
    public  ResponseEntity<String> registrarPersona(@Valid @RequestBody PersonaRequest request) {
        return  ResponseEntity.ok(servicio.registrarPersona(request));
    }

    @Operation(summary = "Listar persona", description = "Listar persona por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PersonaResponse> obtenerPersonaPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.obtenerPersonaPorId(id));
    }

    @Operation(summary = "Actualizar persona", description = "Actualizar una persona por ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarPersona(@Valid @RequestBody PersonaRequest request, @PathVariable("id") Integer id) {
        return  ResponseEntity.ok(servicio.actualizarPersona(id, request));
    }

    @Operation(summary = "Eliminar persona", description = "Eliminar una persona por ID")
    @PatchMapping("/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable("id") Integer id) {
        return  ResponseEntity.ok(servicio.eliminarPersona(id));
    }
}
