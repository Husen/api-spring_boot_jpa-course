package com.example.demo.service;

import com.example.demo.model.entity.CourseType;
import com.example.demo.model.request.CourseTypeRequest;

import java.util.List;
import java.util.Optional;

public interface ICourseTypeService {
    List<CourseType> findAll();
    Optional<CourseType> findById(Long id);
    void updateById(CourseTypeRequest courseTypeRequest, Long id);
    CourseType create(CourseTypeRequest courseTypeRequest);
    void delete(Long id);
}
