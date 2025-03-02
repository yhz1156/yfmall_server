package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.RegisterRequest;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Customer customer = authService.login(loginRequest);
        
        if (customer == null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "手机号或密码错误");
            return ResponseEntity.badRequest().body(response);
        }

        Map<String, Object> customerInfo = new HashMap<>();
        customerInfo.put("id", customer.getId());
        customerInfo.put("name", customer.getName());
        customerInfo.put("phone", customer.getPhone());
        customerInfo.put("email", customer.getEmail());
        customerInfo.put("identity", customer.getIdentity());
        customerInfo.put("address", customer.getAddress());

        Map<String, Object> response = new HashMap<>();
        response.put("message", "登录成功");
        response.put("data", customerInfo);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            Customer customer = authService.register(registerRequest);
            
            Map<String, Object> customerInfo = new HashMap<>();
            customerInfo.put("name", customer.getName());
            customerInfo.put("phone", customer.getPhone());
            customerInfo.put("password", customer.getPassword());

            Map<String, Object> response = new HashMap<>();
            response.put("message", "注册成功");
            response.put("customer", customerInfo);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "注册失败: " + e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}