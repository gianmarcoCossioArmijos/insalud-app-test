package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.PersonaRequest;
import com.insalud.app_test.dto.response.PersonaResponse;
import com.insalud.app_test.entidad.Empleado;
import com.insalud.app_test.entidad.Paciente;
import com.insalud.app_test.entidad.Persona;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonaMapper {

    public Persona aPersonaEntidad(PersonaRequest request, Empleado empleado, Paciente paciente) {
        return Persona.builder()
                .nombre(request.nombre())
                .email(request.email())
                .estado(request.estado())
                .empleado((empleado != null)? empleado : null)
                .paciente((paciente != null)? paciente : null)
                .build();
    }

    public PersonaResponse aPersonaRespuesta(Persona persona) {
        Integer personaIdRol;
        String personaRol;
        if (persona.esEmpleado()) {
            personaIdRol = persona.getEmpleado().getId_rol();
            personaRol = persona.getEmpleado().getRol();
        } else {
            personaIdRol = persona.getPaciente().getId_rol();
            personaRol = persona.getPaciente().getRol();
        }
        return new PersonaResponse(
                persona.getId_persona(),
                persona.getNombre(),
                persona.getEmail(),
                persona.getEstado(),
                personaIdRol,
                personaRol);
    }
}
