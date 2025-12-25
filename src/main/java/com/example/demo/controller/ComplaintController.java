package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @GetMapping("/test")
    public String test() {
        return "OK";
    }
}
