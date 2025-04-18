package com.springlearn.webapp.dto.mapstruct;

import org.mapstruct.Mapping;

import com.springlearn.webapp.dto.StudentDTO;
import com.springlearn.webapp.model.Classies;
import com.springlearn.webapp.model.Student;

public interface IStudentMapper {
    @Mapping(source = "classies" , target = "myClass")
    Student toEntity(StudentDTO studentDTO ,Classies classies);

    @Mapping(source = "entity.id", target = "class_Id")
    StudentDTO toDTO(Student entity);


}
