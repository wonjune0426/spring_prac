package com.example.spring_prac.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor //기본생성자를 만든다.
@Getter
@Entity //테이블과 연계됨
public class Post extends Timestamped{ //생성,수정 시간을 자동으로 만들어줌
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String contents;

    public Post(String title,String writer,String contents){
        this.contents=contents;
        this.title=title;
        this.writer=writer;
    }

    public Post(PostRequestDto requestDto){
        this.writer=requestDto.getWriter();
        this.contents=requestDto.getContents();
        this.title=requestDto.getTitle();
    }
}
