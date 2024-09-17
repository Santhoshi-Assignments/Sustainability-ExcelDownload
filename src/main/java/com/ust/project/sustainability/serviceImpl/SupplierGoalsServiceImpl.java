package com.ust.project.sustainability.serviceImpl;

import com.ust.project.sustainability.dto.SupplierGoalDTO;
import com.ust.project.sustainability.exception.SupplierNotFoundException;
import com.ust.project.sustainability.model.*;
import com.ust.project.sustainability.repository.GoalConfigRepo;
import com.ust.project.sustainability.repository.SupplierGoalsRepo;
import com.ust.project.sustainability.service.SupplierGoalsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class SupplierGoalsServiceImpl implements SupplierGoalsService {

    @Autowired
    private SupplierGoalsRepo supplierGoalsRepo;

    @Autowired
    private GoalConfigRepo goalConfigRepo;
    @Override
    public List<SupplierGoals> getSupplierById(String supplierId) {
        List<SupplierGoals> supplierGoals = supplierGoalsRepo.findBySupplierId(supplierId);
        if (supplierGoals == null || supplierGoals.isEmpty()) {
            log.error("SupplierGoals with ID: {} not found", supplierId);
            throw new SupplierNotFoundException(supplierId);
        }
        log.info("SupplierGoals with ID: {} found", supplierId);
        return supplierGoals;
    }

    public Map<String, String> getSupplierGoalPlaceholders(String supplierId) {
        List<SupplierGoals> supplierGoals = getSupplierById(supplierId);
        Map<String, String> placeholders = new HashMap<>();

        for (SupplierGoals goal : supplierGoals) {
            for (GoalAnswers answer : goal.getGoalAnswers()) {
                for (Response response : answer.getResponse()) {
                    placeholders.put("<" + response.getFieldId() + ">", response.getValue());
                }
            }
        }

        return placeholders;
    }

    @Override
    public List<SupplierGoalDTO> getMappedSupplierGoals(String supplierId) {

        List<SupplierGoals> supplierGoalsList = supplierGoalsRepo.findBySupplierId(supplierId);


        List<GoalConfig> goalConfigs = goalConfigRepo.findBySupplierId(supplierId);


        List<SupplierGoalDTO> mappedSupplierGoals = new ArrayList<>();


        for (SupplierGoals supplierGoals : supplierGoalsList) {

            GoalConfig matchingGoalConfig = goalConfigs.stream()
                    .filter(config -> config.getPillarName().equals(supplierGoals.getPillarName()))
                    .findFirst()
                    .orElse(null);

            if (matchingGoalConfig != null) {

                for (Question question : matchingGoalConfig.getQuestions()) {

                    SupplierGoalDTO dto = new SupplierGoalDTO();
                    dto.setSupplierName(supplierGoals.getSupplierName());
                    dto.setSupplierId(supplierGoals.getSupplierId());
                    dto.setPillarName(supplierGoals.getPillarName());
                    dto.setQuestionId(question.getQuestionId());


                    String goalDescription = replacePlaceholders(question.getText(), supplierGoals);
                    dto.setGoalDescription(goalDescription);


                    dto.setGoalType(supplierGoals.getGoalType());
                    dto.setSmartGoal(supplierGoals.isSmartGoal() ? "Yes" : "No");
                    dto.setGoalCreationYear(supplierGoals.getGoalCreationYear());
                    dto.setUpdatedDt(supplierGoals.getUpdatedDt());
                    dto.setUpdatedUser(supplierGoals.getUpdatedUser());

                    mappedSupplierGoals.add(dto);
                }
            }
        }

        return mappedSupplierGoals;
    }

    private String replacePlaceholders(String questionText, SupplierGoals supplierGoals) {
        for (GoalAnswers goalAnswer : supplierGoals.getGoalAnswers()) {
            for (Response response : goalAnswer.getResponse()) {
                questionText = questionText.replace("<" + response.getFieldId() + ">", "\"" + response.getValue() + "\"");
            }
        }
        return questionText;
    }

}
