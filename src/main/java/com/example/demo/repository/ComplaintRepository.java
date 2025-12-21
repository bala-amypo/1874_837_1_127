package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Query("SELECT c FROM Complaint c ORDER BY c.priorityScore DESC, c.submittedOn ASC")
    List<Complaint> findAllOrderByPriorityScoreDescCreatedAtAsc();
}
