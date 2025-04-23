package com.springlearn.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springlearn.webapp.domain.dto.SchoolDTO;
import com.springlearn.webapp.domain.mapper.ISchoolMapper;
import com.springlearn.webapp.domain.model.School;
import com.springlearn.webapp.reponsitory.SchoolReponsitory;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class SchoolService {
    private final SchoolReponsitory schoolRepository;
    private final ISchoolMapper iSchoolMapper;
    //Create 
    public SchoolDTO createSchool(@NonNull School school) {
        School result = this.schoolRepository.save(school);
        return iSchoolMapper.toDTO(result);
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
