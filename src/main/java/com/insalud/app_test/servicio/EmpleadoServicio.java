package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.EmpleadoMapper;
import com.insalud.app_test.dto.request.EmpleadoRequest;
import com.insalud.app_test.dto.response.EmpleadoResponse;
import com.insalud.app_test.repositorio.EmpleadoRepositorio;
import com.insalud.app_test.repositorio.EspecialidadRespositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServicio {

    private final EmpleadoRepositorio repositorio;
    private final EspecialidadRespositorio especialidadRepositorio;
    private final EmpleadoMapper mapper;

    public List<EmpleadoResponse> obtenerTodosLosEmpleados() {
        return repositorio.findAll()
                .stream()
                .map(mapper::aEmpleadoRespuesta)
                .toList();
    }

    public List<EmpleadoResponse> obtenerEmpleadosActivos() {
        return repositorio.findByEstado(true)
                .stream()
                .map(mapper::aEmpleadoRespuesta)
                .toList();
    }

    public String registrarEmpleado (EmpleadoRequest request) {
        var empleado = mapper.aEmpleadoEntidad(request);
        return String.format("Empleado con ID %s registrado exitosamente",repositorio.save(empleado).getId_rol());
    }

    public EmpleadoResponse obtenerEmpleadoPorId(Integer id) {
        var empleado = repositorio.findById_empleadoAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Empleado con ID %s no encontrado", id)));
        return mapper.aEmpleadoRespuesta(empleado);
    }

    public String actualizarEmpleado(Integer id, EmpleadoRequest request) {
        var empleado = repositorio.findById_empleadoAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Empleado con ID %s no encontrado", id)));
        empleado.setRol(request.rol());
        empleado.setEspecialidades(List.of(especialidadRepositorio.findById(request.id_especialidad())
                .orElseThrow(() -> new RuntimeException(String.format("Empleado con ID especialidad %s no encontrada", request.id_especialidad())))));
        repositorio.save(empleado);
        return String.format("Empleado con ID %s actualizado exitosamente", id);
    }

    public String eliminarEmpleado(Integer id) {
        var empleado = repositorio.findById_empleadoAndEstado(id, true)
                .orElseThrow(() -> new RuntimeException(String.format("Empleado con ID %s no encontrado", id)));
        empleado.setEstado(false);
        repositorio.save(empleado);
        return String.format("Empleado con ID %s eliminado exitosamente", id);
    }
}
