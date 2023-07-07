package com.study.board.service;

import com.study.board.controller.dto.ReplySaveRequestDto;
import com.study.board.model.Board;
import com.study.board.model.User;
import com.study.board.repository.BoardRepository;
import com.study.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC(메모리에 대신 띄워줌) 해준다.
@Service
// autowired 를 붙이지 않고 사용하기
// @RequiredArgsConstructor
public class BoardService
    {

        // 이러하다.. 이러면 autowired 안써도 됨
        // private final BoardRepository boardRepository;
        // private final ReplyRepository replyRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;


    @Transactional // 성공하면 커밋, 실패하면 롤백
    public Board 글쓰기(Board board, User user)
    { // title, content
        board.setCount(0);
        board.setUser(user);
        board.setId(board.getId());
        boardRepository.save(board);
        return board;
    }

    @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public Board 글상세보기(int id)
    {
//        return boardRepository.findById(id)
//                .orElseThrow(()->{
//                    return new IllegalArgumentException("글 살세보기 실패:아이디를 찾을 수 없습니다.");
//                });
        Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 살세보기 실패:아이디를 찾을 수 없습니다.");
                });

        // 조회수 증가
        board.setCount(board.getCount() + 1);
        boardRepository.save(board);
        return board;
    }

    @Transactional
    public void 글삭제하기(int id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public Board 글수정하기(int id, Board requestBoard)
    {
        Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
                }); // 영속화 완료
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        board.setId(board.getId());
        boardRepository.save(board);
        return board;
    }

    @Transactional
    public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto)
    {
        int result = replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
        System.out.println("BoardService : "+result);
    }

    @Transactional
    public void 댓글삭제(int replyId)
    {
        replyRepository.deleteById(replyId);
    }
}
