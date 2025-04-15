package com.springlearn.webapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springlearn.webapp.model.School;
import com.springlearn.webapp.service.SchoolService;
import io.micrometer.common.lang.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController // kết hợp @Controller (Trong MVC , thường trả về view ) & @ResponseBody (JSON/XML)
@RequiredArgsConstructor
@RequestMapping("/schools")
public class SchoolController {
    @NonNull
    private final SchoolService schoolService;

    //Get All
    @GetMapping
    public List<School> getAllSchools() {
        return this.schoolService.getAllSchool();
    }
    // @RequestMapping( value = "/create",method = RequestMethod.POST) Trên và dưới là tương đương nhau
    @PostMapping("/create")
    public void createSchool(@RequestBody School school) {
        this.schoolService.createSchool(school);
    }
    //find
    @GetMapping("/find")
    public School findSchoolById(@RequestParam(name = "id",required = true ) Long id) {
        return this.schoolService.getSchoolById(id);
    }
    //update
    @PutMapping("/update")
    public void updateSchoolById(@RequestParam(name = "id", required = true) Long id, @RequestBody School school) {
        this.schoolService.updateSchool(school);
    }
    //delete
    @DeleteMapping("/delete")
    public void deleteSchoolById(@RequestParam(name = "id" ,required = true) Long id){
        this.schoolService.deleteSchool(id);
    }
    
    
    // @GetMapping("/{id}")
    // public School getSchoolById(@PathVariable  Long id) {
    //     return schoolService.getSchoolById(id);
    // }
    // //Update 
    // @GetMapping("/{id}")
    // public void updateSchool(@RequestBody School school) {
    //     this.schoolService.updateSchool(school);
    // }
    
}
