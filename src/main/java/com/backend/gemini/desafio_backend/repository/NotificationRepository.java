package com.backend.gemini.desafio_backend.repository;

import com.backend.gemini.desafio_backend.enums.NotificationStatus;
import com.backend.gemini.desafio_backend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByStatusAndScheduledToLessThanEqual(NotificationStatus status, LocalDateTime dateTime);

}
