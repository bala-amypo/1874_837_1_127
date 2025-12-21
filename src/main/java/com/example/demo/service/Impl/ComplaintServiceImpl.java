package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final PriorityRuleService priorityRuleService;
    private final UserService userService;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository,
                                PriorityRuleService priorityRuleService,
                                UserService userService) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
        this.userService = userService;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest request) {
        User user = userService.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Complaint c = new Complaint();
        c.setTitle(request.getTitle());
        c.setDescription(request.getDescription());
        c.setCategory(request.getCategory());
        c.setPriorityScore(priorityRuleService.calculatePriority(request.getCategory()));
        c.setUser(user);

        return complaintRepository.save(c);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }
}
