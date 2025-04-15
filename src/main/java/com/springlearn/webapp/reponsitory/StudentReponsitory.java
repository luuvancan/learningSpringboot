package com.springlearn.webapp.reponsitory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springlearn.webapp.model.Student;


public interface StudentReponsitory extends JpaRepository<Student,Long>{
    List<Student> findByName(String name);
}
