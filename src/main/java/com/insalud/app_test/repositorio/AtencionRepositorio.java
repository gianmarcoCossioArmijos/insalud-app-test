package com.insalud.app_test.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insalud.app_test.entidad.Atencion;

@Repository
public interface AtencionRepositorio extends JpaRepository<Atencion, Integer> {

    List<Atencion> findByEstado(Boolean estado);

    @Query(value = "SELECT * FROM atencion WHERE id_atencion = :id AND estado = :estado", nativeQuery = true)
    Optional<Atencion> findById_atencionAndEstado(Integer id, Boolean estado);
}
