package com.springlearn.webapp.service;

import org.springframework.stereotype.Service;

import com.springlearn.webapp.dto.ClassDTO;
import com.springlearn.webapp.dto.mapstruct.IClassiesMapper;
import com.springlearn.webapp.model.Classies;
import com.springlearn.webapp.model.School;
import com.springlearn.webapp.reponsitory.ClassReponsitory;
import com.springlearn.webapp.reponsitory.SchoolReponsitory;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import java.util.List;


@Service
@AllArgsConstructor
public class ClassService {
    
    @NonNull
    private final ClassReponsitory classReponsitory;
    @NonNull
    private final IClassiesMapper classiesMapper;
    @Nonnull
    private final SchoolReponsitory schoolReponsitory;
    
    //Get All
    public List<Classies> getAllClass() {
        return classReponsitory.findAll();
    }
    //Create 
    public void createClass(@NonNull ClassDTO classDTO){
        School school = schoolReponsitory.findById(classDTO.getSchool_id())
        .orElseThrow(() -> new RuntimeException("School not found"));
        Classies classies = classiesMapper.toEntity(classDTO,school);
        classReponsitory.save(classies);
    }
    //Update 
    public void updateClass(@NonNull Classies classies){
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
