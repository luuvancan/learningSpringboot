package com.springlearn.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springlearn.webapp.model.School;
import com.springlearn.webapp.reponsitory.SchoolReponsitory;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class SchoolService {
    @NonNull
    private final SchoolReponsitory schoolRepository;
    //Create 
    public void createSchool(@NonNull School school) {
        this.schoolRepository.save(school);
    }
    //Read 
    public List<School> getAllSchool() {
        return this.schoolRepository.findAll();
    }
    //Update 
    public void updateSchool(@NonNull School school) {
        this.schoolRepository.save(school);
    }
    //Delete 
    public void deleteSchool(@NonNull Long id) {
        this.schoolRepository.deleteById(id);
    }
    //Get School By Id
    public School getSchoolById(@NonNull Long id){
        return this.schoolRepository.findById(id).orElse(null);
    }

}
