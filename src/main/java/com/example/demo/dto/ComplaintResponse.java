package com.example.demo.dto;

public class ComplaintResponse {

    private Long complaintId;
    private String status;
    private Integer priorityScore;

    public ComplaintResponse(Long complaintId, String status, Integer priorityScore) {
        this.complaintId = complaintId;
        this.status = status;
        this.priorityScore = priorityScore;
    }

    public Long getComplaintId() { return complaintId; }
    public String getStatus() { return status; }
    public Integer getPriorityScore() { return priorityScore; }
}
