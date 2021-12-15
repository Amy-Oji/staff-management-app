package com.week8.staffmanagementapp.dto;

import com.week8.staffmanagementapp.Models.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDTO {
    private String oldPassword;
    private String newPassword;
}
