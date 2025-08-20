package com.example.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.admin.model.AdminTableModel;
import com.example.admin.model.EngineerMappingModel;


public interface EngineerMappingRepository extends JpaRepository<AdminTableModel,String>{

	Optional<EngineerMappingModel> findByIncidentId(Long incId);
	List<EngineerMappingModel>  findByStatus(String status);

	
}
