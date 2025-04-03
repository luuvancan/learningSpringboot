package com.springlearn.webapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SCHOOL")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable =false)
    private String name ;

    @Column(nullable = false)
    private String address ;

    @OneToMany(mappedBy = "school")
    private List<Class>classes;
    
    //Constructor

    public School() {}
    public School(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public List<Class> getClasses() { return classes; }
    public void setClasses(List<Class> classes) { this.classes = classes; }

}
