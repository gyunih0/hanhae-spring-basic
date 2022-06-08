package com.sparta.homework1.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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
    @Column(name = "BOARD_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy = "board")
    private final List<Comment> commentList = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String article;

    public void update(BoardDto boardDto) {
        this.name = boardDto.getName();
        this.title = boardDto.getTitle();
        this.article = boardDto.getArticle();
    }


}
