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
        return String.format("Paciente con ID %s registrado exitosamente",repositorio.save(paciente).getId_rol());
    }

    public PacienteResponse obtenerPacientePorId(Integer id) {
        var paciente = repositorio.findById_pacienteAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Paciente con ID %s no encontrado", id)));
        return mapper.aPacienteRespuesta(paciente);
    }

    public String actualizarPaciente(Integer id, PacienteRequest request) {
        var paciente = repositorio.findById_pacienteAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Paciente con ID %s no encontrado", id)));
        paciente.setRol(request.rol());
        repositorio.save(paciente);
        return String.format("Paciente con ID %s actualizado exitosamente", id);
    }

    public String eliminarPaciente(Integer id) {
        var paciente = repositorio.findById_pacienteAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Paciente con ID %s no encontrado", id)));
        paciente.setEstado(false);
        repositorio.save(paciente);
        return String.format("Paciente con ID %s eliminado exitosamente", id);
    }
}
