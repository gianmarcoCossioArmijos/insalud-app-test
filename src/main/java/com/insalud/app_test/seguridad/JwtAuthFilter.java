package com.insalud.app_test.seguridad;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.insalud.app_test.servicio.UsuarioDetalleServicio;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UsuarioDetalleServicio usuarioServicio;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String header = request.getHeader("Authorization");
            String token = null;
            String usuario = null;
            if (header != null && header.startsWith("Bearer ")) {
                token = header.substring(7);
                usuario = JwtServicio.extractUsername(token);
            }
            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }
            if (usuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            
                UserDetails userDetails = usuarioServicio.loadUserByUsername(usuario);
                if (JwtServicio.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
            filterChain.doFilter(request, response);
        } catch (ServletException | IOException | UsernameNotFoundException e) {
            throw e;
        }
    }
}
