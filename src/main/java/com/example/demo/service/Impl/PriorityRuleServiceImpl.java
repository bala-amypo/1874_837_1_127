package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository repository;

    public PriorityRuleServiceImpl(PriorityRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {
        int score = 0;

        switch (complaint.getSeverity()) {
            case CRITICAL -> score += 50;
            case HIGH -> score += 30;
            case MEDIUM -> score += 20;
            case LOW -> score += 10;
        }

        switch (complaint.getUrgency()) {
            case IMMEDIATE -> score += 40;
            case HIGH -> score += 25;
            case MEDIUM -> score += 15;
            case LOW -> score += 5;
        }

        for (PriorityRule rule : repository.findByActiveTrue()) {
            score += rule.getWeight();
        }

        return score;
    }
}
