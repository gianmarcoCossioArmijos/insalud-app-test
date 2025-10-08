package com.insalud.app_test.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtencionRequest(

    @Schema(description = "fecha de atencion", example = "10/31/2025 06:30:59")
    @NotNull(message="La fecha no puede ser nulo")
    @NotBlank(message="La fecha no puede estar vacio")
    String fecha,

    @Schema(description = "motivo de atencion", example = "atencion para examenes medicos")
    @NotNull(message="El motivo no puede ser nulo")
    @NotBlank(message="El motivo no puede estar vacio")
    String motivo,

    @Schema(description = "estado de atencion", example = "TRUE")
    @NotNull(message="El estado no puede ser nulo")
    Boolean estado,

    @Schema(description = "ID de paciente", example = "1")
    @NotNull(message="El ID paciente no puede ser nulo")
    Integer id_paciente,

    @Schema(description = "ID de empleado (medico)", example = "1")
    @NotNull(message="El ID empleado no puede ser nulo")
    Integer id_empleado
) {}
