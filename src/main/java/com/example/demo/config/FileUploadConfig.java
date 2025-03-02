package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@Configuration
@ConfigurationProperties(prefix = "file.upload")
public class FileUploadConfig {
    private String location = "uploads";
    private String allowedExtensions = ".jpg,.jpeg,.png,.gif";
    private long maxFileSize = 5242880L; // 5MB
    private String serverUrl;  // 新增服务器地址配置
    
    public Path getUploadPath() {
        return Paths.get(location).toAbsolutePath().normalize();
    }
}
