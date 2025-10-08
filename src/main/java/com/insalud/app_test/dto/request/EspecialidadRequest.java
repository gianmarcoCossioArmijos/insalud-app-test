package com.insalud.app_test.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EspecialidadRequest(

    @Schema(description = "nombre de especialidad", example = "pediatria")
    @NotNull(message="El nombre no puede ser nulo")
    @NotBlank(message="El nombre no puede estar vacio")
    String nombre,

    @Schema(description = "estado de especialidad", example = "TRUE")
    @NotNull(message="El estado no puede ser nulo")
    Boolean estado
) {}
