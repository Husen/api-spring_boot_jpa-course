package com.example.demo.service;

import com.example.demo.repository.IFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService implements IFileService{

    private IFileRepository fileRepository;

    @Autowired
    public FileService(IFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        return fileRepository.store(file);
    }

    @Override
    public Resource downloadFile(String filename) {
        return fileRepository.load(filename);
    }

    @Override
    public Resource downloadFileByLink(String link) {
        return fileRepository.loadByLink(link);
    }
}
