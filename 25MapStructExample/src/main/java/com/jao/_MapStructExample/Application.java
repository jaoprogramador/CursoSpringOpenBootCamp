package com.jao._MapStructExample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dao.CountryDao;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		CountryDao.db.entrySet().forEach(System.out::println);
	}

}
