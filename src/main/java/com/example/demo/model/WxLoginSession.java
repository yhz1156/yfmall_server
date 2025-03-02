package com.example.demo.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class WxLoginSession {
    private String sessionId;
    private String openId;
    private LocalDateTime createTime;
    private boolean isLogin;
    private String accessToken;
}
