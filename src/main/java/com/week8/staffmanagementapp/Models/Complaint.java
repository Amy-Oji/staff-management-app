package com.week8.staffmanagementapp.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="cpmplaint")
public class Complaint {
    @Id
    private Long complaintId;
    @Column
    private String complainBody;

//    @ManyToOne
//    private Staff staff;

}
