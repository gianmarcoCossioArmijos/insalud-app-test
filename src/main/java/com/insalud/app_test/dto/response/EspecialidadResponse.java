package com.insalud.app_test.dto.response;

import java.util.List;

public record EspecialidadResponse(

    Integer id_especialidad,
    String nombre,
    Boolean estado,
    List<EmpleadoResponse> empleados
) {}
