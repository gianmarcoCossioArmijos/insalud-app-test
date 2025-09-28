package com.insalud.app_test.dto.response;

import java.util.Date;

public record AtencionResponse(

    Integer id_atencion,
    Date fecha,
    String motivo,
    Boolean estado,
    Integer id_paciente,
    String rol_paciente,
    Boolean estado_paciente,
    Integer id_empleado,
    String rol_empleado,
    Boolean estado_empleado
) {}
