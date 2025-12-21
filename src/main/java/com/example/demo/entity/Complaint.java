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
    private Integer priorityScore;
    private LocalDateTime submittedOn;

    @ManyToOne
    private User user;

    @PrePersist
    public void onCreate() {
        submittedOn = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public Integer getPriorityScore() { return priorityScore; }
    public LocalDateTime getSubmittedOn() { return submittedOn; }
    public User getUser() { return user; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }
    public void setUser(User user) { this.user = user; }
}
