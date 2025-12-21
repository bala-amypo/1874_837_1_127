package com.example.demo.service;

import com.example.demo.entity.Complaint;
import java.util.List;

public interface ComplaintService {

    Complaint createComplaint(Complaint complaint);

    List<Complaint> getAllComplaints();
}
