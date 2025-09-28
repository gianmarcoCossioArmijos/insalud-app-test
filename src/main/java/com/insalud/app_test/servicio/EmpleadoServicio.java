package com.insalud.app_test.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.mapper.EmpleadoMapper;
import com.insalud.app_test.dto.request.EmpleadoRequest;
import com.insalud.app_test.dto.response.EmpleadoResponse;
import com.insalud.app_test.repositorio.EmpleadoRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpleadoServicio {

    private final EmpleadoRepositorio repositorio;
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
        return String.format("Empleado con ID %s registrado exitosamente",repositorio.save(empleado).getId_empleado());
    }
}
