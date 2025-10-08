package com.insalud.app_test.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PersonaRequest(

    @Schema(description = "nombre de persona", example = "jose luis")
    @NotNull(message="El nombre no puede ser nulo")
    @NotBlank(message="El nombre no puede estar vacio")
    String nombre,

    @Schema(description = "correo electronico", example = "jose@example.com")
    @NotNull(message="El email no puede ser nulo")
    @NotBlank(message="El email no puede estar vacio")
    String email,

    @Schema(description = "estado de usuario", example = "TRUE")
    @NotNull(message="El estado no puede ser nulo")
    Boolean estado,

    @Schema(description = "ID paciente (no es rol empleado)", example = "1")
    Integer id_paciente,

    @Schema(description = "ID empleado (no es rol paciente)", example = "1")
    Integer id_empleado
) {}
