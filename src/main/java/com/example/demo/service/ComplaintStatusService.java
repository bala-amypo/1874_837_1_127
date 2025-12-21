package com.example.demo.service;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.entity.ComplaintStatusEntity;
import java.util.List;

public interface ComplaintStatusService {

    void updateStatus(Long complaintId, ComplaintStatus status);

    List<ComplaintStatusEntity> getStatusHistory(Long complaintId);
}
