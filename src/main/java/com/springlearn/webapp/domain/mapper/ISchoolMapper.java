package com.springlearn.webapp.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.springlearn.webapp.domain.dto.SchoolDTO;
import com.springlearn.webapp.domain.model.School;

@Mapper(componentModel = "spring")
public interface ISchoolMapper {

    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.address", target = "address")
    @Mapping(target = "classes", ignore = true)
    School toEntity(SchoolDTO dto , School school);

    SchoolDTO toDTO (School entity);
}
