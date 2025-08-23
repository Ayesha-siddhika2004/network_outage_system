package com.example.outage.service;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.outage.model.OutageModel;
import com.example.outage.repository.OutageRepository;

@Service
public class OutageService {

    private final OutageRepository repo;
    private final RestTemplate restTemp; // for inter-service call

    @Value("${incident.service.url}")
    private String incidentServiceUrl; // from config / application.yml

    // Map of Region -> List of Areas
    private final Map<String, List<String>> regionAreas = new HashMap<>();

    public OutageService(OutageRepository repo, RestTemplate restTemp) {
        this.repo = repo;
        this.restTemp = restTemp;
    }

    // Called automatically after bean construction
    @PostConstruct
    private void loadAreasFromExcel() {
        try {
            File file = new File("networkareas.xlsx");
            System.out.println("📂 Looking for Excel at: " + file.getAbsolutePath());

            if (!file.exists()) {
                throw new RuntimeException("❌ networkareas.xlsx not found at " + file.getAbsolutePath());
            }

            try (InputStream is = new FileInputStream(file);
                 Workbook workbook = new XSSFWorkbook(is)) {

                Sheet sheet = workbook.getSheetAt(0);
                boolean headerRow = true;

                for (Row row : sheet) {
                    if (headerRow) {
                        headerRow = false;
                        continue;
                    }

                    Cell regionCell = row.getCell(1);
                    Cell areaCell = row.getCell(2);

                    if (regionCell == null || areaCell == null) continue;

                    String region = regionCell.toString().trim();
                    String area = areaCell.toString().trim();

                    System.out.println("➡ Region: " + region + ", Area: " + area);

                    regionAreas.computeIfAbsent(region, k -> new ArrayList<>()).add(area);
                }

                System.out.println("✅ Loaded regions & areas from Excel: " + regionAreas.size());
            }

        } catch (Exception e) {
            throw new RuntimeException("Error loading areas file from project root", e);
        }
    }



    // 2. Generate random outage
    public OutageModel simulateRandomOutage() {
        Random random = new Random();

        // 1. Pick a random region
        List<String> regions = new ArrayList<>(regionAreas.keySet());
        if (regions.isEmpty()) {
            throw new IllegalStateException("No regions loaded from Excel file!");
        }
        String randomRegion = regions.get(random.nextInt(regions.size()));

        // 2. Pick a random area from that region
        List<String> areasOfRegion = regionAreas.get(randomRegion);
        String randomArea = areasOfRegion.get(random.nextInt(areasOfRegion.size()));

        // 3. Other random values
        String severity = random.nextBoolean() ? "High" : "Low";
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime expectedEndTime = startTime.plusHours(3);

        // 4. Create outage object
        OutageModel outage = new OutageModel(
                UUID.randomUUID().toString(),
                randomRegion,
                randomArea,
                startTime,
                expectedEndTime,
                severity
        );

        // 5. Save into OutageDB
        OutageModel savedOutage = repo.save(outage);

        // 6. Prepare DTO for Incident Service
        IncidentDto incidentDto = new IncidentDto(
                savedOutage.getOutId(),
                savedOutage.getRegion(),
                savedOutage.getArea(),
                savedOutage.getStartTime(),
                savedOutage.getExpectedEndTime(),
                savedOutage.getSeverity()
        );

        // 7. Call Incident Service
        restTemp.postForObject(
                incidentServiceUrl + "/api/incidents",
                incidentDto,
                IncidentDto.class
        );

        // 8. Return saved outage
        return savedOutage;
    }
}

