package com.springlearn.webapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springlearn.webapp.dto.ClassDTO;
import com.springlearn.webapp.model.Classies;
import com.springlearn.webapp.service.ClassService;
import com.springlearn.webapp.service.SchoolService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor  //Lombok sẽ tạo constructor với các trường final hoặc @NonNull
@RequestMapping("/class")
public class ClassController {
    private final ClassService classService;
    private final SchoolService schoolService;

    //Get All 
    @GetMapping()
    public List<Classies> getClassies() {
        return classService.getAllClass();
    }
    //Create 
    @PostMapping("/create")
    public ClassDTO createClass(@RequestBody ClassDTO classDTO) {
        return this.classService.createClass(classDTO);
    }
    //Find 
    @GetMapping("/find/{id}")
    public Classies findClassById(@PathVariable("id") Long id) {
        return classService.getClassById(id);
    }
    //Update
    @PutMapping("/update")
    public void updateClass(@RequestParam(name = "id", required = true) Long id,@RequestBody Classies classies) {
        classService.updateClass(classies);
    }
    //Delete
    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable("id") Long id) {
        classService.deleteClass(id);
    }


    // // API để xóa cache
    // @PostMapping("/clear-cache")
    // public String clearCache() {
    //     classService.clearCache();
    //     return "Cache cleared!";
    // }
}
