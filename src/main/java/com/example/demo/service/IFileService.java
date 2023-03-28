package com.example.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String uploadFile(MultipartFile file);
    Resource downloadFile(String filename);

    Resource downloadFileByLink(String link);


}
