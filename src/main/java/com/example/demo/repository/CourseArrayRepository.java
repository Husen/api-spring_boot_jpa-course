//package com.example.demo.repository;
//
//import com.example.demo.model.entity.Course;
//import com.example.demo.utils.CourseKey;
//import com.example.demo.utils.IRandomStringGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class CourseArrayRepository implements ICourseRepository{
//    @Autowired
//    IRandomStringGenerator randomStringGenerator;
//
//    private List<Course> courses = new ArrayList<>();
//
//    @Override
//    public List<Course> getAll() throws Exception {
//        return courses;
//    }
//
//    @Override
//    public Course create(Course course) throws Exception {
//        course.setCourseId(randomStringGenerator.random());
//        courses.add(course);
//        return course;
//    }
//
//    @Override
//    public Optional<Course> findByid(String id) throws Exception {
//        for (Course course : courses) {
//            if (course.getCourseId().equals(id)) {
//                return Optional.of(course);
//            }
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public void update(Course course, String id) throws Exception {
//        for (Course existCourse : courses) {
//            if (existCourse.getCourseId().equals(id)) {
//                existCourse.setTitle(course.getTitle());
//                existCourse.setDescription(course.getDescription());
//                existCourse.setLink(course.getLink());
//                break;
//            }
//        }
//    }
//
//    @Override
//    public void delete(String id) throws Exception {
//        for (Course course : courses) {
//            if (course.getCourseId().equals(id)) {
//                courses.remove(course);
//                break;
//            }
//        }
//    }
//
//    @Override
//    public Optional<List<Course>> findBy(CourseKey key, String value) throws Exception {
//        List<Course> courseList = new ArrayList<>();
//            switch (key) {
//                case title -> {
//                    for (Course course : courses) {
//                        if (course.getTitle().toLowerCase().contains(value.toLowerCase())) {
//                            courseList.add(course);
//                        }
//                    }
//                }
//                case description -> {
//                    for (Course course : courses) {
//                        if (course.getDescription().toLowerCase().contains(value.toLowerCase())) {
//                            courseList.add(course);
//                        }
//                    }
//                }
//                case link -> {
//                    for (Course course : courses) {
//                        if (course.getLink().toLowerCase().contains(value.toLowerCase())) {
//                            courseList.add(course);
//                        }
//                    }
//                }
//            }
//
//        return courseList.isEmpty() ? Optional.empty() : Optional.of(courseList);
//    }
//
//}
