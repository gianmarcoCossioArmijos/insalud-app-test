package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.EspecialidadRequest;
import com.insalud.app_test.dto.response.EmpleadoResponse;
import com.insalud.app_test.dto.response.EspecialidadResponse;
import com.insalud.app_test.entidad.Especialidad;

@Service
public class EspecialidadMapper {

    public Especialidad aEspecialidadEntidad(EspecialidadRequest request) {
        return Especialidad.builder()
            .nombre(request.nombre())
            .estado(request.estado())
            .build();
    }

    public EspecialidadResponse aEspecialidadRespuesta(Especialidad especialidad) {
        return new EspecialidadResponse(
            especialidad.getId_especialidad(),
            especialidad.getNombre(),
            especialidad.getEstado(),
            especialidad.getEmpleados().stream()
                    .map(empleado -> new EmpleadoResponse(
                        empleado.getId_empleado(),
                        empleado.getRol(),
                        empleado.getEstado(),
                        empleado.getPersona().getId_persona(),
                        empleado.getPersona().getNombre(),
                        empleado.getPersona().getEmail(),
                        empleado.getPersona().getEstado(),
                        null
                    )).toList());
    }
}
