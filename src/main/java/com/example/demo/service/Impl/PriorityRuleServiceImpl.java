package com.example.demo.service.impl;

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
    public int calculatePriority(String category) {
        PriorityRule rule = repository.findByCategory(category);
        return rule != null ? rule.getBaseScore() : 0;
    }

    @Override
    public List<PriorityRule> getAllRules() {
        return repository.findAll();
    }
}
