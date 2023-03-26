//package com.example.demo.service;
//
//import com.example.demo.exception.NotFoundException;
//import com.example.demo.model.entity.Course;
//import com.example.demo.repository.ICourseRepository;
//import com.example.demo.utils.CourseKey;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CourseArrayService implements ICourseService{
//
//    @Autowired
//    ICourseRepository courseRepository;
//
//    @Override
//    public List<Course> list() {
//        try {
//            List<Course> courseList = courseRepository.getAll();
//            if (courseList.isEmpty()) {
//                throw new NotFoundException("Not Found");
//            }
//            return courseList;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Course create(Course course) {
//        try {
//            return courseRepository.create(course);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Optional<Course> get(String id) {
//        try {
//            Optional<Course> course = courseRepository.findByid(id);
//            if (course.isEmpty()) {
//                throw new NotFoundException("Id not found");
//            }
//            return course;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void update(Course course, String id) {
//        try {
//            courseRepository.update(course, id);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void delete(String id) {
//        try {
//            courseRepository.delete(id);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public Optional<List<Course>> findBy(CourseKey key, String value) {
//        try {
//            Optional<List<Course>> courseList = courseRepository.findBy(key, value);
//            if (courseList.isEmpty()) {
//                throw new NotFoundException("Not Found");
//            }
//            return courseList;
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//    }
//}
