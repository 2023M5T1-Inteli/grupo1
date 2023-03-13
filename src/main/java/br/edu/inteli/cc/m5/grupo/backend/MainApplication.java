/**

This is the main entry point for the application.
It initializes the Spring Boot framework and runs the application.
*/
package br.edu.inteli.cc.m5.grupo.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
	/**
	 * This is the main method of the application.
	 * It initializes the Spring Boot framework and starts the application.
	 * @param args the command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}