package com.example.demo.controller;

import com.example.demo.config.FileUploadConfig;
import com.example.demo.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;
    
    @Autowired
    private FileUploadConfig fileUploadConfig;

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = fileUploadService.uploadImage(file);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "上传成功");
            response.put("fileName", fileName);
           //response.put("url", fileUploadConfig.getServerUrl() + "/uploads/" + fileName);
            response.put("url", "http://mall.yellow-fish.cn/yellowfishmall/file/" + fileName);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "上传失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/image/{filename:.+}")
    public ResponseEntity<?> deleteImage(@PathVariable String filename) {
        try {
            fileUploadService.deleteImage(filename);
            return ResponseEntity.ok(Collections.singletonMap("message", "删除成功"));
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "删除失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
