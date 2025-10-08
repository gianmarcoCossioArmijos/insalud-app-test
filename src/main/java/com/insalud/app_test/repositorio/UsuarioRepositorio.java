package com.insalud.app_test.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insalud.app_test.entidad.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuario WHERE username= :usuario", nativeQuery = true)
    Optional<Usuario> findByUsuario(String usuario);
}
