package com.ust.project.sustainability.controller;

import com.ust.project.sustainability.dto.SupplierGoalDTO;
import com.ust.project.sustainability.model.SupplierGoals;
import com.ust.project.sustainability.service.GoalConfigService;
import com.ust.project.sustainability.service.SupplierGoalsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/sustainability")
public class SupplierGoalsController {

    @Autowired
    private GoalConfigService goalConfigService;

    @Autowired
    private SupplierGoalsService supplierGoalsService;

    @GetMapping("/{supplierId}")
    public ResponseEntity<List<SupplierGoals>> getSupplierGoalsById(@PathVariable String supplierId) {
        log.info("Request received to get SupplierGoals with ID: {}", supplierId);
        List<SupplierGoals> supplierGoals = supplierGoalsService.getSupplierById(supplierId);
        return new ResponseEntity<>(supplierGoals, HttpStatus.OK);
    }

    @GetMapping("/mapped-supplier-goals/{supplierId}")
    public ResponseEntity<List<SupplierGoalDTO>> getMappedSupplierGoals(@PathVariable String supplierId) {
        List<SupplierGoalDTO> mappedSupplierGoals = supplierGoalsService.getMappedSupplierGoals(supplierId);
        return new ResponseEntity<>(mappedSupplierGoals, HttpStatus.OK);
    }


}

