package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.UsuarioRequest;
import com.insalud.app_test.dto.response.UsuarioResponse;
import com.insalud.app_test.entidad.Persona;
import com.insalud.app_test.entidad.Usuario;

@Service
public class UsuarioMapper {

    public Usuario aUsuarioEntidad(UsuarioRequest request, Persona persona) {
        return Usuario.builder()
                .username(request.username())
                .password(request.password())
                .persona(persona)
                .build();
    }

    public Usuario aUsuario(String username, String password, Persona persona) {
        return Usuario.builder()
                .username(username)
                .password(password)
                .persona(persona)
                .build();
    }
 
    public UsuarioResponse aUsuarioRespuesta(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId_usuario(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getPersona().getId_persona(),
                usuario.getPersona().getNombre(),
                usuario.getPersona().getEmail(),
                usuario.getPersona().getEstado());
    }
}
