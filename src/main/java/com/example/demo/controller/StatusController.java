package com.example.demo.controller;

import com.example.demo.entity.ComplaintStatus;
import com.example.demo.entity.ComplaintStatusEntity;
import com.example.demo.service.ComplaintStatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final ComplaintStatusService service;

    public StatusController(ComplaintStatusService service) {
        this.service = service;
    }

    @PutMapping("/update/{complaintId}")
    public void updateStatus(@PathVariable Long complaintId,
                             @RequestParam ComplaintStatus status) {
        service.updateStatus(complaintId, status);
    }

    @GetMapping("/history/{complaintId}")
    public List<ComplaintStatusEntity> getHistory(@PathVariable Long complaintId) {
        return service.getStatusHistory(complaintId);
    }
}
