package com.insalud.app_test.servicio;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.insalud.app_test.repositorio.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioDetalleServicio implements UserDetailsService {

    private final UsuarioRepositorio repositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuarioEncontrado = repositorio.findByUsuario(username)
                .orElseThrow(() -> new RuntimeException(String.format("Usuario %s no encontrado", username)));
        return usuarioEncontrado;
    }
}
