package com.example.notificationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final JavaMailSender mailSender;

    public EmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RequestMapping("/send-email")
    public String sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("turatbek777tobekov@gmail.com");
        message.setTo("turatbek777tobekov@gmail.com");
        message.setSubject("Заголовок должен быть...");
        message.setText("Привет! это сам текст");
        mailSender.send(message);
    }
}
