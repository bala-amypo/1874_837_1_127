package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private UserService userService;

    @PostMapping("/submit/{userId}")
    public ResponseEntity<Complaint> submitComplaint(
            @PathVariable Long userId,
            @RequestBody ComplaintRequest request
    ) {
        User user = userService.findById(userId);
        Complaint complaint = complaintService.submitComplaint(request, user);
        return ResponseEntity.ok(complaint);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> getUserComplaints(@PathVariable Long userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok(complaintService.getComplaintsForUser(user));
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        return ResponseEntity.ok(complaintService.getPrioritizedComplaints());
    }
}
