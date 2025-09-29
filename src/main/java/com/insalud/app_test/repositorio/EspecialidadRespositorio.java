package com.insalud.app_test.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insalud.app_test.entidad.Especialidad;


@Repository
public interface EspecialidadRespositorio extends JpaRepository<Especialidad, Integer> {

    List<Especialidad> findByEstado(Boolean estado);

    @Query(value = "SELECT * FROM especialidad WHERE id_especialidad = :id AND estado = :estado", nativeQuery = true)
    Optional<Especialidad> findById_especialidadAndEstado(Integer id, Boolean estado);
}
