package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByCustomer(User customer);

    @Query("SELECT c FROM Complaint c ORDER BY c.priorityScore DESC, c.createdAt ASC")
    List<Complaint> findAllOrderByPriorityScoreDescCreatedAtAsc();
}
