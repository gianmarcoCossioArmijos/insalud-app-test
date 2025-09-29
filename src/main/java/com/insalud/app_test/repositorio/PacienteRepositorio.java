package com.insalud.app_test.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insalud.app_test.entidad.Paciente;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {

    List<Paciente> findByEstado(Boolean estado);

    @Query(value = "SELECT * FROM paciente WHERE id_paciente = :id AND estado = :estado", nativeQuery = true)
    Optional<Paciente> findById_pacienteAndEstado(Integer id, Boolean estado);
}
