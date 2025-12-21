package com.example.demo.service;

import com.example.demo.entity.Complaint;

public interface PriorityRuleService {

    int computePriorityScore(Complaint complaint);
}
