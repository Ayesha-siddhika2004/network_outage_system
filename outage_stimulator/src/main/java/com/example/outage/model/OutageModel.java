package com.example.outage.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "outages")
public class OutageModel {

    @Id
    private String outId;
    private String region;
    private String area;
    private LocalDateTime startTime;        // Outage start time
    private LocalDateTime expectedEndTime;  // New field ✅
    private String type; //power,network
    private String severity;

    public OutageModel() {}

    public OutageModel(String outId, String randomRegion, String randomArea, LocalDateTime startTime,
                       LocalDateTime expectedEndTime,
                       String type, String severity) {
        this.outId = outId;
        this.region=randomRegion;
        this.area=randomArea;
        this.startTime = startTime;
        this.expectedEndTime = expectedEndTime;
        this.type = type;
        this.severity = severity;
    }



	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getExpectedEndTime() {
		return expectedEndTime;
	}

	public void setExpectedEndTime(LocalDateTime expectedEndTime) {
		this.expectedEndTime = expectedEndTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

    // Getters & setters for all fields
    
}

