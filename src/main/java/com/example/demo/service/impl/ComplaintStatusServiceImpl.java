package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintStatusServiceImpl implements ComplaintStatusService {

    private final ComplaintRepository complaintRepo;
    private final ComplaintStatusRepository statusRepo;

    public ComplaintStatusServiceImpl(ComplaintRepository complaintRepo,
                                      ComplaintStatusRepository statusRepo) {
        this.complaintRepo = complaintRepo;
        this.statusRepo = statusRepo;
    }

    @Override
    public void updateStatus(Long complaintId, ComplaintStatus status) {
        Complaint complaint = complaintRepo.findById(complaintId)
                .orElseThrow(() -> new RuntimeException("Complaint not found"));

        complaint.setStatus(status);
        complaintRepo.save(complaint);

        ComplaintStatusEntity history = new ComplaintStatusEntity();
        history.setComplaint(complaint);
        history.setStatus(status);
        statusRepo.save(history);
    }

    @Override
    public List<ComplaintStatusEntity> getStatusHistory(Long complaintId) {
        return statusRepo.findByComplaintId(complaintId);
    }
}
