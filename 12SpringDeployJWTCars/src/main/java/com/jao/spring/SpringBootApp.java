package com.jao.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Clase punto de entrada a SpringBoot para que escanee las clases a partir de aquí
 **/
@SpringBootApplication
public class SpringBootApp {
	/**
	 * Metodo main punto de entrada
	 * @params args
	 **/
	public static void main(String[] args) {
		// contenedor de beans
		SpringApplication.run(SpringBootApp.class, args);
	}

}
