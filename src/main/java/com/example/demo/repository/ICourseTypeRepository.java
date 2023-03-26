package com.example.demo.repository;

import com.example.demo.model.entity.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseTypeRepository extends JpaRepository<CourseType, Long> {
}
