package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "courses_info")
@Data
public class CourseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "level", nullable = false)
    private String level;

}