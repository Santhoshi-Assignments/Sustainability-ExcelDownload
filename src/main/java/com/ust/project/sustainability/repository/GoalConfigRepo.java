package com.ust.project.sustainability.repository;

import com.ust.project.sustainability.model.GoalConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface GoalConfigRepo extends MongoRepository<GoalConfig, String> {
    List<GoalConfig> findBySupplierId(String supplierId);
}
