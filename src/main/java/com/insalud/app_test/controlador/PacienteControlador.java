package com.insalud.app_test.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.PacienteRequest;
import com.insalud.app_test.dto.response.PacienteResponse;
import com.insalud.app_test.servicio.PacienteServicio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/pacientes")
@RestController
public class PacienteControlador {

    private final PacienteServicio servicio;

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> obtenerTodasLasPersonas() {
        return ResponseEntity.ok(servicio.obtenerTodosLosPacientes());
    }

    @GetMapping("/activo")
    public ResponseEntity<List<PacienteResponse>> obtenerPacientesActivos() {
        return ResponseEntity.ok(servicio.obtenerPacientesActivos());
    }
    
    @PostMapping
    public String registrarPaciente(@Valid @RequestBody PacienteRequest request) {
        return servicio.registrarPaciente(request);
    }
}
