package com.study.board.controller.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResDto<T> {

    int status;
    T data;
}
