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

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService,
                               UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    // ==========================
    // POST → CREATE COMPLAINT
    // ==========================
    @PostMapping("/submit")
    public Complaint submitComplaint(
            @RequestBody ComplaintRequest request,
            @RequestParam String email) {

        User user = userService.findByEmail(email);
        return complaintService.submitComplaint(request, user);
    }

    // ==========================
    // GET → USER COMPLAINTS
    // ==========================
    @GetMapping("/user/{email}")
    public List<Complaint> getUserComplaints(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return complaintService.getComplaintsForUser(user);
    }

    // ==========================
    // GET → PRIORITIZED COMPLAINTS
    // ==========================
    @GetMapping("/prioritized")
    public List<Complaint> getPrioritizedComplaints() {
        return complaintService.getPrioritizedComplaints();
    }

    // ==========================
    // PUT → UPDATE STATUS
    // ==========================
    @PutMapping("/status/{id}")
    public Complaint updateStatus(
            @PathVariable Long id,
            @RequestParam Complaint.Status status) {

        Complaint complaint = complaintService.getComplaintById(id);
        complaint.setStatus(status);
        return complaintService.save(complaint);
    }

    // ==========================
    // DELETE → DELETE COMPLAINT
    // ==========================
    @DeleteMapping("/{id}")
    public String deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
        return "Complaint deleted successfully";
    }
}
