package com.sparta.homework1.exception;


import com.sparta.homework1.controller.CommentController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorResult argumentNotValidExHandler(MethodArgumentNotValidException e) {
        log.error("[exceptionHandler] ex", e);
        return new ErrorResult("EMPTY", "댓글 내용을 작성해주세요.");
    }
}
