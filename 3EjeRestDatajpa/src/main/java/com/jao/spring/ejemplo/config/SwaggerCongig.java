package com.jao.spring.ejemplo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/*
 * Configuracion Swagger para la generacion de documentacion de la API REST
 * 
 * http://localhost:8081/swagger-ui/
 * */
@Configuration
public class SwaggerCongig {
	@Bean
	public Docket api(){
	    return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
	}
	//datos de documentacion dem la api inventados
	private ApiInfo apiDetails(){
		return new ApiInfo("Spring boot Discos API REST",
				"Discos API RESTS docs",
				"1.0",
				"http://www.google.com",
				new Contact("jao", "http://euskaltel.com/jaoprogramador", "jaoprogramador@gmail.com"),
				"MIT",
				"http://euskaltel.com/",
				Collections.emptyList());
	}

}
