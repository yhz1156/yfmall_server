package com.example.demo.service;

import com.example.demo.model.WxLoginSession;
import java.util.Map;

public interface WxLoginService {
    Map<String, String> generateQrCode();
    boolean checkLoginStatus(String sessionId);
    void updateLoginStatus(String sessionId, String openId, String accessToken);
}
