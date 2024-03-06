package com.jao.spring.SpringSecurityCifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@SpringBootApplication
public class Application {
	//esto lo normal sería ponerlo en una clase de Config o seguridad
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		UserRepository repository = context.getBean(UserRepository.class);

		//Primer RG sin encriptar
		User user = new User(null, "David", "12345");
		//User user = new User(null, "usuario", encoder.encode("admin"));
		repository.save(user);
		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);//para instanciar este objeto PasswordEncoder tenemos que poner arriba @Bean public PasswordEncoder passwordEncoder(){
		//Segundo RG encriptado
		user = new User(null, "David", encoder.encode("admin"));
		repository.save(user);

	}

}
