package com.example.outage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.outage.model.OutageModel;

public interface OutageRepository extends JpaRepository<OutageModel,String>{

}
