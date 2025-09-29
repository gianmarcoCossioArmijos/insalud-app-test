package com.insalud.app_test.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insalud.app_test.entidad.Empleado;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

    List<Empleado> findByEstado(Boolean estado);

    @Query(value = "SELECT * FROM empleado WHERE id_empleado = :id AND estado = :estado", nativeQuery = true)
    Optional<Empleado> findById_empleadoAndEstado(Integer id, Boolean estado);
}
