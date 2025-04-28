package com.springlearn.webapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    // @CacheEvict(value = "schools", key = "'allSchools'")
    // @CachePut(value = "schools", key = "#id")
    public School createSchool(@NonNull School school) {
        School result = this.schoolRepository.save(school);
        return result;
    }
    //Read 
    // @Cacheable(value = "schools" , key = "'allSchools'")
    public List<SchoolDTO> getAllSchool() {
        return this.schoolRepository.findAll()
            .stream()
            .map(iSchoolMapper :: toDTO)
            .collect(Collectors.toList());
    }
    //Update 
    // @CachePut(value = "schools", key = "#id" )
    public SchoolDTO updateSchool(@NonNull Long id,@NonNull SchoolDTO schoolDTO) {
        if(id == null){
            throw new IllegalArgumentException("School ID must not be null");
        }
        School school = schoolRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("School not found"));
        School updatedSchool = iSchoolMapper.toEntity(schoolDTO, school);
        updatedSchool.setId(id);
        return iSchoolMapper.toDTO(this.schoolRepository.save(updatedSchool));
    }
    //Delete 
    // @CacheEvict(value = "schools", key = "'#id'")
    public void deleteSchool(@NonNull Long id) {
        this.schoolRepository.deleteById(id);
    }
    //Get School By Id
    // @Cacheable(value = "schools", key = "'#id'")
    public School getSchoolById(@NonNull Long id){
        return this.schoolRepository.findById(id).orElse(null);
    }

}
