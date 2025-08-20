package com.example.admin.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class AdminTableModel {
	
	@Id
	
	private String admId;
	private String incId;
    private String region;
    private String area;
    private LocalDateTime startTime;
    private LocalDateTime expectedEndTime;
    private String type;
    private String severity;
    private Incidentstatus status;
    private LocalDateTime actualEndTime;
    private String engId;
	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId;
	}
	public String getIncId() {
		return incId;
	}
	public void setIncId(String incId) {
		this.incId = incId;
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
	public Incidentstatus getStatus() {
		return status;
	}
	public void setStatus(Incidentstatus status) {
		this.status = status;
	}
	public LocalDateTime getActualEndTime() {
		return actualEndTime;
	}
	public void setActualEndTime(LocalDateTime actualEndTime) {
		this.actualEndTime = actualEndTime;
	}
	public String getEngId() {
		return engId;
	}
	public void setEngId(String engId) {
		this.engId = engId;
	}
    
    
    
}
