package com.study.board.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 => 응답(HTML 파일)
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    @GetMapping("/lombok")
    public String lombokTest() {
        // MessageConverter (스프링부트)
        Member m = Member.builder().username("gihun").password("1234").email("gihun@naver.com").build();
        // Member m = new Member(1, "gihun", "1234", "gihun@naver.com");
        // 위와 다르게 builder는 객체에 값을 넣을 때 순서를 지키지 않아도 됨
        // 객체 값 순서를 헷갈려서 객체의 값을 잘못 넣는 실수하는 것을 방지한다.
        System.out.println(TAG+"getter : "+m.getUsername());
        m.setUsername("manju");
        System.out.println(TAG+"setter : "+m.getUsername());
        return "lombok test 완료";
    }

    @GetMapping("/get")
    public String getTest(Member m) { // id=1&username=gihun&password=123&email=gihun@naver

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