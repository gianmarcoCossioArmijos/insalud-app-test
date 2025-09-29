package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.PersonaMapper;
import com.insalud.app_test.dto.request.PersonaRequest;
import com.insalud.app_test.dto.response.PersonaResponse;
import com.insalud.app_test.repositorio.PersonaRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaServicio {

    private final PersonaRepositorio repositorio;
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
        var persona = mapper.aPersonaEntidad(request);
        return String.format("Persona con ID %s registrado exitosamente",repositorio.save(persona).getId_persona());
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
