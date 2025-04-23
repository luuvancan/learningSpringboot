package com.springlearn.webapp.dto.mapstruct;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.springlearn.webapp.dto.StudentDTO;
import com.springlearn.webapp.model.Classies;
import com.springlearn.webapp.model.Student;

@Mapper(componentModel = "spring")
public interface IStudentMapper {

    @Mapping(source = "classies" , target = "myClass")
    @Mapping(source = "studentDTO.name", target = "name")
    @Mapping(target = "id", ignore = true , conditionExpression = "java(!hasId)")
    Student toEntity(StudentDTO studentDTO ,Classies classies ,@Context boolean hasId);

    @Mapping(source = "myClass.id", target = "class_Id")
    StudentDTO toDTO(Student entity);
}
