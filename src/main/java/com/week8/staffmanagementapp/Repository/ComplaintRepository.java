package com.week8.staffmanagementapp.Repository;

import com.week8.staffmanagementapp.Models.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint,Long> {

}
