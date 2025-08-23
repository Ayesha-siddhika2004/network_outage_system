package com.example.outage.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;



import com.example.outage.service.OutageService;

@RestController
@RequestMapping("/api/OutageModel")
public class OutageController {

   private final OutageService service;

   public OutageController(OutageService outageService) {
        this.service = outageService;
    }

   // Runs every 1 minute
   @Scheduled(fixedRate = 60000)
   public void autoGenerateOutage() {
       service.simulateRandomOutage();
       System.out.println("⚡ Auto-simulated outage inserted in DB");
   }
}

