package com.insalud.app_test.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.PacienteRequest;
import com.insalud.app_test.dto.response.PacienteResponse;
import com.insalud.app_test.servicio.PacienteServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pacientes", description = "Gestion de pacientes")
@RequiredArgsConstructor
@RequestMapping("api/v1/pacientes")
@RestController
public class PacienteControlador {

    private final PacienteServicio servicio;

    @PreAuthorize("hasAnyAuthority('ADMIN','INVITADO')")
    @Operation(summary = "Listar pacientes", description = "Listar todos los pacientes")
    @GetMapping
    public ResponseEntity<List<PacienteResponse>> obtenerTodasLasPersonas() {
        return ResponseEntity.ok(servicio.obtenerTodosLosPacientes());
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Registrar paciente", description = "Registrar nuevo paciente")
    @PostMapping
    public ResponseEntity<String> registrarPaciente(@Valid @RequestBody PacienteRequest request) {
        return ResponseEntity.ok(servicio.registrarPaciente(request));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'PACIENTE','MEDICO','INVITADO')")
    @Operation(summary = "Listar paciente", description = "Listar paciente por ID")
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> obtenerPacientePorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.obtenerPacientePorId(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Actualizar paciente", description = "Actualizar paciente por ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarPaciente(@Valid @RequestBody PacienteRequest request, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.actualizarPaciente(id, request));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Eliminar paciente", description = "Eliminar paciente por ID")
    @PatchMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.eliminarPaciente(id));
    }
}
