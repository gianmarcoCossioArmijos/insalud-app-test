package com.insalud.app_test.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PacienteRequest(

    @Schema(description = "rol de paciente", example = "PACIENTE")
    @NotNull(message="El rol no puede ser nulo")
    @NotBlank(message="El rol no puede estar vacio")
    String rol,

    @Schema(description = "estado de paciente", example = "true")
    @NotNull(message="El estado no puede ser nulo")
    Boolean estado
) {}
