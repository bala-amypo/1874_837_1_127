package com.example.demo.dto;

import com.example.demo.entity.Complaint;

public class ComplaintRequest {

    private String title;
    private String description;
    private String category;
    private String channel;
    private Complaint.Severity severity;
    private Complaint.Urgency urgency;

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getChannel() { return channel; }
    public Complaint.Severity getSeverity() { return severity; }
    public Complaint.Urgency getUrgency() { return urgency; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setChannel(String channel) { this.channel = channel; }
    public void setSeverity(Complaint.Severity severity) { this.severity = severity; }
    public void setUrgency(Complaint.Urgency urgency) { this.urgency = urgency; }
}
