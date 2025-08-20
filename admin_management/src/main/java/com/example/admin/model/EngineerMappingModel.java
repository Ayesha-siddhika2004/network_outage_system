package com.example.admin.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class EngineerMappingModel {
	
	@Id
	
	private String engId;
	private String incId;
	private String engineerName;
	private String region;
	private String areas;
	private LocalDateTime assignedTime;
	private Incidentstatus status;
	public String getEngId() {
		return engId;
	}
	public void setEngId(String engId) {
		this.engId = engId;
	}
	public String getIncId() {
		return incId;
	}
	public void setIncId(String incId) {
		this.incId = incId;
	}
	public String getEngineerName() {
		return engineerName;
	}
	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAreas() {
		return areas;
	}
	public void setAreas(String areas) {
		this.areas = areas;
	}
	public LocalDateTime getAssignedTime() {
		return assignedTime;
	}
	public void setAssignedTime(LocalDateTime assignedTime) {
		this.assignedTime = assignedTime;
	}
	public Incidentstatus getStatus() {
		return status;
	}
	public void setStatus(Incidentstatus status) {
		this.status = status;
	}
	
	
}
