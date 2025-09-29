package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.AtencionMapper;
import com.insalud.app_test.dto.request.AtencionRequest;
import com.insalud.app_test.dto.response.AtencionResponse;
import com.insalud.app_test.repositorio.AtencionRepositorio;
import com.insalud.app_test.repositorio.EmpleadoRepositorio;
import com.insalud.app_test.repositorio.PacienteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtencionServicio {

    private final AtencionRepositorio repositorio;
    private final PacienteRepositorio pacienteRepositorio;
    private final EmpleadoRepositorio empleadoRepositorio;
    private final AtencionMapper mapper;

    public List<AtencionResponse> obetenerTodasLasAtenciones () {
        return repositorio.findAll()
                .stream()
                .map(mapper::aAtencionRespuesta)
                .toList();
    }

    public List<AtencionResponse> obtenerAtencionesActivas () {
        return repositorio.findByEstado(true)
                .stream()
                .map(mapper::aAtencionRespuesta)
                .toList();
    }

    public String registrarAtencion (AtencionRequest request) {
        var atencion = mapper.aAtencionEntidad(request);
        return String.format("Atencion con ID %s registrada exitosamente",repositorio.save(atencion).getId_atencion());
    }

    public AtencionResponse obtenerAtencionPorId (Integer id) {
        var atencion = repositorio.findById_atencionAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Atencion con ID %s no encontrada", id)));
        return mapper.aAtencionRespuesta(atencion);
    }

    public String actualizarAtencion (Integer id, AtencionRequest request) {
        var atencion = repositorio.findById_atencionAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Atencion con ID %s no encontrada", id)));
        atencion.setFecha(request.fecha());
        atencion.setMotivo(request.motivo());
        atencion.setPaciente(pacienteRepositorio.findById(request.id_paciente())
                .orElseThrow(() -> new RuntimeException(String.format("Atencion con ID paciente %s no encontrado", request.id_paciente()))));
        atencion.setEmpleado(empleadoRepositorio.findById(request.id_empleado())
                .orElseThrow(() -> new RuntimeException(String.format("Atencion con ID empleado %s no encontrado", request.id_empleado()))));
        repositorio.save(atencion);
        return String.format("Atencion con ID %s actualizada exitosamente", id);
    }

    public String eliminarAtencion (Integer id) {
        var atencion = repositorio.findById_atencionAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Atencion con ID %s no encontrada", id)));
        atencion.setEstado(false);
        repositorio.save(atencion);
        return String.format("Atencion con ID %s eliminada exitosamente", id);
    }
}
