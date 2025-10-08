package com.insalud.app_test.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequest(

    @Schema(description = "usuario", example = "lopezb")
    @NotNull(message="El usuario no puede ser nulo")
    @NotBlank(message="El usuario no puede estar vacio")
    String username,

    @Schema(description = "contraseña", example = "123456")
    @NotNull(message="La contraseña no puede ser nula")
    @NotBlank(message="La contraseña no puede estar vacia")
    String password,

    @Schema(description = "ID persona", example = "1")
    @NotNull(message="El ID persona no puede ser nulo")
    Integer id_persona
) {}
