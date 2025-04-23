package com.springlearn.webapp.dto.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.springlearn.webapp.dto.SchoolDTO;
import com.springlearn.webapp.model.School;

@Mapper(componentModel = "spring")
public interface ISchoolMapper {

    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.address", target = "address")
    @Mapping(target = "classes", ignore = true)
    School toEntity(SchoolDTO dto , School school);

    SchoolDTO toDTO (School entity);
}
