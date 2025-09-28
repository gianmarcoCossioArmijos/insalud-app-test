package com.insalud.app_test.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.EmpleadoRequest;
import com.insalud.app_test.dto.response.EmpleadoResponse;
import com.insalud.app_test.servicio.EmpleadoServicio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/empleados")
@RestController
public class EmpleadoControlador {

    private final EmpleadoServicio servicio;

    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> obtenerTodosLosEmpleados() {
        return ResponseEntity.ok(servicio.obtenerTodosLosEmpleados());
    }

    @GetMapping("/activo")
    public ResponseEntity<List<EmpleadoResponse>> obtenerEmpleadosActivos() {
        return ResponseEntity.ok(servicio.obtenerEmpleadosActivos());
    }
    
    @PostMapping
    public String registrarPaciente(@Valid @RequestBody EmpleadoRequest request) {
        return servicio.registrarEmpleado(request);
    }
}
