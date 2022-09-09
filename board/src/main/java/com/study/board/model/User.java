package com.study.board.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패던
// ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MySQL 테이블에 생성됨
// @Entity는 제일 밑에 있는게 좋음
//@DynamicInsert // insert시에 null인 필드를 제외시켜준다.
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 프로젝트에 연결된 DB의 넘버링 전략을 따라감
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30, unique = true) // 아이디가 없을 수 없음, 30자 제한, 중복거부
    private String username; // 아이디

    @Column(length = 100) // 해쉬를 변경할거임
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

//    @ColumnDefault("user")
    // DB는 RoleType이 없다.
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum을 쓰는게 좋다.// ADMIN, USER

    @CreationTimestamp // 시간이 자동으로 입력됨
    private Timestamp createDate;
}
