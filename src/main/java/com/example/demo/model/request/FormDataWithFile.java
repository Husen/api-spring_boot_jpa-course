package com.example.demo.model.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FormDataWithFile {
    private MultipartFile file;
}
