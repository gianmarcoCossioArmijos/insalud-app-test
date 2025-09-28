package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.AtencionRequest;
import com.insalud.app_test.dto.response.AtencionResponse;
import com.insalud.app_test.entidad.Atencion;
import com.insalud.app_test.entidad.Empleado;
import com.insalud.app_test.entidad.Paciente;

@Service
public class AtencionMapper {

    public Atencion aAtencionEntidad (AtencionRequest request) {
        return Atencion.builder()
                .fecha(request.fecha())
                .motivo(request.motivo())
                .estado(request.estado())
                .paciente(Paciente.builder()
                            .id_paciente(request.id_paciente())
                            .build())
                .empleado(Empleado.builder()
                            .id_empleado(request.id_empleado())
                            .build())
                .build();
    }

    public AtencionResponse aAtencionRespuesta (Atencion atencion) {
        return new AtencionResponse(
                atencion.getId_atencion(),
                atencion.getFecha(),
                atencion.getMotivo(),
                atencion.getEstado(),
                atencion.getPaciente().getId_paciente(),
                atencion.getPaciente().getRol(),
                atencion.getPaciente().getEstado(),
                atencion.getEmpleado().getId_empleado(),
                atencion.getEmpleado().getRol(),
                atencion.getEmpleado().getEstado()
        );
    }
}
