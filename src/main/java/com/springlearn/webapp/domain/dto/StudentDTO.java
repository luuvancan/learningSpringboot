package com.springlearn.webapp.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO implements Serializable{
    private String name;
    private Integer age;
    private Long class_Id;
}
