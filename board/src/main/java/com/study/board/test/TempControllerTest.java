package com.study.board.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// Controller 는 해당 경로 밑에 있는 파일을 리턴
public class TempControllerTest {

    @GetMapping("/home")
    public String tempHome() {
        System.out.println("tempHome()");
        // 파일리턴 기본경로 : src/main/resources/static
        // 리턴명 : /home/html
        // 풀경로 : src/main/resources/static/home.html
        return "/home.html";
    }

    @GetMapping("/img")
    public String tempImg() {
        return "/a.png";
    }

    @GetMapping("/jsp") // jsp는 정적인 파일이 아닌 동적인 파일
    public String tempJsp() {
        // prefix : /WEB-INF/views/
        // suffix : .jsp
        // 풀네임 : /WEB-INF/views/test.jsp
        return "test";
    }
}
