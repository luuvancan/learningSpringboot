package com.springlearn.webapp.domain.mapper;


import org.mapstruct.Mapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.springlearn.webapp.domain.dto.ClassDTO;
import com.springlearn.webapp.domain.model.Classies;
import com.springlearn.webapp.domain.model.School;

@Mapper(componentModel = "spring")
public interface IClassiesMapper {

    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "school", target = "school")
    @Mapping(target = "students", ignore = true)
    @Mapping(target ="id" , ignore = true , conditionExpression = "java(!hasId)")
    Classies toEntity(ClassDTO dto, School school ,@Context boolean hasId);

    @Mapping(source = "school.id", target = "school_id")
    ClassDTO toDTO(Classies entity);
} 
