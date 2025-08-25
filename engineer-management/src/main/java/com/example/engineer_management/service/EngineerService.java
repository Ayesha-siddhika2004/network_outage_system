package com.example.engineer_management.service;

import com.example.engineer_management.model.Engineer;
import com.example.engineer_management.repository.EngineerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EngineerService {

    private final EngineerRepository engineerRepository;

    public EngineerService(EngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    public List<Engineer> getAllEngineers() {
        return engineerRepository.findAll();
    }

    public List<Engineer> getEngineersByRegion(String region) {
        return engineerRepository.findByRegion(region);
    }

    public Engineer getEngineerByName(String name) {
        return engineerRepository.findByName(name);
    }
}
