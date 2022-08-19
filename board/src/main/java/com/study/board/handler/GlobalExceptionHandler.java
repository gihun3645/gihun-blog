package com.study.board.handler;

import com.study.board.controller.dto.ResDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResDto<String> handleArgumentException(Exception e) {

        return new ResDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
