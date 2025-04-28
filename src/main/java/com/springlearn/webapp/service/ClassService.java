package com.springlearn.webapp.service;

import org.springframework.stereotype.Service;

import com.springlearn.webapp.domain.dto.ClassDTO;
import com.springlearn.webapp.domain.mapper.IClassiesMapper;
import com.springlearn.webapp.domain.model.Classies;
import com.springlearn.webapp.domain.model.School;
import com.springlearn.webapp.reponsitory.ClassReponsitory;
import com.springlearn.webapp.reponsitory.SchoolReponsitory;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import java.util.List;


@Service
@AllArgsConstructor
public class ClassService {
    
    private final ClassReponsitory classReponsitory;
    private final IClassiesMapper classiesMapper;
    private final SchoolReponsitory schoolReponsitory;
    
    //Get All
    public List<Classies> getAllClass() {
        return classReponsitory.findAll();
    }
    //Create 
    public ClassDTO createClass(@NonNull ClassDTO classDTO){
        School school = schoolReponsitory.findById(classDTO.getSchool_id())
        .orElseThrow(() -> new RuntimeException("School not found"));
        Classies classies = classiesMapper.toEntity(classDTO,school,false);
        Classies result = classReponsitory.save(classies);
        return classiesMapper.toDTO(result);
    }
    //Update 
    public void updateClass(@Nonnull Long id,@NonNull ClassDTO classDTO){
        if(id == null){
            throw new IllegalArgumentException("Class ID must not be null");
        }
        School school = schoolReponsitory.findById(classDTO.getSchool_id())
        .orElseThrow(() -> new RuntimeException("School not found"));
        Classies classies = classiesMapper.toEntity(classDTO,school,true);
        classies.setId(id);
        this.classReponsitory.save(classies);
    }
    //Delete
    public void deleteClass(@NonNull Long id){
        this.classReponsitory.deleteById(id);
    }
    //Get Class by Id
    public Classies getClassById(@NonNull Long id) {
        return this.classReponsitory.findById(id).orElse(null);
    }

    // Cacheable annotation để lưu dữ liệu vào cache
    // @Cacheable("studentCache") // Cache sẽ được lưu trữ với tên là "studentCache"
    // public List<String> getStudents() {
    //     // Giả lập dữ liệu lấy từ cơ sở dữ liệu
    //     System.out.println("Fetching data from database..."); // Sẽ xuất hiện khi lấy dữ liệu từ cơ sở dữ liệu
    //     return List.of("Alice", "Bob", "Charlie");
    // }


    // // CacheEvict annotation để xóa cache khi cần
    // @CacheEvict(value = "studentCache", allEntries = true)
    // public void clearCache() {
    //     // Phương thức này sẽ xóa toàn bộ cache khi được gọi
    //     System.out.println("Cache cleared!");
    // }
}
