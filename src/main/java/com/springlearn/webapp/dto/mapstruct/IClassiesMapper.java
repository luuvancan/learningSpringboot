package com.springlearn.webapp.dto.mapstruct;


import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

import com.springlearn.webapp.dto.ClassDTO;
import com.springlearn.webapp.model.Classies;
import com.springlearn.webapp.model.School;

@Mapper(componentModel = "spring")
public interface IClassiesMapper {

    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "school", target = "school")
    @Mapping(target = "students", ignore = true)
    Classies toEntity(ClassDTO dto, School school);

    @Mapping(source = "entity.id", target = "school_id")
    ClassDTO toDTO(Classies entity);
} 
