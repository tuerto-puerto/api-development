package com.example.notificationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledEmailSender {
    private final JavaMailSender mailSender;

    @Autowired
    public  ScheduledEmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Scheduled(cron = "0 */3 * * * *")
    public  void sendScheduledEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("turatbek777torobekov@gmail.com");
            message.setTo("turatbek.torobekov@alatoo.edu.kg");
            message.setSubject("Уведомление по расписанию");
            message.setText("Салам! это твой ежедневный спам");

            mailSender.send(message);
            System.out.println("Уведомление отправлено");
        } catch (Exception e) {
            System.err.println("Ошибка :( " + e.getMessage());
        }
    }
}

