package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public int computePriorityScore(Complaint c) {

        int score = 0;

        if (c.getSeverity() != null) {
            switch (c.getSeverity()) {
                case LOW -> score += 1;
                case MEDIUM -> score += 3;
                case HIGH -> score += 5;
                case CRITICAL -> score += 8;
            }
        }

        if (c.getUrgency() != null) {
            switch (c.getUrgency()) {
                case LOW -> score += 1;
                case MEDIUM -> score += 3;
                case HIGH -> score += 5;
                case IMMEDIATE -> score += 8;
            }
        }

        List<PriorityRule> rules = priorityRuleRepository.findByActiveTrue();
        for (PriorityRule r : rules) {
            score += (r.getWeight() != null ? r.getWeight() : 0);
        }

        return Math.max(score, 0);
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }
}
