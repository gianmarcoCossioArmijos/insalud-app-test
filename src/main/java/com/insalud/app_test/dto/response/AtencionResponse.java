package com.insalud.app_test.dto.response;

import java.util.Date;

public record AtencionResponse(

    Integer id_atencion,
    Date fecha,
    String motivo,
    Boolean estado,
    Integer id_paciente,
    String nombrepaciente,
    Integer id_empleado,
    String nombre_empleado
) {}
