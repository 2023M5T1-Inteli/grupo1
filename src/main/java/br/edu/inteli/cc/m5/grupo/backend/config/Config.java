/**

This is a Spring configuration class that enables CORS in the application.
*/
package br.edu.inteli.cc.m5.grupo.backend.config;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config implements WebMvcConfigurer {

    /**
    * Configuration for CORS to allow all origins, HTTP methods and headers.
    * @param registry CorsRegistry used to register CORS settings.
    */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowedHeaders("*");
    }
    
}