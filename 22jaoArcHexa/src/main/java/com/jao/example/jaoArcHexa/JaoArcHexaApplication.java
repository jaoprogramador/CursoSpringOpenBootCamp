package com.jao.example.jaoArcHexa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jao.example.jaoArcHexa.application.ports.UserRepository;
import com.jao.example.jaoArcHexa.domain.pojos.User;

@SpringBootApplication
public class JaoArcHexaApplication {

	@Autowired
	private UserRepository userRepository;
	  
	public static void main(String[] args) {
		SpringApplication.run(JaoArcHexaApplication.class, args);
	}
	
	/* @Bean
	    public CommandLineRunner loadData() {
	        return args -> {
	            // Cargar registros de prueba en la base de datos
	            User user1 = User.builder()
	                    .name("jao")
	                    .email("jao@mail.es")
	                    .activo("A")
	                    .fechaAlta(new Date())
	                    .build();

	            User user2 = User.builder()
	                    .name("ale")
	                    .email("alejandra@mail.es")
	                    .activo("A")
	                    .fechaAlta(new Date())
	                    .build();

	            User user3 = User.builder()
	                    .name("guillermo")
	                    .email("guiguig@mail.es")
	                    .activo("A")
	                    .fechaAlta(new Date())
	                    .build();
	            User user4 = User.builder()
	                    .name("joseba")
	                    .email("jow@mail.es")
	                    .activo("A")
	                    .fechaAlta(new Date())
	                    .build();

	            // Guarda los usuarios en la base de datos
	            userRepository.save(user1);
	            userRepository.save(user2);
	            userRepository.save(user3);
	            userRepository.save(user4);
	            System.out.println("Usuarios cargados con éxito!");
	        };
	    }*/

}
