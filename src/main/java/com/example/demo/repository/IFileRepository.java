package com.example.demo.repository;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IFileRepository {
    String store(MultipartFile file);

    Resource load(String filename);

    Resource loadByLink(String link);


}
