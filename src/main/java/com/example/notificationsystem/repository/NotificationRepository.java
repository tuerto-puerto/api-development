package com.example.notificationsystem.repository;

import com.example.notificationsystem.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
