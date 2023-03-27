/**

This is a Spring configuration class that enables CORS in the application.
*/
package br.edu.inteli.cc.m5.grupo.backend.config;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/graph")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("POST")
                .allowedHeaders("*");
    }

}