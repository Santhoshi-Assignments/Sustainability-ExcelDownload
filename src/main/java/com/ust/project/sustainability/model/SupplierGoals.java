package com.ust.project.sustainability.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "SupplierGoals")
public class SupplierGoals
{
    @Id
    private String id;
    private String supplierName;
    private String supplierId;
    private String pillarName;
    private ArrayList<GoalAnswers> goalAnswers;
    private String goalType;
    private boolean smartGoal;
    private String goalCreationYear;
    private String updatedDt;
    private String updatedUser;


}
