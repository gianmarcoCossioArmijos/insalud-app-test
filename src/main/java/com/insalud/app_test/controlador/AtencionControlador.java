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

import com.insalud.app_test.dto.request.AtencionRequest;
import com.insalud.app_test.dto.response.AtencionResponse;
import com.insalud.app_test.servicio.AtencionServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Atenciones", description = "Gestion de atenciones")
@RequiredArgsConstructor
@RequestMapping("api/v1/atenciones")
@RestController
public class AtencionControlador {

    private final AtencionServicio servicio;

    @PreAuthorize("hasAnyAuthority('ADMIN','INVITADO','MEDICO')")
    @Operation(summary = "Listar atenciones", description = "Listar todas las atenciones")
    @GetMapping
    public ResponseEntity<List<AtencionResponse>> obetenerTodasLasAtenciones() {
        return ResponseEntity.ok(servicio.obetenerTodasLasAtenciones());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','INVITADO','MEDICO')")
    @Operation(summary = "Listar atenciones activas", description = "Listar todas las atenciones activas")
    @GetMapping("/activo")
    public ResponseEntity<List<AtencionResponse>> obtenerAtencionesActivas() {
        return ResponseEntity.ok(servicio.obtenerAtencionesActivas());
    }
    
    @PreAuthorize("hasAnyAuthority('ADMIN','MEDICO')")
    @Operation(summary = "Registrar atencion", description = "Registrar nueva atencion")
    @PostMapping
    public ResponseEntity<String> registrarAtencion(@Valid @RequestBody AtencionRequest request) {
        return ResponseEntity.ok(servicio.registrarAtencion(request));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MEDICO')")
    @Operation(summary = "Listar atencion", description = "Listar atencion por ID")
    @GetMapping("/{id}")
    public ResponseEntity<AtencionResponse> obtenerAtencionPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.obtenerAtencionPorId(id));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MEDICO')")
    @Operation(summary = "Actualizar atencion", description = "Actualizar atencion por ID")
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAtencion(@Valid @RequestBody AtencionRequest request, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.actualizarAtencion(id, request));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Eliminar atencion", description = "Eliminar atencion por ID")
    @PatchMapping("/{id}")
    public ResponseEntity<String> eliminarAtencion(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(servicio.eliminarAtencion(id));
    }
}
