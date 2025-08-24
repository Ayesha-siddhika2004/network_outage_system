package com.example.alertservice.controller;

import com.example.alertservice.model.Alert;
import com.example.alertservice.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate; // For WebSocket

    @PostMapping
    public Alert createAlert(@RequestBody Alert alert) {
        // ✅ status, actualEndTime, priority will now also be saved
        Alert savedAlert = alertService.saveAlert(alert);

        // send to WebSocket subscribers
        messagingTemplate.convertAndSend("/topic/alerts", savedAlert);

        return savedAlert;
    }

    @GetMapping
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
