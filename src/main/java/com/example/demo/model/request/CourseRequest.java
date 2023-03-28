package com.example.demo.model.request;

import com.example.demo.model.entity.CourseInfo;
import com.example.demo.model.entity.CourseType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CourseRequest {
    @NotBlank(message = "title {invalid.required}")
    private String title;
    @NotBlank(message = "description {invalid.required}")
    private String description;

    private MultipartFile file;

    private Integer duration;

    private String level;

    private CourseType courseType;

}
