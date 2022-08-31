package com.study.board.controller.api;


import com.study.board.controller.dto.ResDto;
import com.study.board.model.RoleType;
import com.study.board.model.User;
import com.study.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
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
}
