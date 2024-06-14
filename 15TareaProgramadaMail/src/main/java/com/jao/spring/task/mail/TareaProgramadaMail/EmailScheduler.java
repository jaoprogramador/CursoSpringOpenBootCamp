package com.jao.spring.task.mail.TareaProgramadaMail;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;

@Component
public class EmailScheduler {

    @Autowired
    private JavaMailSender javaMailSender;

    @Scheduled(cron = "0 32 09 * * ?") // Se ejecuta todos los días a las 13:00
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("jaoprogramador@gmail.com"); // Reemplaza con la dirección de correo del destinatario
        message.setSubject("Asunto del correo");
        message.setText("Contenido del correo");

        javaMailSender.send(message);
    }
}
