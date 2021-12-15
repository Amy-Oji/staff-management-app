package com.week8.staffmanagementapp.Repository;

import com.week8.staffmanagementapp.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff getStaffByEmail(String email);
    Staff getStaffByEmailAndPassword(String email, String password);
    Staff findByStaffId(String id);

}
