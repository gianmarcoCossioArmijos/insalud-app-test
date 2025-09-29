package com.insalud.app_test.servicio;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.insalud.app_test.entidad.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServicio {

    private static final String SECRET_KEY = "123456";

    public String obtenerToke(Usuario usuario) {
        return token(new HashMap<>(), usuario);
    }

    private String token(HashMap<String, Object> claims, Usuario usuario) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(usuario.getUsuario())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
