package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    // Query parameter example
    @GetMapping("/by-weight")
    public String getByWeight(@RequestParam int weight) {
        return "Rules with weight " + weight;
    }

    // Simple GET
    @GetMapping("/all")
    public String getAllRules() {
        return "All priority rules";
    }
}
