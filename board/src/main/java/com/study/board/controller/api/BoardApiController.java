package com.study.board.controller.api;


import com.study.board.config.auth.PrincipalDetail;
import com.study.board.controller.dto.ResDto;
import com.study.board.model.Board;
import com.study.board.model.User;
import com.study.board.service.BoardService;
import com.study.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        boardService.글쓰기(board, principal.getUser());
        return new ResDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }
}
