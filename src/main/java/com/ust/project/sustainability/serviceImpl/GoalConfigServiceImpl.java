package com.ust.project.sustainability.serviceImpl;
import com.ust.project.sustainability.model.GoalConfig;
import com.ust.project.sustainability.repository.GoalConfigRepo;
import com.ust.project.sustainability.service.GoalConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalConfigServiceImpl implements GoalConfigService {

    @Autowired
    private GoalConfigRepo goalConfigRepo;

    @Override
    public List<GoalConfig> getAllGoalConfigs() {
        return goalConfigRepo.findAll();
    }

}