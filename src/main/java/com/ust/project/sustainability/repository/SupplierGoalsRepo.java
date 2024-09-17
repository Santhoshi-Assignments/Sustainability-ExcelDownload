package com.ust.project.sustainability.repository;

import com.ust.project.sustainability.model.SupplierGoals;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SupplierGoalsRepo extends MongoRepository<SupplierGoals, String> {
    List<SupplierGoals> findBySupplierId(String supplierId);


}
