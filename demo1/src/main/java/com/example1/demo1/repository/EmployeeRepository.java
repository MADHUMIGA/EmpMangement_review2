package com.example1.demo1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example1.demo1.model.EmployeeDetails;



public interface EmployeeRepository extends JpaRepository <EmployeeDetails,Integer>{
    
     @Query("SELECT e FROM EmployeeDetails e WHERE e.empName = ?1")
    List<EmployeeDetails> findByempName(String empName);
    

    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeDetails e WHERE e.empName = ?1")
    void delByempName(String empName);
}