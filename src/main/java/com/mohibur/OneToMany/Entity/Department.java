package com.mohibur.OneToMany.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String departmentName;

    @Column(nullable = false)
    private String chairmanName;

    @JsonIgnoreProperties("department")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<Course> courseList;
}
