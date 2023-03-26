package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "courses_type")
@Data
public class CourseType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_type", nullable = false, unique = true)
    private String nameType;
}
