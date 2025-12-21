package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ComplaintStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Complaint complaint;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus status;

    private LocalDateTime updatedOn;

    @PrePersist
    public void onCreate() {
        updatedOn = LocalDateTime.now();
    }

    // ✅ REQUIRED SETTERS
    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public void setStatus(ComplaintStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }
}
