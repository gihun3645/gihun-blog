package com.study.board.model;


import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL 테이블에 생성됨
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 프로젝트에 연결된 DB의 넘버링 전략을 따라감
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30) // 아이디가 없을 수 없음, 30자 제한
    private String username; // 아이디

    @Column(nullable = false, length = 100) // 해쉬를 변경할거임
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role; // Enum을 쓰는게 좋다.// admin, user, manager 권한

    @CreationTimestamp // 시간이 자동으로 입력됨
    private Timestamp createDate;
}
