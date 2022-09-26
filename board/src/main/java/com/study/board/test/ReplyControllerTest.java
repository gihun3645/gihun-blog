package com.study.board.test;

import com.study.board.model.Board;
import com.study.board.model.Reply;
import com.study.board.repository.BoardRepository;
import com.study.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReplyControllerTest {


    // 무한 참조?
    @Autowired
    private BoardRepository boardRepository;

    @Autowired ReplyRepository replyRepository;

    @GetMapping("/test/board/{id}")
    public Board getBoard(@PathVariable int id) {
        return boardRepository.findById(id).get();
    }

    @GetMapping("/test/reply")
    public List<Reply> getReply() {
        return replyRepository.findAll();
    }
}
