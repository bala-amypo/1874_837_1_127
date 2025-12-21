package com.example.demo.dto;

import com.example.demo.entity.ComplaintStatus;

public class ComplaintResponse {

    private Long complaintId;
    private ComplaintStatus status;
    private Integer priorityScore;
    private String message;

    public ComplaintResponse(Long complaintId,
                             ComplaintStatus status,
                             Integer priorityScore,
                             String message) {
        this.complaintId = complaintId;
        this.status = status;
        this.priorityScore = priorityScore;
        this.message = message;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public ComplaintStatus getStatus() {
        return status;
    }

    public Integer getPriorityScore() {
        return priorityScore;
    }

    public String getMessage() {
        return message;
    }
}
