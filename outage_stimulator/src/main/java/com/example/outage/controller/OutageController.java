package com.example.outage.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.outage.model.OutageModel;
import com.example.outage.service.OutageService;

@RestController
@RequestMapping("/api/OutageModel")
public class OutageController {

   // private final OutageService service;

   /* public OutageController(OutageService outageService) {
        this.service = outageService;
    }*/

    // Call this to simulate random outage
    @PostMapping("/simulate")
    public OutageModel simulateOutage() {
        return null;
        		//service.simulateRandomOutage();
    }
}

