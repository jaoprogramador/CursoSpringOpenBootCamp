package com.jao.spring.task.mail.TareaProgramadaMail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); // Configura el host del servidor SMTP
        mailSender.setPort(587); // Configura el puerto del servidor SMTP
        mailSender.setUsername("jao"); // Configura tu dirección de correo electrónico
        mailSender.setPassword("admin"); // Configura la contraseña de tu correo electrónico

        // Configuración adicional, si es necesario
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}

