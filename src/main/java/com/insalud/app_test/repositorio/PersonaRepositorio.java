package com.insalud.app_test.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insalud.app_test.entidad.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

}
