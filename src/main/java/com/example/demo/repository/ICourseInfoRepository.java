package com.example.demo.repository;

import com.example.demo.model.entity.CourseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseInfoRepository extends JpaRepository<CourseInfo, Long> {
}
