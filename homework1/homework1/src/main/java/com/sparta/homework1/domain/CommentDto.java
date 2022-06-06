package com.sparta.homework1.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class CommentDto {

    private String name;
    private String comments;
}
