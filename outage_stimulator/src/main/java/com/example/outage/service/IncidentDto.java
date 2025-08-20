package com.example.outage.service;

import java.time.LocalDateTime;

public class IncidentDto {
    private String outId;
    private String region;
    private String area;
    private LocalDateTime startTime;
    private LocalDateTime expectedEndTime;
    private String type;
    private String severity;

    public IncidentDto() {}

    public IncidentDto(String outId, String region, String area,
                       LocalDateTime startTime, LocalDateTime expectedEndTime,
                       String type, String severity) {
        this.outId = outId;
        this.region = region;
        this.area = area;
        this.startTime = startTime;
        this.expectedEndTime = expectedEndTime;
        this.type = type;
        this.severity = severity;
    }

    // getters and setters
    public String getOutId() { return outId; }
    public void setOutId(String outId) { this.outId = outId; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getExpectedEndTime() { return expectedEndTime; }
    public void setExpectedEndTime(LocalDateTime expectedEndTime) { this.expectedEndTime = expectedEndTime; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
}

