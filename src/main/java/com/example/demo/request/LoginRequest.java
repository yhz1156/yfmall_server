package com.example.demo.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String phone;  // 改为使用手机号登录
    private String password;
}