package com.example.engineer_management.repository;

import com.example.engineer_management.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EngineerRepository extends JpaRepository<Engineer, String> {
    List<Engineer> findByRegion(String region);
    Engineer findByName(String name);
}
