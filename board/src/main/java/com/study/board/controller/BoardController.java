package com.study.board.controller;

import com.study.board.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping({"", "/"})
    public String index() {
        // WEB-INF/views/index
        System.out.println();
        return "/index";
    }

    // USER 권한이 필요
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
