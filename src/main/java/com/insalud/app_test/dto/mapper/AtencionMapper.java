package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.AtencionRequest;
import com.insalud.app_test.dto.response.AtencionResponse;
import com.insalud.app_test.entidad.Atencion;
import com.insalud.app_test.entidad.Persona;

@Service
public class AtencionMapper {

    public Atencion aAtencionEntidad (AtencionRequest request) {
        return Atencion.builder()
                .fecha(request.fecha())
                .motivo(request.motivo())
                .estado(request.estado())
                .paciente(Persona.builder()
                            .id_persona(request.id_paciente())
                            .build())
                .empleado(Persona.builder()
                            .id_persona(request.id_empleado())
                            .build())
                .build();
    }

    public AtencionResponse aAtencionRespuesta (Atencion atencion) {
        return new AtencionResponse(
                atencion.getId_atencion(),
                atencion.getFecha(),
                atencion.getMotivo(),
                atencion.getEstado(),
                atencion.getPaciente().getId_persona(),
                atencion.getPaciente().getNombre(),
                atencion.getEmpleado().getId_persona(),
                atencion.getEmpleado().getNombre()
        );
    }
}
