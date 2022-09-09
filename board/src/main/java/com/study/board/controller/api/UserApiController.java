package com.study.board.controller.api;


import com.study.board.config.auth.PrincipalDetail;
import com.study.board.controller.dto.ResDto;
import com.study.board.model.User;
import com.study.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResDto<Integer> save(@RequestBody User user){ // username, password, email
        System.out.println("UserApiController: save 호출됨");
        userService.회원가입(user);
        return new ResDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }

    @PutMapping("/user")
    public ResDto<Integer> update(@RequestBody User user,
                                  HttpSession session) {
        userService.회원수정(user);
        // 여기서는 트랜젝션 값이 종료되기 때문에 DB에 값은 변경이 됐음
        // 하지만 세션값은 변경되지 않은 상태이기 때문 우리가 직접 세션값을 변경해줄 거
        return new ResDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
