package com.insalud.app_test.dto.response;

public record UsuarioResponse(

    Integer id_usuario,
    String username,
    String password,
    Integer id_persona,
    String nombre_persona,
    String email_persona,
    Boolean estado_persona
) {}
