package com.insalud.app_test.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.AtencionRequest;
import com.insalud.app_test.dto.response.AtencionResponse;
import com.insalud.app_test.servicio.AtencionServicio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/atenciones")
@RestController
public class AtencionControlador {

    private final AtencionServicio servicio;

    @GetMapping
    public ResponseEntity<List<AtencionResponse>> obetenerTodasLasAtenciones() {
        return ResponseEntity.ok(servicio.obetenerTodasLasAtenciones());
    }

    @GetMapping("/activo")
    public ResponseEntity<List<AtencionResponse>> obtenerAtencionesActivas() {
        return ResponseEntity.ok(servicio.obtenerAtencionesActivas());
    }
    
    @PostMapping
    public String registrarAtencion(@Valid @RequestBody AtencionRequest request) {
        return servicio.registrarAtencion(request);
    }
}
