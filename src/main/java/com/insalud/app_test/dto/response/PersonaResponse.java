package com.insalud.app_test.dto.response;

public record PersonaResponse(

    Integer id_persona,
    String nombre,
    String email,
    Boolean estado
) {}
