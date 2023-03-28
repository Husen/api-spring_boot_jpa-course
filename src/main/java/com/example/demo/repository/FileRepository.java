package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Repository
public class FileRepository implements IFileRepository{
    private final Path root;

    @Autowired
    public FileRepository(@Value("${assets_path}") String rootPath) {
//      akan di konversi ke bentuk path ->  /home/husen/enigma/kelas/java/springFramework/course/assets
        this.root = Paths.get(rootPath);
    }

    @Override
    public String store(MultipartFile file) {
        try {
            Path filePath = root.resolve(file.getOriginalFilename());

//            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            Files.copy(file.getInputStream(), filePath);

            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file. Error " + e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path filePath = root.resolve(filename);

            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("Could not store the file");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("error " + e.getMessage());
        }
    }

    @Override
    public Resource loadByLink(String link) {
        try {
            Path filePath = Path.of(link);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new RuntimeException("Could not store the file");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("error " + e.getMessage());
        }
    }
}
