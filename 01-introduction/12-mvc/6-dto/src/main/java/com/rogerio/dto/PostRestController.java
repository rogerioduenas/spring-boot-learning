package com.rogerio.dto;

import org.springframework.web.bind.annotation.*;

@RestController
public class PostRestController {

  //Entity/DB -> DTO
  @GetMapping("/{id}")
  public PostDto getPost(@PathVariable Long id) {

    Post post = new Post(id, "Entity title");

    return new PostDto(post.getId(),  post.getTitle());
  }

  //DTO -> Entity/DB
  @PostMapping
  public String createPost(@RequestBody PostDto postDto) {

    Post post = new Post(postDto.getId(), postDto.getTitle());

    return "Post created successfully: " + post.getTitle();
  }
}
