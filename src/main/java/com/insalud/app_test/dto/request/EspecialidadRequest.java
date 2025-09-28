package com.insalud.app_test.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EspecialidadRequest(
    @NotNull(message="El nombre no puede ser nulo")
    @NotBlank(message="El nombre no puede estar vacio")
    String nombre,
    @NotNull(message="El estado no puede ser nulo")
    @NotBlank(message="El estado no puede estar vacio")
    Boolean estado
) {}
