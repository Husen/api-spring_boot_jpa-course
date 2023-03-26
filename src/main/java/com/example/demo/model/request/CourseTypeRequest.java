package com.example.demo.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseTypeRequest {
    @NotBlank(message = "name type {invalid.required}")
    private String nameType;
}
