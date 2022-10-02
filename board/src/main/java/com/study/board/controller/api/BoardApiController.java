package com.study.board.controller.api;


import com.study.board.config.auth.PrincipalDetail;
import com.study.board.controller.dto.ResDto;
import com.study.board.model.Board;
import com.study.board.model.Reply;
import com.study.board.model.User;
import com.study.board.service.BoardService;
import com.study.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    // 글 작성
    @PostMapping("/api/board")
    public ResDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){
        boardService.글쓰기(board, principal.getUser());
        return new ResDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }

    @DeleteMapping("/api/board{id}")
    public ResDto<Integer> deleteById(@PathVariable int id) {
        boardService.글삭제하기(id);
        return new ResDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/board{id}")
    public ResDto<Integer> update(@PathVariable int id, @RequestBody Board board) {
        boardService.글수정하기(id, board);
        return new ResDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/api/board/{boardId}/reply")
    public ResDto<Integer> replySave(@PathVariable int boardId, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal)
    {
        boardService.댓글쓰기(principal.getUser(), boardId, reply);
        return new ResDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }
}
