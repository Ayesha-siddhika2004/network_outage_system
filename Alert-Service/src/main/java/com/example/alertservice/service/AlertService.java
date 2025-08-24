package com.example.alertservice.service;

import com.example.alertservice.model.Alert;
import com.example.alertservice.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public Alert saveAlert(Alert alert) {
        // ✅ If fields not provided, set some defaults
        if (alert.getTimestamp() == null) {
            alert.setTimestamp(LocalDateTime.now());
        }
        if (alert.getStatus() == null) {
            alert.setStatus("Pending"); // default
        }
        if (alert.getPriority() == null) {
            alert.setPriority("Medium"); // default
        }

        return alertRepository.save(alert);
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }
}
