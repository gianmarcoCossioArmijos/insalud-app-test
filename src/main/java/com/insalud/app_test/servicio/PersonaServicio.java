package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.PersonaMapper;
import com.insalud.app_test.dto.request.PersonaRequest;
import com.insalud.app_test.dto.response.PersonaResponse;
import com.insalud.app_test.repositorio.EmpleadoRepositorio;
import com.insalud.app_test.repositorio.PacienteRepositorio;
import com.insalud.app_test.repositorio.PersonaRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaServicio {

    private final PersonaRepositorio repositorio;
    private final EmpleadoRepositorio empleadoRepositorio;
    private final PacienteRepositorio pacienteRepositorio;
    private final PersonaMapper mapper;

    public List<PersonaResponse> obtenerTodasLasPersonas() {
        return repositorio.findAll()
                .stream()
                .map(mapper::aPersonaRespuesta)
                .toList();
    }

    public List<PersonaResponse> obtenerPersonasActivas() {
        return repositorio.findByEstado(true)
                .stream()
                .map(mapper::aPersonaRespuesta)
                .toList();
    }

    public String registrarPersona(PersonaRequest request) {
        int idRegistro;
        if (request.id_empleado() != null && request.id_empleado() != 0) {
            var empleado = empleadoRepositorio.findById(request.id_empleado())
                    .orElseThrow(() -> new RuntimeException(String.format("Empleado con ID %s no encontrada", request.id_empleado())));
            idRegistro = repositorio.save(mapper.aPersonaEntidad(request,empleado,null)).getId_persona();
        } else {
            var paciente = pacienteRepositorio.findById(request.id_paciente())
                    .orElseThrow(() -> new RuntimeException(String.format("Paciente con ID %s no encontrada", request.id_paciente())));
            idRegistro = repositorio.save(mapper.aPersonaEntidad(request,null,paciente)).getId_persona();
        }
        return String.format("Persona con ID %s registrado exitosamente", idRegistro);
    }

    public PersonaResponse obtenerPersonaPorId(Integer id) {
        var persona = repositorio.findById_personaAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Persona con ID %s no encontrada", id)));
        return mapper.aPersonaRespuesta(persona);
    }

    public String actualizarPersona(Integer id, PersonaRequest request) {
        var persona = repositorio.findById_personaAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Persona con ID %s no encontrada", id)));
        persona.setNombre(request.nombre());
        persona.setEmail(request.email());
        persona.setEstado(request.estado());
        repositorio.save(persona);
        return String.format("Persona con ID %s actualizada exitosamente", id);
    }

    public String eliminarPersona(Integer id) {
        var persona = repositorio.findById_personaAndEstado(id,true)
                .orElseThrow(() -> new RuntimeException(String.format("Persona con ID %s no encontrada", id)));
        persona.setEstado(false);
        repositorio.save(persona);
        return String.format("Persona con ID %s eliminada exitosamente", id);
    }
}
