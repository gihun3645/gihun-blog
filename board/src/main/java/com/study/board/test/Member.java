package com.study.board.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 빈 생성자
public class Member {
    private int id;
    private String username; // final은 불변성 때문에 함
    private String password;
    private String email;


    @Builder
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
