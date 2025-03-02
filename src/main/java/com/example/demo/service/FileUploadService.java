package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface FileUploadService {
    String uploadImage(MultipartFile file) throws IOException;
    void deleteImage(String filename) throws IOException;
}
