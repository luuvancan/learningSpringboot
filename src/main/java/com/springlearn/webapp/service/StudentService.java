package com.springlearn.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.springlearn.webapp.model.Student;
import com.springlearn.webapp.reponsitory.StudentReponsitory;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class StudentService {
    @NonNull
    private final StudentReponsitory studentRepository;

    //Get All
    public List<Student> getAllStudent(){
        return this.studentRepository.findAll();
    }
    //Create 
    public void createStudent(@NonNull Student student){
        this.studentRepository.save(student);
    }
    //Update 
    public void updateStudent(@NonNull Student student){
        this.studentRepository.save(student);
    }
    //Delete
    public void deleteStudent(@NonNull Long id){
        this.studentRepository.deleteById(id);
    }
    //Get Student by Id
    public Student getStudentById(@NonNull Long id) {
        return this.studentRepository.findById(id).orElse(null);
    }
}
