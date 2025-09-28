package com.insalud.app_test.dto.response;

public record PacienteResponse(

    Integer id_paciente,
    String rol,
    Boolean estado,
    Integer id_persona,
    String nombre_persona,
    String email_persona,
    Boolean estado_persona
) {}
