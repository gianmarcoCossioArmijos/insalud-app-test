package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.EmpleadoRequest;
import com.insalud.app_test.dto.response.EmpleadoResponse;
import com.insalud.app_test.entidad.Empleado;

@Service
public class EmpleadoMapper {

    public Empleado aEmpleadoEntidad(EmpleadoRequest request) {
        return Empleado.builder()
            .rol(request.rol())
            .estado(request.estado())
            .build();
    }

    public EmpleadoResponse aEmpleadoRespuesta(Empleado empleado) {
        return new EmpleadoResponse(
            empleado.getId_rol(),
            empleado.getRol(),
            empleado.getEstado());
    }
}
