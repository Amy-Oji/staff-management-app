package com.week8.staffmanagementapp.springInitializer;

import com.week8.staffmanagementapp.Models.Staff;
import com.week8.staffmanagementapp.Repository.StaffRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AppInitializer implements ApplicationRunner {
    private StaffRepository staffRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
       Staff staff = new Staff(1L, "3456", "Amarachi", "Ojiakor", "amyojiakor@gmail.com","08066085859", "02-07-2000", "4444", "Female","Admin");
       staffRepository.save(staff);
    }
}