package com.study.board.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private int id;
    private String username; // final은 불변성 때문에 함
    private String password;
    private String email;
}
