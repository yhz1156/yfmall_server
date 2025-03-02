package com.example.demo.controller;

import com.example.demo.service.WxLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/wx")
public class WxLoginController {

    @Autowired
    private WxLoginService wxLoginService;

    @GetMapping("/qrcode")
    public ResponseEntity<?> getQrCode() {
//        try {
//            Map<String, String> result = wxLoginService.generateQrCode();
//            return ResponseEntity.ok(result);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(Map.of(
//                "message", "获取二维码失败"
//            ));
//        }
        return null;
    }

    @GetMapping("/check")
    public ResponseEntity<?> checkLoginStatus(@RequestParam String sessionId) {
//        boolean isLogin = wxLoginService.checkLoginStatus(sessionId);
//        return ResponseEntity.ok(Map.of(
//            "success", isLogin
//        ));
        return null;
    }

    @GetMapping("/callback")
    public ResponseEntity<?> wxCallback(
            @RequestParam String code,
            @RequestParam String state) {
//        try {
//            // 这里需要调用微信API获取openId和accessToken
//            String openId = "mock_openid";  // 实际需要通过code获取
//            String accessToken = "mock_token";  // 实际需要通过code获取
//
//            wxLoginService.updateLoginStatus(state, openId, accessToken);
//            return ResponseEntity.ok(Map.of(
//                "message", "登录成功"
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(Map.of(
//                "message", "登录失败"
//            ));
//        }
        return null;
    }
}
