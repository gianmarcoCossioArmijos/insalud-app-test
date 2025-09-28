package com.insalud.app_test.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpleadoRequest(

    @NotNull(message="El rol no puede ser nulo")
    @NotBlank(message="El rol no puede estar vacio")
    String rol,
    @NotNull(message="El estado no puede ser nulo")
    @NotBlank(message="El estado no puede estar vacio")
    Boolean estado,
    @NotNull(message="El ID persona no puede ser nulo")
    @NotBlank(message="El ID persona no puede estar vacio")
    Integer id_persona,
    @NotNull(message="El ID especialidad no puede ser nulo")
    @NotBlank(message="El ID especialidad no puede estar vacio")
    Integer id_especialidad
) {}
