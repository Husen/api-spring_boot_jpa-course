package com.example.demo.service;

import com.example.demo.model.entity.Course;
import com.example.demo.model.request.CourseRequest;
import com.example.demo.utils.specification.SearchCriteria;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<Course> findAll();
    List<Course> listBy(SearchCriteria searchCriteria);
    Optional<Course> findById(Long id);
    void updateById(CourseRequest courseRequest, Long id);
    Course create(CourseRequest courseRequest);
    void delete(Long id);
}
