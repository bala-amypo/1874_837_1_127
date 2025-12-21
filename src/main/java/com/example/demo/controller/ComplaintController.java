package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService service;
    private final UserService userService;

    public ComplaintController(ComplaintService service,
                               UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping("/submit")
    public Complaint submit(@RequestBody ComplaintRequest req,
                            @RequestParam String email) {
        User user = userService.findByEmail(email);
        return service.submitComplaint(req, user);
    }

    @GetMapping("/user/{email}")
    public List<Complaint> userComplaints(@PathVariable String email) {
        return service.getComplaintsForUser(
                userService.findByEmail(email)
        );
    }

    @GetMapping("/prioritized")
    public List<Complaint> prioritized() {
        return service.getPrioritizedComplaints();
    }
}
    