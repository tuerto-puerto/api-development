package com.example.notificationsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledEmailSender {
    private final JavaMailSender mailSender;

    @Value("${scheduler.enabled}")
    private boolean schedulerEnabled;

    @Autowired
    public  ScheduledEmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Scheduled(cron = "*/10 * * * * *", zone = "Asia/Bishkek")
    public  void sendScheduledEmail() {
        if (!schedulerEnabled){
            return;
        }
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

