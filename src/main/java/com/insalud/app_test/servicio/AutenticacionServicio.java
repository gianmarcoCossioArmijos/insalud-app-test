package com.insalud.app_test.servicio;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.request.UsuarioRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AutenticacionServicio {

    private final UsuarioServicio usuarioServicio;
    //private final AutenticacionMapper mapper;
    //private final AuthenticationManager authenticationManager;
    //private final JwtServicio jwtServicio;

    /*public AutenticacionResponse login(AutenticacionRequest request) {
        
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.usuario(), request.contraseña()));
        UserDetails userDetails = usuarioServicio.obtenerUsuarioPorNombre(request.usuario());
        String token = jwtServicio.obtenertoken(userDetails);
        return mapper.autenticacionRespuesta(token);
    }*/

    public String registrarUsuario(UsuarioRequest request) {
        return usuarioServicio.registrarUsuario(request);
    }
}
