package com.example1.demo1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example1.demo1.model.EmployeeProfile;
import com.example1.demo1.repository.ProfileRepository;

@Service
public class ProfileService {
    
     @Autowired
    private ProfileRepository profileRepository;
    
    //  public ProfileService(ProfileRepository profileRepository) {
    //     this.profileRepository = profileRepository;
    // }

    //profile
    public EmployeeProfile savPro(EmployeeProfile employeeProfile){
        return profileRepository.save(employeeProfile);
    }

    public List<EmployeeProfile> getPro(){
        return profileRepository.findAll();
    }
}
