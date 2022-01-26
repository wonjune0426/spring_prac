package com.example.spring_prac.domain;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String contents;
    private String writer;
}
