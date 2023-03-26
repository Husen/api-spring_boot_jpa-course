package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.CourseInfo;
import com.example.demo.model.entity.CourseType;
import com.example.demo.model.request.CourseRequest;
import com.example.demo.repository.ICourseInfoRepository;
import com.example.demo.repository.ICourseRepository;
import com.example.demo.repository.ICourseTypeRepository;
import com.example.demo.utils.specification.SearchCriteria;
import com.example.demo.utils.specification.Spec;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private ICourseInfoRepository courseInfoRepository;
    @Autowired
    private ICourseTypeRepository courseTypeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Course> findAll() {
        try {
            return courseRepository.findAll();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> listBy(SearchCriteria searchCriteria) {
        try {
            Specification specification = new Spec<Course>().findBy(searchCriteria);
            List<Course> courses = courseRepository.findAll(specification);
            if (courses.isEmpty()) {
                throw new NotFoundException("Not found");
            }
            return courses;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Course> findById(Long id) {
        try {
            Optional<Course> findCourse = courseRepository.findById(id);
            if (findCourse.isEmpty()) {
                throw new NotFoundException("Data tidak ada");
            }
            return findCourse;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateById(CourseRequest courseRequest, Long id) {
        try {
            Optional<Course> updateCourse = findById(id); // cek id course
            Optional<CourseInfo> updateCourseInfo = courseInfoRepository.findById(id); // get id course info for update data

            CourseInfo mapCourseInfo = modelMapper.map(courseRequest, CourseInfo.class);
            updateCourseInfo.get().setDuration(mapCourseInfo.getDuration());
            updateCourseInfo.get().setLevel(mapCourseInfo.getLevel());
            CourseInfo resultCourseInfo = courseInfoRepository.save(updateCourseInfo.get());

            Course mapCourse = modelMapper.map(courseRequest, Course.class); // mapping data
            updateCourse.get().setTitle(mapCourse.getTitle());
            updateCourse.get().setDescription(mapCourse.getDescription());
            updateCourse.get().setTitle(mapCourse.getTitle());
            updateCourse.get().setLink(mapCourse.getLink());
            updateCourse.get().setCourseInfo(resultCourseInfo);
            updateCourse.get().setCourseType(mapCourse.getCourseType());
            courseRepository.save(updateCourse.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course create(CourseRequest courseRequest) {
        try {
            CourseInfo saveCourseInfo = modelMapper.map(courseRequest, CourseInfo.class);
            CourseInfo resultCourseInfo = courseInfoRepository.save(saveCourseInfo);

            Optional<CourseType> getIdType = courseTypeRepository.findById(courseRequest.getCourseType().getId());

            Course saveCourse = modelMapper.map(courseRequest, Course.class);

            saveCourse.setCourseInfo(resultCourseInfo);
            saveCourse.setCourseType(getIdType.get());
            Course returnCourse = courseRepository.save(saveCourse);

            return returnCourse;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Optional<Course> deleteCourse = findById(id);
            courseRepository.delete(deleteCourse.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
