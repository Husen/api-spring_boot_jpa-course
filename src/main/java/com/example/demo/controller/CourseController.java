package com.example.demo.controller;

import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.CourseType;
import com.example.demo.model.request.CourseRequest;
import com.example.demo.model.request.CourseTypeRequest;
import com.example.demo.model.request.FormDataWithFile;
import com.example.demo.model.response.SuccessResponse;
import com.example.demo.service.ICourseService;
import com.example.demo.service.ICourseTypeService;
import com.example.demo.service.IFileService;
import com.example.demo.utils.constant.Operator;
import com.example.demo.utils.specification.SearchCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @Autowired
    private ICourseTypeService courseTypeService;

    @Autowired
    private IFileService fileService;


    // crud course

    @GetMapping
    public ResponseEntity getAllCourse() throws Exception {
        List<Course> course = courseService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessResponse<List<Course>>("Success find all Course...", course));
    }

    @GetMapping(params = {"key", "value", "operator"})
    public ResponseEntity getAllBy(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("operator") String operator) throws Exception {
        SearchCriteria searchCriteria = new SearchCriteria(key, Operator.valueOf(operator), value);
        List<Course> courses = courseService.listBy(searchCriteria);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessResponse<List<Course>>("Success list by course..", courses));
    }

    @GetMapping("{id}")
    public ResponseEntity getCourseId(@PathVariable Long id) throws Exception {
        Optional<Course> course = courseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessResponse<Optional<Course>>("Success find by id Course...", course));
    }

//    @PostMapping
//    public ResponseEntity createCourse(@Valid @RequestBody CourseRequest courseRequest) throws Exception {
//        Course course = courseService.create(courseRequest);
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new SuccessResponse<Course>("Success create Course...", course));
//    }
    @PostMapping
    public ResponseEntity createCourse(@Valid CourseRequest courseRequest) throws Exception {
        Course course = courseService.create(courseRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessResponse<Course>("Success create Course...", course));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCourse(@Valid @RequestBody CourseRequest courseRequest, @PathVariable Long id) throws Exception {
        courseService.updateById(courseRequest, id);
        Optional<Course> findId = courseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessResponse<Optional<Course>>("Success update Course...", findId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        courseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success delete course with id " + id, null));
    }


    // crud course type

    @PostMapping("/type")
    public ResponseEntity createCourseType(@Valid @RequestBody CourseTypeRequest courseTypeRequest) throws Exception {
        CourseType courseType = courseTypeService.create(courseTypeRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new SuccessResponse<CourseType>("Success create Course Type...", courseType));
    }

    // crud with upload

//    @PostMapping(value = "/upload", produces = "application/json")
//    public ResponseEntity createCourseUpload(@RequestParam ("course") String course, @RequestParam(value = "files", required = false) MultipartFile files) throws IOException {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        CourseRequest courseobject = objectMapper.readValue(course, CourseRequest.class);
//
//        String pathFile = fileService.uploadFile(files);
//
//        System.out.println(pathFile);
//
//        courseobject.(pathFile);
//        Course course1 = courseService.create(courseobject);
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new SuccessResponse<Course>("Success create Course...", course1));
//    }

    @GetMapping("download/{id}")
    public ResponseEntity download(@PathVariable Long id) {

        Optional<Course> findId = courseService.findById(id);

        Resource file = fileService.downloadFile(findId.get().getLink());

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

}
