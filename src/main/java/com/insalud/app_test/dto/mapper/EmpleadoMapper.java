package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.EmpleadoRequest;
import com.insalud.app_test.dto.response.EmpleadoResponse;
import com.insalud.app_test.dto.response.EspecialidadResponse;
import com.insalud.app_test.entidad.Empleado;
import com.insalud.app_test.entidad.Persona;

@Service
public class EmpleadoMapper {

    public Empleado aEmpleadoEntidad(EmpleadoRequest request) {
        return Empleado.builder()
            .rol(request.rol())
            .estado(request.estado())
            .persona(Persona.builder()
                    .id_persona(request.id_persona())
                    .build())
            .build();
    }

    public EmpleadoResponse aEmpleadoRespuesta(Empleado empleado) {
        return new EmpleadoResponse(
            empleado.getId_empleado(),
            empleado.getRol(),
            empleado.getEstado(),
            empleado.getPersona().getId_persona(),
            empleado.getPersona().getNombre(),
            empleado.getPersona().getEmail(),
            empleado.getPersona().getEstado(),
            empleado.getEspecialidades().stream()
                    .map(especialidad -> new EspecialidadResponse(
                            especialidad.getId_especialidad(),
                            especialidad.getNombre(),
                            especialidad.getEstado(),
                            null))
                    .toList());
    }
}
