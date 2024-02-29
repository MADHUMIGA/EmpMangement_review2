package com.example1.demo1.model;


import com.fasterxml.jackson.annotation.JsonBackReference;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String empDept;
    private String empGmail;
    private int empSalary;
    
    @JsonBackReference
    @ManyToOne
    private Company company;
   

    
    
}
