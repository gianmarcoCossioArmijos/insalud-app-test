package com.insalud.app_test.dto.mapper;

import org.springframework.stereotype.Service;

import com.insalud.app_test.dto.response.AutenticacionResponse;

@Service
public class AutenticacionMapper {

    public AutenticacionResponse autenticacionRespuesta(String token) {
        return new AutenticacionResponse(token);
    }
}
