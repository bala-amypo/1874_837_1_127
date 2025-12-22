package com.example.demo.service;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;

import java.util.List;

public interface ComplaintService {

    // CREATE
    Complaint submitComplaint(ComplaintRequest request, User customer);

    // READ
    List<Complaint> getComplaintsForUser(User customer);
    List<Complaint> getPrioritizedComplaints();
    Complaint getComplaintById(Long id);

    // UPDATE
    Complaint save(Complaint complaint);

    // DELETE
    void deleteComplaint(Long id);
}
