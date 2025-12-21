package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    private final PriorityRuleRepository repo;

    public PriorityRuleController(PriorityRuleRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<PriorityRule> getAllRules() {
        return repo.findAll();
    }
}
