package com.insalud.app_test.dto.response;

public record PacienteResponse(

    Integer id_paciente,
    String rol,
    Boolean estado
) {}
