package com.ust.project.sustainability.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierGoalDTO {
    private String supplierName;
    private String supplierId;
    private String pillarName;
    private String questionId;
    private String goalDescription;
    private String goalType;
    private String smartGoal;
    private String goalCreationYear;
    private String updatedDt;
    private String updatedUser;
}
