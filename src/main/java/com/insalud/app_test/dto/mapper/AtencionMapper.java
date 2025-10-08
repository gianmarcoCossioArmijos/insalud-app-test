package com.insalud.app_test.dto.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.AtencionRequest;
import com.insalud.app_test.dto.response.AtencionResponse;
import com.insalud.app_test.entidad.Atencion;
import com.insalud.app_test.entidad.Persona;

@Service
public class AtencionMapper {

    public Atencion aAtencionEntidad(AtencionRequest request) {
        Date fecha;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            fecha = formato.parse(request.fecha());
        } catch (ParseException e) {
            throw new RuntimeException("Error al  parsear fecha", e);
        }
        return Atencion.builder()
                .fecha(fecha)
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

    public AtencionResponse aAtencionRespuesta(Atencion atencion) {
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
