package com.example.engineer_management.controller;

import com.example.engineer_management.model.Engineer;
import com.example.engineer_management.service.EngineerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engineers")
public class EngineerController {

    private final EngineerService engineerService;

    public EngineerController(EngineerService engineerService) {
        this.engineerService = engineerService;
    }

    @GetMapping
    public List<Engineer> getAll() {
        return engineerService.getAllEngineers();
    }

    @GetMapping("/region/{region}")
    public List<Engineer> getByRegion(@PathVariable String region) {
        return engineerService.getEngineersByRegion(region);
    }

    @GetMapping("/name/{name}")
    public Engineer getByName(@PathVariable String name) {
        return engineerService.getEngineerByName(name);
    }
}
