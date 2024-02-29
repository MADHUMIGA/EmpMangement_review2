package com.example1.demo1.services;

import java.util.List;

//components
import com.example1.demo1.model.EmployeeDetails;
import com.example1.demo1.repository.EmployeeRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
//annotation
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
   
    

    //post
    public EmployeeDetails savEmp(EmployeeDetails employeeDetails){
            return employeeRepository.save(employeeDetails);
    }

    //retrive
    public List<EmployeeDetails> getAllEmp(){
        return employeeRepository.findAll();
    }

    //searchByName
    public List<EmployeeDetails> getEmpByName(String empName){
      return employeeRepository.findByempName(empName);
    }
    

    //updateDetails
    public EmployeeDetails updateEmp(Long id,EmployeeDetails employeeDetails){
        return employeeRepository.save(employeeDetails);
    }
    
    //deleteDetailsByName
    public void delEmpByName(String empName){
     employeeRepository.delByempName(empName);

    }

   //pagination&sorting
   public Page<EmployeeDetails> pageSortEmployee(int offset,int pagesize,String field){
        PageRequest pageRequest=PageRequest.of(offset, pagesize , Sort.by(field));
        return employeeRepository.findAll(pageRequest);
    }


    
   

}