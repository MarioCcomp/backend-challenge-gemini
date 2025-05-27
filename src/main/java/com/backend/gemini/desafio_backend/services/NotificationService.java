package com.backend.gemini.desafio_backend.services;

import com.backend.gemini.desafio_backend.dto.NotificationDTO;
import com.backend.gemini.desafio_backend.enums.NotificationStatus;
import static com.backend.gemini.desafio_backend.mapper.ObjectMapper.*;
import com.backend.gemini.desafio_backend.model.Notification;
import com.backend.gemini.desafio_backend.repository.NotificationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public NotificationDTO scheduleNotification(Notification request) {
        if(request.getScheduledTo().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Você nao pode agendar uma data passada");
        }
        request.setStatus(NotificationStatus.AGENDADO);
        request.setCreatedAt(LocalDateTime.now());
        return parseObject(repository.save(request), NotificationDTO.class);

    }

    public NotificationDTO findById(Long id) {
        return parseObject(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id nao encontrado")), NotificationDTO.class);
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void processScheduledNotifications() {
        List<Notification> notificationsToSend = repository.findByStatusAndScheduledToLessThanEqual(
                NotificationStatus.AGENDADO,
                LocalDateTime.now()
        );

        if (notificationsToSend.isEmpty()) {
            return;
        }


        for (Notification notification : notificationsToSend) {


            notification.setStatus(NotificationStatus.ENVIADO);
        }

        repository.saveAll(notificationsToSend);
    }

    public void delete(Long id) {
        Notification not = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id nao encontrado"));
        if(not.getStatus() != NotificationStatus.AGENDADO) {
            throw new IllegalArgumentException("Você nao pode cancelar uma notificação que não está agendada");
        }
        not.setStatus(NotificationStatus.CANCELADO);
        repository.save(not);


    }
}
