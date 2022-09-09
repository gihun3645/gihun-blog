package com.study.board.controller;

import com.sun.net.ssl.HttpsURLConnection;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


// 인증이 안된 사용자들이 추립할 수 있는 경로를 /auth/** 허용
// 그냥 주소가 / 이면 index.jsp 허용
// static 이하에 있는 /js/**. /css/**. /image/**
@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {

        return "user/loginForm";
    }

    @GetMapping("/auth/KaKao/callback")
    public @ResponseBody String KaKaoCallback(String code) {

        // POST 방식으로 KEY=VALUE 데이터를 요청
        // Retrofit2
        // OkHttp
        // RestTemplate

        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type" ,"application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id","8a6d5178b09b361a2c830eb2d1215108");
        params.add("redirect_uri", "http://localhost:8080/auth/KaKao/callback");
        params.add("code", code);

        // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String, String>> KaKaoTokenRequest =
                new HttpEntity<>(params, headers);

        // Http 요청하 - Post방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> response = rt.exchange(
                "https://Kauth.KaKao.com/oauth/token",
                HttpMethod.POST,
                KaKaoTokenRequest,
                String.class
        );

        return "카카오 토큰 요청 완료 : 토큰요청에 대한 응답"+response;
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {

        return "user/updateForm";
    }
}
