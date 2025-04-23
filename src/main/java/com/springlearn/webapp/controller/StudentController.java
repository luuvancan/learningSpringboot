package com.springlearn.webapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springlearn.webapp.dto.StudentDTO;
import com.springlearn.webapp.model.Student;
import com.springlearn.webapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    // Dung @NonNull hoặc là Final
    private final StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }
    @PostMapping("/create")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return this.studentService.createStudent(studentDTO);
    }
    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable("id") Long id) {
        return this.studentService.getStudentById(id);
    }
    @PatchMapping("/update")
    public void updateStudentById(@RequestParam(name = "id", required = true) Long id ,@RequestBody StudentDTO studentDTO) {
        this.studentService.updateStudent(id,studentDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") Long id){
        this.studentService.deleteStudent(id);
    }
    
    

    // @PostMapping("/create")
    // public void postMethodName( Student student) {
    //     Student student2=Student.builder()
    //     .name("Nguyễn Văn A")
    //     .age(20),
    //     .address("Hà Nội")
    //     .build();
    //     this.studentService
        
    // }
    
}
