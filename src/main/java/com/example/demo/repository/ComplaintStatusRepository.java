package com.example.demo.repository;

import com.example.demo.entity.ComplaintStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplaintStatusRepository
        extends JpaRepository<ComplaintStatusEntity, Long> {

    List<ComplaintStatusEntity> findByComplaintId(Long complaintId);
}
