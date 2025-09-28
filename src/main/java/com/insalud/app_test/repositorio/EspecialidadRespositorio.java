package com.insalud.app_test.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insalud.app_test.entidad.Especialidad;

@Repository
public interface EspecialidadRespositorio extends JpaRepository<Especialidad, Integer> {

}
