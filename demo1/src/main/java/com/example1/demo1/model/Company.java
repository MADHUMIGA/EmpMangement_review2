package com.example1.demo1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comId;
    private String comName;
    private String address;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EmployeeDetails> employeeDetails;
}
