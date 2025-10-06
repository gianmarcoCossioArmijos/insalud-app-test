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

import com.insalud.app_test.dto.request.EmpleadoRequest;
import com.insalud.app_test.dto.response.EmpleadoResponse;
import com.insalud.app_test.servicio.EmpleadoServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Empleados", description = "Gestion de empleados")
@RequiredArgsConstructor
@RequestMapping("api/v1/empleados")
@RestController
public class EmpleadoControlador {

    private final EmpleadoServicio servicio;

    @Operation(summary = "Listar empleados", description = "Listar todos los empleados")
    @GetMapping
    public ResponseEntity<List<EmpleadoResponse>> obtenerTodosLosEmpleados() {
        return ResponseEntity.ok(servicio.obtenerTodosLosEmpleados());
    }

    @Operation(summary = "Listar empleados activos", description = "Listar todos los empleados activos")
    @GetMapping("/activo")
    public ResponseEntity<List<EmpleadoResponse>> obtenerEmpleadosActivos() {
        return ResponseEntity.ok(servicio.obtenerEmpleadosActivos());
    }
    
    @Operation(summary = "Registrar empleado", description = "Registrar un nuevo empleado")
    @PostMapping
    public ResponseEntity<String> registrarEmpleado(@Valid @RequestBody EmpleadoRequest request) {
        return ResponseEntity.ok(servicio.registrarEmpleado(request));
    }

    @Operation(summary = "Listar empleado", description = "Listar empleado por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponse> obtenerEmpleadoPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.obtenerEmpleadoPorId(id));
    }

    @Operation(summary = "Actualizar empleado", description = "Actualizar empleado por ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEmpleado(@Valid @RequestBody EmpleadoRequest request, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.actualizarEmpleado(id, request));
    }

    @Operation(summary = "Eliminar empleado", description = "Eliminar empleado por ID")
    @PatchMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.eliminarEmpleado(id));
    }
}
