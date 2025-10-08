package com.insalud.app_test.seguridad;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Citas Medicas",
                                version = "1.0",
                                contact = @Contact(name = "insalud Test", url = "https://potafolio-2025.vercel.app"),
                                description = "Documentacion de proyecto para prueba tecnica para insalud"),
                    security = { @SecurityRequirement(name = "bearerAuth")})
 @SecurityScheme(name = "bearerAuth",description = "JWT auth",scheme = "bearer",
                type = SecuritySchemeType.HTTP,bearerFormat = "JWT",in = SecuritySchemeIn.HEADER)
public class ConfiguracionOpenApi {

}
