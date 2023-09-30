package com.colaboradores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Especifique os caminhos que você deseja permitir CORS
                        .allowedOrigins("http://127.0.0.1:8080") // Permita solicitações da origem do seu aplicativo AngularJS
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Permita os métodos HTTP necessários
                        .allowCredentials(true); // Permita cookies, se necessário
            }
        };
    }
}

