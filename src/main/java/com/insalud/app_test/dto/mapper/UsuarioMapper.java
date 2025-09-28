package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.UsuarioResponse;
import com.insalud.app_test.entidad.Persona;
import com.insalud.app_test.entidad.Usuario;

@Service
public class UsuarioMapper {

    public Usuario aUsuarioEntidad(UsuarioRequest request) {
        return Usuario.builder()
                .usuario(request.usuario())
                .contraseña(request.contraseña())
                .persona(Persona.builder()
                        .id_persona(request.id_persona())
                        .build())
                .build();
    }

    public UsuarioResponse aUsuarioRespuesta(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId_usuario(),
                usuario.getUsuario(),
                usuario.getContraseña(),
                usuario.getPersona().getId_persona(),
                usuario.getPersona().getNombre(),
                usuario.getPersona().getEmail(),
                usuario.getPersona().getEstado());
    }
}
