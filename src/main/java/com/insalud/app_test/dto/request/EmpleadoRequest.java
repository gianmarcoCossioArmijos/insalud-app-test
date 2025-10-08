package com.insalud.app_test.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpleadoRequest(

    @Schema(description = "rol de empleado", example = "MEDICO")
    @NotNull(message="El rol no puede ser nulo")
    @NotBlank(message="El rol no puede estar vacio")
    String rol,

    @Schema(description = "estado de empleado", example = "true")
    @NotNull(message="El estado no puede ser nulo")
    Boolean estado,

    @Schema(description = "ID de especialidad", example = "1")
    Integer id_especialidad
) {}
