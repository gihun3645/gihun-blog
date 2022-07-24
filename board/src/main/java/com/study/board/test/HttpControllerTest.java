package com.study.board.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 => 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    @GetMapping("/get")
    public String getTest(Member m) { // id=1&username=gihun&password=123&email=gihun@naver
        return "get 요청 : "+m.getId()+", "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
    }

    @PostMapping("/post")
    public String postTest() {

        return "post 요청";
    }

    @PutMapping("/put")
    public String putTest() {

        return "put 요청";
    }

    @DeleteMapping("/delete")
    public String deleteTest() {

        return "delete 요청";
    }
}
