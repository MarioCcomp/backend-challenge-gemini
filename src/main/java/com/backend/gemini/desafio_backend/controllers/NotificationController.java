package com.backend.gemini.desafio_backend.controllers;

import com.backend.gemini.desafio_backend.dto.NotificationDTO;
import com.backend.gemini.desafio_backend.model.Notification;
import com.backend.gemini.desafio_backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/notifications")
    public ResponseEntity<NotificationDTO> scheduleNotification(@RequestBody NotificationDTO request) {
        Notification not = new Notification();
        not.setChannel(request.getChannel());
        not.setScheduledTo(request.getScheduledTo());
        not.setMessage(request.getMessage());
        not.setSendTo(request.getSendTo());
        service.scheduleNotification(not);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/notifications/{id}")
    public ResponseEntity<NotificationDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/notifications/{id}")
    public ResponseEntity<NotificationDTO> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
