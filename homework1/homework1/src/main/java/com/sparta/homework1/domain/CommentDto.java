package com.sparta.homework1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CommentDto {
    private String name;

    @NotEmpty(message = "댓글 내용을 작성해주세요.")
    private String comments;
}
