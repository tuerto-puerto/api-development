package com.example.notificationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final JavaMailSender mailSender;

    public EmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RequestMapping("/send-email")
    public String sendEmail(@RequestParam String toEmail){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("turatbek777tobekov@gmail.com");
            message.setTo(toEmail);
            message.setSubject("йоу");
            message.setText("пока пока");
            mailSender.send(message);
            return "Успех, вы отправили email!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
