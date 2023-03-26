package com.example.demo.service;

import com.example.demo.model.entity.CourseType;
import com.example.demo.model.request.CourseTypeRequest;
import com.example.demo.repository.ICourseTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseTypeService implements ICourseTypeService{
    @Autowired
    private ICourseTypeRepository courseTypeRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CourseType> findAll() {
        return null;
    }

    @Override
    public Optional<CourseType> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void updateById(CourseTypeRequest courseTypeRequest, Long id) {

    }

    @Override
    public CourseType create(CourseTypeRequest courseTypeRequest) {
        try {
            CourseType courseType = modelMapper.map(courseTypeRequest, CourseType.class);
            return courseTypeRepository.save(courseType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {

    }
}
