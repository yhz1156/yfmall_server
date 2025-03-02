package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "wx.login")
public class WxLoginConfig {
    private String appId;
    private String appSecret;
    private String redirectUrl;
}
