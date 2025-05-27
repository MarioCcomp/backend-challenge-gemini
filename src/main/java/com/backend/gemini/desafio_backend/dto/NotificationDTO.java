package com.backend.gemini.desafio_backend.dto;

import com.backend.gemini.desafio_backend.enums.NotificationChannel;

import java.time.LocalDateTime;

public class NotificationDTO {

    private String sendTo;
    private String message;
    private NotificationChannel channel;
    private LocalDateTime scheduledTo;

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

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    public LocalDateTime getScheduledTo() {
        return scheduledTo;
    }

    public void setScheduledTo(LocalDateTime scheduledTo) {
        this.scheduledTo = scheduledTo;
    }
}
