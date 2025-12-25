package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    @Autowired
    private PriorityRuleService priorityRuleService;

    @GetMapping("/active")
    public ResponseEntity<List<PriorityRule>> getActiveRules() {
        return ResponseEntity.ok(priorityRuleService.getActiveRules());
    }
}
