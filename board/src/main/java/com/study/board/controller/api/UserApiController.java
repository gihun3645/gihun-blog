package com.study.board.controller.api;


import com.study.board.controller.dto.ResDto;
import com.study.board.model.RoleType;
import com.study.board.model.User;
import com.study.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResDto<Integer> save(@RequestBody User user){ // username, password, email
        System.out.println("UserApiController: save 호출됨");
        // 실제로 DB에 insert를 하고 아래에서 return이 되면 된다.
        user.setRole(RoleType.USER);
        int result = userService.회원가입(user);
        return new ResDto<Integer>(HttpStatus.OK, result); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }
}
