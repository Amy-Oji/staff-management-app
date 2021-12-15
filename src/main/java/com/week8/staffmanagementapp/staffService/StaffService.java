package com.week8.staffmanagementapp.staffService;

import com.week8.staffmanagementapp.Models.Staff;
import com.week8.staffmanagementapp.dto.PasswordDTO;

import java.util.List;

public interface StaffService {

    List<Staff> getAllStaff();
    void addStaff(Staff staff);
    Staff getStaffById(long id);
    void deleteStaffById(long id);
    Staff getStaffByEmail(String email);
    Staff getStaffByEmailAndPassword(String email, String password);
    Staff getStaffByStaffId(String id);
    void changePassword(Staff loggerUser, PasswordDTO passwordDTO);


}
