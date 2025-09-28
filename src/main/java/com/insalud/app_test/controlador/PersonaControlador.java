package com.insalud.app_test.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insalud.app_test.dto.request.PersonaRequest;
import com.insalud.app_test.dto.response.PersonaResponse;
import com.insalud.app_test.servicio.PersonaServicio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RequiredArgsConstructor
@RequestMapping("/api/v1/personas")
@RestController
public class PersonaControlador {

    private final PersonaServicio servicio;
    
    @GetMapping
    public ResponseEntity<List<PersonaResponse>> obtenerTodasLasPersonas() {
        return ResponseEntity.ok(servicio.obtenerTodasLasPersonas());
    }

    @GetMapping("/activo")
    public ResponseEntity<List<PersonaResponse>> obtenerPersonasActivas() {
        return ResponseEntity.ok(servicio.obtenerPersonasActivas());
    }
    
    @PostMapping
    public String registrarPersona(@Valid @RequestBody PersonaRequest request) {
        return servicio.registrarPersona(request);
    }
}
