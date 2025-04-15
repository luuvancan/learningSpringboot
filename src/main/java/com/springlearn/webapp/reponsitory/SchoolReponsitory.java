package com.springlearn.webapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springlearn.webapp.model.School;
import java.util.List;



public interface SchoolReponsitory extends JpaRepository<School,Long>{
    List<School> findByName(String name);
}
