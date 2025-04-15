package com.springlearn.webapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlearn.webapp.dto.ClassDTO;
import com.springlearn.webapp.model.Classies;
import com.springlearn.webapp.service.ClassService;
import com.springlearn.webapp.service.SchoolService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequiredArgsConstructor  //Lombok sẽ tạo constructor với các trường final hoặc @NonNull
@RequestMapping("/class")
public class ClassController {
    @NonNull
    private final ClassService classService;
    @NonNull
    private final SchoolService schoolService;

    //Get All 
    @GetMapping()
    public List<Classies> getClassies() {
        return classService.getAllClass();
    }
    //Create 
    @PostMapping("/create")
    public void createClass(@RequestBody ClassDTO classDTO) {
        this.classService.createClass(classDTO);
    }
    //Find 
    @GetMapping("/find")
    public Classies findClassById(@RequestParam (name = "id", required = true) Long id) {
        return classService.getClassById(id);
    }
    //Update
    @PutMapping("/update")
    public void updateClass(@RequestParam(name = "id", required = true) Long id,@RequestBody Classies classies) {
        classService.updateClass(classies);
    }
    //Delete
    @DeleteMapping("/delete")
    public void deleteClass(@RequestParam(name = "id", required = true) Long id) {
        classService.deleteClass(id);
    }


    // // API để xóa cache
    // @PostMapping("/clear-cache")
    // public String clearCache() {
    //     classService.clearCache();
    //     return "Cache cleared!";
    // }
}
