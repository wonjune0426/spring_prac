package com.example.spring_prac.controller;


import com.example.spring_prac.domain.Post;
import com.example.spring_prac.domain.PostRepository;
import com.example.spring_prac.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository;

    @GetMapping("/api/posts")
    public List<Post> getMemos(){return postRepository.findAllByOrderByCreatedAtDesc();}

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post=new Post(requestDto);
        return postRepository.save(post);
    }

//    @GetMapping("/api/posts/{id}")
//    public Post selectPost(@PathVariable Long id){
//        Post post=postRepository.getById(id);
//        return post;
//    }
}
