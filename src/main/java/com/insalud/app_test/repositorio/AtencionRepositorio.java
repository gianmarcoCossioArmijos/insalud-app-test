package com.insalud.app_test.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insalud.app_test.entidad.Atencion;

@Repository
public interface AtencionRepositorio extends JpaRepository<Atencion, Integer> {

    List<Atencion> findByEstado(Boolean estado);
}
