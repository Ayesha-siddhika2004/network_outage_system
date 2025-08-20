package com.example.admin.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.admin.model.AdminTableModel;


public interface AdminRepository extends JpaRepository<AdminTableModel,String>{

	List<AdminTableModel> findByTodaysOutage(LocalDateTime start, LocalDateTime end);
	List<AdminTableModel> findByYesterdayPending(String status, LocalDateTime start, LocalDateTime end);

}
