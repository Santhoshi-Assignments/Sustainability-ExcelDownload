package com.ust.project.sustainability.controller;
import com.ust.project.sustainability.model.GoalConfig;
import com.ust.project.sustainability.service.GoalConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/goal-config")
public class GoalConfigController {

    @Autowired
    private GoalConfigService goalConfigService;

    @GetMapping("/goals")
    public List<GoalConfig> getAllGoalConfigs() {
        return goalConfigService.getAllGoalConfigs();
    }
}
