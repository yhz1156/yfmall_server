package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@Configuration
@EnableScheduling
public class FileCleanupConfig {

    @Scheduled(fixedDelay = 3600000) // 每小时执行一次
    public void cleanupTempFiles() {
        Path tempDir = Paths.get("temp-upload");
        if (!Files.exists(tempDir)) {
            return;
        }

        try (Stream<Path> paths = Files.walk(tempDir)) {
            paths.filter(path -> Files.isRegularFile(path))
                 .filter(path -> {
                     try {
                         return Duration.between(
                             Files.getLastModifiedTime(path).toInstant(),
                             Instant.now()
                         ).toHours() >= 1;
                     } catch (IOException e) {
                         return false;
                     }
                 })
                 .forEach(path -> {
                     try {
                         Files.deleteIfExists(path);
                     } catch (IOException e) {
                         // 忽略删除失败的文件
                     }
                 });
        } catch (IOException e) {
            // 忽略清理过程中的错误
        }
    }
}
