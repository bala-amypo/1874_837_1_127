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
    public int computePriorityScore(Complaint complaint) {

        int score = 0;

        // Severity contribution
        if (complaint.getSeverity() != null) {
            switch (complaint.getSeverity()) {
                case LOW -> score += 1;
                case MEDIUM -> score += 2;
                case HIGH -> score += 3;
                case CRITICAL -> score += 4;
            }
        }

        // Urgency contribution
        if (complaint.getUrgency() != null) {
            switch (complaint.getUrgency()) {
                case LOW -> score += 1;
                case MEDIUM -> score += 2;
                case HIGH -> score += 3;
                case IMMEDIATE -> score += 4;
            }
        }

        // Rule weights
        List<PriorityRule> rules = priorityRuleRepository.findByActiveTrue();
        for (PriorityRule rule : rules) {
            score += rule.getWeight();
            complaint.getPriorityRules().add(rule);
        }

        return score;
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }
}
