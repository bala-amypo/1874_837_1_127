package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public ComplaintController(ComplaintService complaintService,
                               UserService userService,
                               JwtUtil jwtUtil) {
        this.complaintService = complaintService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/submit")
    public ResponseEntity<ComplaintResponse> submitComplaint(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody ComplaintRequest request) {

        String token = authHeader.replace("Bearer ", "");
        String email = jwtUtil.extractEmail(token);

        User user = userService.findByEmail(email);
        Complaint complaint = complaintService.submitComplaint(request, user);

        ComplaintResponse response = new ComplaintResponse(
                complaint.getId(),
                complaint.getStatus().name(),
                complaint.getPriorityScore(),
                "Complaint submitted successfully"
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> getComplaintsForUser(
            @PathVariable Long userId) {

        User user = userService.findById(userId);
        return ResponseEntity.ok(
                complaintService.getComplaintsForUser(user)
        );
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        return ResponseEntity.ok(
                complaintService.getPrioritizedComplaints()
        );
    }
}
