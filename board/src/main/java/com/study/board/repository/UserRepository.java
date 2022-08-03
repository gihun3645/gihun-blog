package com.study.board.repository;

import com.study.board.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
// 자동으로 bean 등록이 된다.
// @Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {
    // 뭔지 모르겠음
    
}
