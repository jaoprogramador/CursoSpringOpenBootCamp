package com.jao.example.jaoArcHexa;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jao.example.jaoArcHexa.application.ports.UserRepository;
import com.jao.example.jaoArcHexa.domain.pojos.User;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class JaoArcHexaApplication {

	
	  
	public static void main(String[] args) {
		SpringApplication.run(JaoArcHexaApplication.class, args);
	}
	
	/*
	 * @Bean
	 * 
	 * @Transactional CommandLineRunner initDatabase(UserRepository userRepository)
	 * { return args -> { // Insertar usuarios de prueba en la BD
	 * userRepository.createUser(
	 * User.builder().id(1).name("Jao").email("jao@mail.es").activo("A").fechaAlta(
	 * new Date()).build() );
	 * 
	 * userRepository.createUser(
	 * User.builder().id(2).name("Alejandra").email("alejandra@mail.es").activo("A")
	 * .fechaAlta(new Date()).build() ); userRepository.createUser(
	 * User.builder().id(3).name("Guillermo").email("guigui@mail.es").activo("A").
	 * fechaAlta(new Date()).build() ); userRepository.createUser(
	 * User.builder().id(4).name("Joseba").email("jow@mail.es").activo("A").
	 * fechaAlta(new Date()).build() );
	 * 
	 * 
	 * System.out.println("✅ Usuarios de prueba insertados en H2."); }; }
	 */
}
