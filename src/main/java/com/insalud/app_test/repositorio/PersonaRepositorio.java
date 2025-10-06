package com.insalud.app_test.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insalud.app_test.entidad.Persona;

public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    List<Persona> findByEstado(Boolean estado);

    @Query(value = "SELECT * FROM persona WHERE id_persona = :id AND estado = :estado", nativeQuery = true)
    Optional<Persona> findById_personaAndEstado(Integer id,Boolean estado);
}
