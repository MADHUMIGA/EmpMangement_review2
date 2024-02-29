package com.example1.demo1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example1.demo1.model.Company;
import com.example1.demo1.repository.CompanyRepository;

@Service
public class CompanyService {


    @Autowired
    private CompanyRepository companyRepository;
    //  public CompanyService(CompanyRepository companyRepository) {
    //        this.companyRepository = companyRepository;
    //      }


         //company
    public Company savCom(Company company){
        return companyRepository.save(company);
    }

    public List<Company> getCom(){
        return companyRepository.findAll();
    }
}
