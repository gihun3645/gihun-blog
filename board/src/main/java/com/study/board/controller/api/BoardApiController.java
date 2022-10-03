package com.study.board.controller.api;


import com.study.board.config.auth.PrincipalDetail;
import com.study.board.controller.dto.ReplySaveRequestDto;
import com.study.board.controller.dto.ResDto;
import com.study.board.model.Board;
import com.study.board.service.BoardService;
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

    // 데이터를 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다.
    // 이건 작은 프로젝트라 dto 안씀

    @PostMapping("/api/board/{boardId}/reply")
    public ResDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto)
    {
        boardService.댓글쓰기(replySaveRequestDto);
        return new ResDto<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
    }

    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public ResDto<Integer> replyDelete(@PathVariable int replyId)
    {
        boardService.댓글삭제(replyId);
        return new ResDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
