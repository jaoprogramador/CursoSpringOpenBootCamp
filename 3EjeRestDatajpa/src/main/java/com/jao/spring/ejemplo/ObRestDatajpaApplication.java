package com.jao.spring.ejemplo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jao.spring.ejemplo.entities.Disco;
import com.jao.spring.ejemplo.repository.DiscoRepository;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		DiscoRepository repository = context.getBean(DiscoRepository.class);

		// CRUD
		// crear disco
		Disco disck1 = new Disco(null, "Whats the story Moorning glory", "Oasis", 12, (double) 15, 1995);
				
		Disco disck2 = new Disco(null, "Girls and Boys", "Blur", 10, (double) 15, 1995);
		// almacenar un disco
		System.out.println("Num discos en base de datos: " + repository.findAll().size());

		repository.save(disck1);
		repository.save(disck2);

		// recuperar todos los discos
		System.out.println("Num discos en base de datos: " + repository.findAll().size());

		// borrar un disco
		// repository.deleteById(1L);

		System.out.println("Num discos en base de datos: " + repository.findAll().size());
	}

}
