package com.jao.spring.ejemplo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSprindatajpaApplication {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSprindatajpaApplication.class, args);

		EmpresaRepository repository = context.getBean(EmpresaRepository.class);

		System.out.println("INI:::El num de empresas en base de datos es: " + repository.count());

		// crear y almacenar un coche en base de datos
		Empresa serikat = new Empresa(null, "Serikat","12345","TIC",200,1990);
		repository.save(serikat);
		Empresa sd = new Empresa(null, "Saunier Duval","12346","Energicas",800,1970);
		repository.save(sd);
		Empresa ejie = new Empresa(null, "EJIE","12347","TIC",400,1989);
		repository.save(ejie);

		System.out.println("FIN:::El num de empresas en base de datos es: " + repository.count());

		// recuperar todos
		System.out.println(repository.findAll());
	}

}
