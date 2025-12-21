package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService,
                               UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody ComplaintRequest request,
                                     @RequestParam String email) {
        User user = userService.findByEmail(email);
        return complaintService.submitComplaint(request, user);
    }

    @GetMapping("/prioritized")
    public List<Complaint> getPrioritized() {
        return complaintService.getPrioritizedComplaints();
    }
}
