package com.study.board.service;

import com.study.board.model.Board;
import com.study.board.model.RoleType;
import com.study.board.model.User;
import com.study.board.repository.BoardRepository;
import com.study.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC(메모리에 대신 띄워줌) 해준다.
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional // 성공하면 커밋, 실패하면 롤백
    public void 글쓰기(Board board,User user) { // title, content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }
}
