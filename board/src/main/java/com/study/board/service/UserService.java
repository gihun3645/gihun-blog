package com.study.board.service;

import com.study.board.model.User;
import com.study.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC(메모리에 대신 띄워줌) 해준다.
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 서비스 함수
    @Transactional // 성공하면 커밋, 실패하면 롤백
    public int 회원가입(User user) {
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("UserService : 회원가입 : "+e.getMessage());
        }
        return -1;
    }
}
