package com.insalud.app_test.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.EspecialidadRequest;
import com.insalud.app_test.dto.response.EspecialidadResponse;
import com.insalud.app_test.servicio.EspecialidadServicio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/especialidades")
@RestController
public class EspecialidadControlador {

    private final EspecialidadServicio servicio;

    @GetMapping
    public ResponseEntity<List<EspecialidadResponse>> obtenerTodasLasEspecialidades() {
        return ResponseEntity.ok(servicio.obtenerTodasLasEspecialidades());
    }

    @GetMapping("/activo")
    public ResponseEntity<List<EspecialidadResponse>> obtenerEspecialidadesActivas() {
        return ResponseEntity.ok(servicio.obtenerEspecialidadesActivas());
    }
    
    @PostMapping
    public String registrarEspecialidad(@Valid @RequestBody EspecialidadRequest request) {
        return servicio.registrarEspecialidad(request);
    }
}
