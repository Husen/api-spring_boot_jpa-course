package com.example.demo.controller;

import com.example.demo.model.request.FormDataWithFile;
import com.example.demo.model.response.SuccessResponse;
import com.example.demo.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    private IFileService fileService;

    @Autowired
    public FileController(IFileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity upload(FormDataWithFile formDataWithFile) {
        MultipartFile file = formDataWithFile.getFile();
        String filePath = fileService.uploadFile(file);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new SuccessResponse<>("Success upload file", filePath));
    }

    @GetMapping
    public ResponseEntity download(@RequestParam String filename) {
        Resource file = fileService.downloadFile(filename);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/image/{filename}")
    public ResponseEntity showImage(@PathVariable("filename") String filename) throws IOException {
        Resource file = fileService.downloadFile(filename);

        byte[] imageButes = StreamUtils.copyToByteArray(file.getInputStream());
        System.out.println(imageButes);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_PNG)
                .body(imageButes);
    }
}
