package com.springlearn.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*Annotaion @Data sẽ tương đương với việc tạo 
 * @Setter, @Getter , @RequiredArgsConstructor ( final ,nonnull)
 * 
 * 
 */
public class ClassDTO {
    private String name;
    private Long school_id;
}
