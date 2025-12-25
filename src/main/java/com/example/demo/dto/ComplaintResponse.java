package com.example.demo.dto;

public class ComplaintResponse {
    private Long id;
    private String status;
    private Integer priorityScore;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getPriorityScore() { return priorityScore; }
    public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }
}
