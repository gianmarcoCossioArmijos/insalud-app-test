package com.insalud.app_test.dto.response;

public record PersonaResponse(

    Integer id_persona,
    String nombre_persona,
    String email_persona,
    Boolean estado_persona,
    Integer id_rol,
    String rol
) {}
