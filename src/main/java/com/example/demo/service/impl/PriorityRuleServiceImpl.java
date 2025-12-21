package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository repository;

    public PriorityRuleServiceImpl(PriorityRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {
        int score = 0;

        if (complaint.getSeverity() != null) {
            score += complaint.getSeverity().ordinal() * 10;
        }
        if (complaint.getUrgency() != null) {
            score += complaint.getUrgency().ordinal() * 5;
        }

        for (PriorityRule rule : repository.findByActiveTrue()) {
            score += rule.getWeight();
        }
        return Math.max(score, 0);
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return repository.findByActiveTrue();
    }
}
