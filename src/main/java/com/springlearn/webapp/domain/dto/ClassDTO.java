package com.springlearn.webapp.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*Annotaion @Data sẽ tương đương với việc tạo 
 * @Setter, @Getter , @RequiredArgsConstructor ( final ,nonnull)
 * 
 * 
 */
public class ClassDTO implements Serializable{
    private String name;
    private Long school_id;
}
