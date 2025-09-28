package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.EspecialidadMapper;
import com.insalud.app_test.dto.request.EspecialidadRequest;
import com.insalud.app_test.dto.response.EspecialidadResponse;
import com.insalud.app_test.repositorio.EspecialidadRespositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EspecialidadServicio {

    private final EspecialidadRespositorio repositorio;
    private final EspecialidadMapper mapper;

    public List<EspecialidadResponse> obtenerTodasLasEspecialidades() {
        return repositorio.findAll()
                .stream()
                .map(mapper::aEspecialidadRespuesta)
                .toList();
    }

    public List<EspecialidadResponse> obtenerEspecialidadesActivas() {
        return repositorio.findByEstado(true)
                .stream()
                .map(mapper::aEspecialidadRespuesta)
                .toList();
    }

    public String registrarEspecialidad (EspecialidadRequest request) {
        var especialidad = mapper.aEspecialidadEntidad(request);
        return String.format("Especialidad con ID %s registrada exitosamente", repositorio.save(especialidad));
    }
}
