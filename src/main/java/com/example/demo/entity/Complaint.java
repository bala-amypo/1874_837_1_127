package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private String channel;

    private Integer priorityScore;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    public enum Status {
        NEW, OPEN, IN_PROGRESS, RESOLVED
    }

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH, IMMEDIATE
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = Status.NEW;
    }

    // getters & setters
    public Long getId() { return id; }
    public Integer getPriorityScore() { return priorityScore; }
    public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }
    public void setCustomer(User customer) { this.customer = customer; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setChannel(String channel) { this.channel = channel; }
    public void setSeverity(Severity severity) { this.severity = severity; }
    public void setUrgency(Urgency urgency) { this.urgency = urgency; }
}
