package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    // POST – body parameters will show
    @PostMapping("/submit")
    public String submitComplaint(@RequestBody ComplaintRequest request) {
        return "Complaint submitted: " + request.getTitle();
    }

    // GET – path variable will show
    @GetMapping("/user/{userId}")
    public String getUserComplaints(@PathVariable Long userId) {
        return "Complaints for user " + userId;
    }

    // GET – no input (still fine)
    @GetMapping("/prioritized")
    public String getPrioritizedComplaints() {
        return "Prioritized complaints list";
    }
}
