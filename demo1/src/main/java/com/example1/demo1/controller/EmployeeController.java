package com.example1.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//annotations
import org.springframework.web.bind.annotation.RestController;

//components
import com.example1.demo1.model.Company;
import com.example1.demo1.model.EmployeeDetails;
import com.example1.demo1.model.EmployeeProfile;
import com.example1.demo1.services.CompanyService;
import com.example1.demo1.services.EmployeeService;
import com.example1.demo1.services.ProfileService;



@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProfileService profileService;






    @PostMapping("/addemp")
    public ResponseEntity<EmployeeDetails> addEmp(@RequestBody EmployeeDetails employeeDetails) {  

        EmployeeDetails emp = employeeService.savEmp(employeeDetails);
        if(emp!=null){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @GetMapping("/emplist")
    public List<EmployeeDetails> empList() {
        return employeeService.getAllEmp();
    }
    
    
    @GetMapping("/search/{empName}")
    public List<EmployeeDetails> searchEmp(@PathVariable String empName) {
        return employeeService.getEmpByName(empName);
    }
    
    @PutMapping("/editemp/{id}")
    public EmployeeDetails editEmp(@PathVariable Long id, @RequestBody EmployeeDetails employeeDetails) {
       return employeeService.updateEmp(id,employeeDetails); 
     }
   

    @DeleteMapping("/delete/{empName}")
        public void delEmp(@PathVariable String empName){
             employeeService.delEmpByName(empName);
        }

     //Pagination & sorting
     @GetMapping("/emplist/{offset}/{pagesize}/{field}")
        public ResponseEntity<Page<EmployeeDetails>> getpageSortEmployeee(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field) {
            Page<EmployeeDetails> sort=employeeService.pageSortEmployee(offset,pagesize,field);
            if(sort!=null){
                return new ResponseEntity<>(sort,HttpStatus.OK);
            }
            return new ResponseEntity<>(sort,HttpStatus.NOT_FOUND);
      }    

      //company
      @PostMapping("/company")
      public Company postCompany(@RequestBody Company company){
          return companyService.savCom(company);
      }
      
      @GetMapping("/comlist")
      public List<Company> getCompany(){
          return companyService.getCom();
      }
      
      //profile
      @PostMapping("/profile")
      public EmployeeProfile postPro(@RequestBody EmployeeProfile employeeProfile){
          return profileService.savPro(employeeProfile);
      }
      
      @GetMapping("/prolist")
      public List<EmployeeProfile> getPro(){
          return profileService.getPro();
      }

          
     
}