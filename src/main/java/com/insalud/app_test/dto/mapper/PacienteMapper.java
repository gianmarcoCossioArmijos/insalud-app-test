package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.PacienteRequest;
import com.insalud.app_test.dto.response.PacienteResponse;
import com.insalud.app_test.entidad.Paciente;

@Service
public class PacienteMapper {

    public Paciente aPacienteEntidad(PacienteRequest request) {
        return Paciente.builder()
            .rol(request.rol())
            .estado(request.estado())
            .build();
    }

    public PacienteResponse aPacienteRespuesta(Paciente paciente) {
        return new PacienteResponse(
            paciente.getId_rol(),
            paciente.getRol(),
            paciente.getEstado(),
            paciente.getPersona().getId_persona(),
            paciente.getPersona().getNombre(),
            paciente.getPersona().getEmail(),
            paciente.getPersona().getEstado());
    }
}
