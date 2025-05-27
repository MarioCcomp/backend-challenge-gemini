package com.backend.gemini.desafio_backend.model;

import com.backend.gemini.desafio_backend.enums.NotificationChannel;
import com.backend.gemini.desafio_backend.enums.NotificationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sendTo;

    @Column
    private String message;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NotificationStatus status;

    @Enumerated(EnumType.STRING)
    @Column
    private NotificationChannel channel;


    @Column
    private LocalDateTime scheduledTo;

    @Column
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }


    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public LocalDateTime getScheduledTo() {
        return scheduledTo;
    }

    public void setScheduledTo(LocalDateTime scheduledTo) {
        this.scheduledTo = scheduledTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }
}
