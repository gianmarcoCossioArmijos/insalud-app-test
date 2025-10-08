package com.insalud.app_test.dto.response;

public record EmpleadoResponse(

    Integer id_empleado,
    String rol,
    Boolean estado
) {}
