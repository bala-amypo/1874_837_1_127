package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        return "Login success for " + request.getEmail();
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request) {
        return "Registered user " + request.getEmail();
    }
}
