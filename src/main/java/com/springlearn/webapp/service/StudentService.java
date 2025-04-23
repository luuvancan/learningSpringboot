package com.springlearn.webapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springlearn.webapp.dto.StudentDTO;
import com.springlearn.webapp.dto.mapstruct.IStudentMapper;
import com.springlearn.webapp.model.Classies;
import com.springlearn.webapp.model.Student;
import com.springlearn.webapp.reponsitory.ClassReponsitory;
import com.springlearn.webapp.reponsitory.StudentReponsitory;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentReponsitory studentRepository;
    private final ClassReponsitory classReponsitory;
    private final IStudentMapper studentMapper;

    //Get All
    public List<Student> getAllStudent(){
        return this.studentRepository.findAll();
    }
    //Create 
    public StudentDTO createStudent(@NonNull StudentDTO studentDTO){
        Classies classies = classReponsitory.findById(studentDTO.getClass_Id())
        .orElseThrow(()->new RuntimeException("Class not found"));
        Student student = studentMapper.toEntity(studentDTO,classies,false);
        Student result = studentRepository.save(student);
        return studentMapper.toDTO(result);
    }
    //Update 
    public void updateStudent(@NonNull Long id,@NonNull StudentDTO studentDTO){
        if(id == null){
            throw new IllegalArgumentException("Student ID cannot be null");
        }
        Classies classies = classReponsitory.findById(studentDTO.getClass_Id())
        .orElseThrow(() -> new RuntimeException("CLass not found"));
        Student student = studentMapper.toEntity(studentDTO,classies,true);
        student.setId(id);
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
