package com.example.demo.model.request;

import com.example.demo.model.entity.CourseInfo;
import com.example.demo.model.entity.CourseType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseRequest {
    @NotBlank(message = "title {invalid.required}")
    private String title;
    @NotBlank(message = "description {invalid.required}")
    private String description;
    @NotBlank(message = "link {invalid.required}")
    private String link;

    private Integer duration;

    private String level;

    private CourseType courseType;

}
