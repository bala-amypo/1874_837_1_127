package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.*;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository repository;
    private final PriorityRuleService priorityRuleService;

    public ComplaintServiceImpl(ComplaintRepository repository,
                                PriorityRuleService priorityRuleService) {
        this.repository = repository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest request, User customer) {
        Complaint complaint = new Complaint();
        complaint.setTitle(request.title);
        complaint.setDescription(request.description);
        complaint.setCategory(request.category);
        complaint.setChannel(request.channel);
        complaint.setSeverity(request.severity);
        complaint.setUrgency(request.urgency);
        complaint.setCustomer(customer);

        complaint.setPriorityScore(priorityRuleService.computePriorityScore(complaint));
        return repository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User customer) {
        return repository.findByCustomer(customer);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return repository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }
}
