package com.study.board.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 => 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/get")
    public String getTest(Member m) { // id=1&username=gihun&password=123&email=gihun@naver
        // MessageConverter (스프링부트)
        System.out.println(TAG+"getter"+m.getId());
        m.
        System.out.println(TAG+"setter"+m.getId());
        return "get 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    @PostMapping("/post") // text/plain application/json
    public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트)

        return "post 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    @PutMapping("/put")
    public String putTest(@RequestBody Member m) {

        return "put 요청"+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    @DeleteMapping("/delete")
    public String deleteTest() {

        return "delete 요청";
    }
}