package com.jao.spring.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



/**
 * Hello world!
 *
 */
@SpringBootApplication()
public class ObSpringMainApplication {

    public static void main(String[] args) {
    	ApplicationContext context = SpringApplication.run(ObSpringMainApplication.class, args);
        //ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
    	System.out.print("JAO RUN");
    }

}