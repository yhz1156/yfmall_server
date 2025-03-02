package com.example.demo.service.impl;

import com.example.demo.config.WxLoginConfig;
import com.example.demo.service.WxLoginService;
import com.example.demo.model.WxLoginSession;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.time.LocalDateTime;

@Service
public class WxLoginServiceImpl implements WxLoginService {
    
    @Autowired
    private WxLoginConfig wxLoginConfig;
    
    // 使用内存存储登录session
    private static final Map<String, WxLoginSession> sessionMap = new HashMap<>();
    
    @Override
    public Map<String, String> generateQrCode() {
//        String sessionId = UUID.randomUUID().toString();
//        String qrUrl = String.format("https://open.weixin.qq.com/connect/qrconnect" +
//            "?appid=%s" +
//            "&redirect_uri=%s" +
//            "&response_type=code" +
//            "&scope=snsapi_login" +
//            "&state=%s#wechat_redirect",
//            wxLoginConfig.getAppId(),
//            wxLoginConfig.getRedirectUrl(),
//            sessionId);
//
//        WxLoginSession session = new WxLoginSession();
//        session.setSessionId(sessionId);
//        session.setCreateTime(LocalDateTime.now());
//        session.setLogin(false);
//
//        sessionMap.put(sessionId, session);
//
//        return Map.of(
//            "sessionId", sessionId,
//            "qrUrl", qrUrl
//        );
        return null;
    }
    
    @Override
    public boolean checkLoginStatus(String sessionId) {
        WxLoginSession session = sessionMap.get(sessionId);
        return session != null && session.isLogin();
    }
    
    @Override
    public void updateLoginStatus(String sessionId, String openId, String accessToken) {
        WxLoginSession session = sessionMap.get(sessionId);
        if (session != null) {
            session.setOpenId(openId);
            session.setAccessToken(accessToken);
            session.setLogin(true);
        }
    }
}
