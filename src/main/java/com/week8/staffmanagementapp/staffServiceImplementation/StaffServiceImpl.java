package com.week8.staffmanagementapp.staffServiceImplementation;

import com.week8.staffmanagementapp.Models.Staff;
import com.week8.staffmanagementapp.Repository.StaffRepository;
import com.week8.staffmanagementapp.dto.PasswordDTO;
import com.week8.staffmanagementapp.staffService.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StaffServiceImpl implements StaffService {
 private StaffRepository staffRepository;
@Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staff = staffRepository.findAll();
        System.err.println(staff);
        return staff;

    }

    @Override
    public void addStaff(Staff staff) {
    staffRepository.save(staff);
    }

    @Override
    public Staff getStaffById(long id) {
        Optional<Staff> optional = staffRepository.findById(id);
        Staff staff = null;
        if(optional.isPresent()){
            staff = optional.get();
        }else{
            throw new RuntimeException(" Staff not found for id :: " + id);
        }
        return staff;
    }

    @Override
    public void deleteStaffById(long id) {
        this.staffRepository.deleteById(id);
    }

    @Override
    public Staff getStaffByEmail(String email) {
        return staffRepository.getStaffByEmail(email);

    }

    @Override
    public Staff getStaffByEmailAndPassword(String email, String password) {
                return staffRepository.getStaffByEmailAndPassword(email, password);

    }

    @Override
    public Staff getStaffByStaffId(String id) {

        return staffRepository.findByStaffId(id);
    }

    @Override
    public void changePassword(Staff loggerUser, PasswordDTO passwordDTO) {
        if (loggerUser.getPassword().equals(passwordDTO.getOldPassword())) {

            Staff staff = staffRepository.getStaffByEmailAndPassword(loggerUser.getEmail(),
                    loggerUser.getPassword());

            staff.setId(staff.getId());
            staff.setPassword(passwordDTO.getNewPassword());

            staffRepository.save(staff);
        }
    }

}
