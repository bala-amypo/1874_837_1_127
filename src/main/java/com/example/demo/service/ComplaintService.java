package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.dto.ComplaintRequest;

import java.util.List;

public interface ComplaintService {

    Complaint submitComplaint(ComplaintRequest request);

    List<Complaint> getPrioritizedComplaints();

    List<Complaint> getAllComplaints();
}
