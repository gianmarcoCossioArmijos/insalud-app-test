package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.PacienteMapper;
import com.insalud.app_test.dto.request.PacienteRequest;
import com.insalud.app_test.dto.response.PacienteResponse;
import com.insalud.app_test.repositorio.PacienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServicio {

    private final PacienteRepositorio repositorio;
    private final PacienteMapper mapper;

    public List<PacienteResponse> obtenerTodosLosPacientes() {
        return repositorio.findAll()
                .stream()
                .map(mapper::aPacienteRespuesta)
                .toList();
    }

    public List<PacienteResponse> obtenerPacientesActivos() {
        return repositorio.findByEstado(true)
                .stream()
                .map(mapper::aPacienteRespuesta)
                .toList();
    }

    public String registrarPaciente(PacienteRequest request) {
        var paciente = mapper.aPacienteEntidad(request);
        return String.format("Paciente con ID %s registrado exitosamente",repositorio.save(paciente).getId_paciente());
    }
}
