/**

Classe de configuração do Spring para habilitar o CORS na aplicação.
*/
package br.edu.inteli.cc.m5.grupo.backend.config;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config implements WebMvcConfigurer {
    /**
     * Configuração do CORS para permitir todas as origens, métodos HTTP e cabeçalhos.
     * @param registry CorsRegistry utilizado para registrar as configurações do CORS.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowedHeaders("*");
    }
}