package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private ComplaintStatus status = ComplaintStatus.NEW;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    @ManyToMany
    private List<PriorityRule> priorityRules;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // ✅ REQUIRED SETTERS
    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public Long getId() {
        return id;
    }
}
