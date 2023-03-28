package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "courses")
@Data
@Accessors(chain = true)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "link")
    private String link;

//     one to one course info
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseInfoId", referencedColumnName = "id")
    private CourseInfo courseInfo;

    // many to one course type
    @ManyToOne
    private CourseType courseType;

}
