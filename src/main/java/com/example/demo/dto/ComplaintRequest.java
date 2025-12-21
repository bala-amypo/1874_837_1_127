package com.example.demo.dto;

import com.example.demo.entity.Severity;
import com.example.demo.entity.Urgency;

public class ComplaintRequest {

    public String title;
    public String description;
    public String category;
    public String channel;
    public Severity severity;
    public Urgency urgency;
}
