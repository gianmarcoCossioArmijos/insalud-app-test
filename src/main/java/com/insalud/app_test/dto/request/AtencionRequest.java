package com.insalud.app_test.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtencionRequest(

    @NotNull(message="La fecha no puede ser nulo")
    @NotBlank(message="La fecha no puede estar vacio")
    Date fecha,
    @NotNull(message="El motivo no puede ser nulo")
    @NotBlank(message="El motivo no puede estar vacio")
    String motivo,
    @NotNull(message="El estado no puede ser nulo")
    @NotBlank(message="El estado no puede estar vacio")
    Boolean estado,
    @NotNull(message="El ID paciente no puede ser nulo")
    @NotBlank(message="El ID paciente no puede estar vacio")
    Integer id_paciente,
    @NotNull(message="El ID empleado no puede ser nulo")
    @NotBlank(message="El ID empleado no puede estar vacio")
    Integer id_empleado
) {}
