package com.springlearn.webapp.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data 
@Builder // Sử dụng để tạo các Constructor vs nhiều tham số khác nhau
@Table(name="classies")

public class Classies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @OneToMany(mappedBy = "myClass", cascade = CascadeType.ALL, fetch = FetchType.LAZY) //EAGGER /
    private List<Student> students;
    // LAZY  : khi chạy Classies a = new Classies (); a.students nó mới lấy từ DB về 
    
    public Classies(String name, School school) {
        this.name = name;
        this.school = school;
    }

}
