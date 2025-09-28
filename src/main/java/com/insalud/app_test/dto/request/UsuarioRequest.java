package com.insalud.app_test.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(

    @NotNull(message="El usuario no puede ser nulo")
    @NotBlank(message="El usuario no puede estar vacio")
    String usuario,
    @NotNull(message="La contraseña no puede ser nula")
    @NotBlank(message="La contraseña no puede estar vacia")
    String contraseña,
    @NotNull(message="El ID persona no puede ser nulo")
    @NotBlank(message="El ID persona no puede estar vacio")
    Integer id_persona
) {}
