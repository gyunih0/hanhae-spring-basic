package com.sparta.homework1.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped {

    public Board(BoardDto boardDto) {
        this.name = boardDto.getName();
        this.title = boardDto.getTitle();
        this.article = boardDto.getArticle();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String article;
}
