package com.example.demo.service.impl;

import com.example.demo.config.FileUploadConfig;
import com.example.demo.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.io.InputStream;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadConfig fileUploadConfig;

    @PostConstruct
    public void init() throws IOException {
        // 创建上传目录
        Files.createDirectories(fileUploadConfig.getUploadPath());
        // 创建临时文件目录
        Files.createDirectories(Paths.get("temp-upload"));
    }

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("请选择要上传的文件");
        }

        // 检查文件大小
        if (file.getSize() > fileUploadConfig.getMaxFileSize()) {
            throw new IllegalArgumentException("文件大小超过限制");
        }

        // 检查文件扩展名
        String extension = "." + FilenameUtils.getExtension(file.getOriginalFilename());
        if (!fileUploadConfig.getAllowedExtensions().contains(extension.toLowerCase())) {
            throw new IllegalArgumentException("不支持的文件类型");
        }

        // 生成新的文件名
        String newFileName = UUID.randomUUID().toString() + extension;
        Path targetLocation = fileUploadConfig.getUploadPath().resolve(newFileName);

        // 使用try-with-resources确保流被正确关闭
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);
        }

        return newFileName;
    }

    @Override
    public void deleteImage(String filename) throws IOException {
        Path file = fileUploadConfig.getUploadPath().resolve(filename);
        Files.deleteIfExists(file);
    }
}
