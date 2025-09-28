package com.insalud.app_test.dto.response;

import java.util.List;

public record EmpleadoResponse(

    Integer id_empleado,
    String rol,
    Boolean estado,
    Integer id_persona,
    String nombre_persona,
    String email_persona,
    Boolean estado_persona,
    List<EspecialidadResponse> especialidades
) {}
