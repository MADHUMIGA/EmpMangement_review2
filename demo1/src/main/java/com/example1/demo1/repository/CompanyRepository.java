package com.example1.demo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example1.demo1.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    
}
