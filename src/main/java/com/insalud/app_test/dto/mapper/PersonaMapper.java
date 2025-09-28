package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.PersonaRequest;
import com.insalud.app_test.dto.response.PersonaResponse;
import com.insalud.app_test.entidad.Persona;

@Service
public class PersonaMapper {

    public Persona aPersonaEntidad(PersonaRequest request) {
        return Persona.builder()
                .nombre(request.nombre())
                .email(request.email())
                .estado(request.estado())
                .build();
    }

    public PersonaResponse aPersonaRespuesta(Persona persona) {
        return new PersonaResponse(
                persona.getId_persona(),
                persona.getNombre(),
                persona.getEmail(),
                persona.getEstado());
    }
}
