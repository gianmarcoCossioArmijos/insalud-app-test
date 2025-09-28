package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.AtencionMapper;
import com.insalud.app_test.dto.request.AtencionRequest;
import com.insalud.app_test.dto.response.AtencionResponse;
import com.insalud.app_test.repositorio.AtencionRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtencionServicio {

    private final AtencionRepositorio repositorio;
    private final AtencionMapper mapper;

    public List<AtencionResponse> obetenerTodasLasAtenciones () {
        return repositorio.findAll()
                .stream()
                .map(mapper::aAtencionRespuesta)
                .toList();
    }

    public List<AtencionResponse> obtenerAtencionesActivas () {
        return repositorio.findByEstado(true)
                .stream()
                .map(mapper::aAtencionRespuesta)
                .toList();
    }

    public String registrarAtencion (AtencionRequest request) {
        var atencion = mapper.aAtencionEntidad(request);
        return String.format("Atencion con ID %s registrada exitosamente",repositorio.save(atencion).getId_atencion());
    }
}
