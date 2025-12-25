package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;

    // 👉 Spring Boot uses this constructor
    public ComplaintServiceImpl(ComplaintRepository complaintRepository,
                                PriorityRuleService priorityRuleService) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    // 👉 Testcases use THIS constructor (kept for compatibility)
    public ComplaintServiceImpl(
            ComplaintRepository complaintRepository,
            Object unused1,
            Object unused2,
            PriorityRuleService priorityRuleService
    ) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest req, User customer) {
        Complaint c = new Complaint();
        c.setTitle(req.getTitle());
        c.setDescription(req.getDescription());
        c.setCategory(req.getCategory());
        c.setChannel(req.getChannel());
        c.setSeverity(req.getSeverity());
        c.setUrgency(req.getUrgency());
        c.setCustomer(customer);

        int score = priorityRuleService.computePriorityScore(c);
        c.setPriorityScore(score);

        return complaintRepository.save(c);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User customer) {
        return complaintRepository.findByCustomer(customer);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }
}
