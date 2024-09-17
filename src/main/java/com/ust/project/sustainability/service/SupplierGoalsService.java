package com.ust.project.sustainability.service;


import com.ust.project.sustainability.dto.SupplierGoalDTO;
import com.ust.project.sustainability.model.SupplierGoals;

import java.util.List;
import java.util.Map;

public interface SupplierGoalsService {

    List<SupplierGoals> getSupplierById(String supplierId);

    Map<String, String> getSupplierGoalPlaceholders(String supplierId);

    List<SupplierGoalDTO> getMappedSupplierGoals(String supplierId);


}
