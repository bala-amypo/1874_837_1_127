package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
