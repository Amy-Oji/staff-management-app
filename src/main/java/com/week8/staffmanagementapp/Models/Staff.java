package com.week8.staffmanagementapp.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="staff")
public class Staff{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "staff_Id", nullable = false, columnDefinition = "VARCHAR(20)")
    private String staffId;

    @Column (name = "first_name", nullable = false)
    private String firstName;

    @Column (name = "last_name", nullable = false)
    private String LastName;

    @Column (name = "email", nullable = false)
    private String email;

    @Column (name = "phone_no", nullable = false)
    private String phoneNumber;

    @Column (name = "dob", nullable = false)
    private String dob;

    @Column (name = "password", nullable = false)
    private String password;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name ="role", nullable = false)
    private String role;
}
