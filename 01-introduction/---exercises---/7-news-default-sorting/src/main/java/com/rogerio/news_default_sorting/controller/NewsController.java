package com.rogerio.news_default_sorting.controller;

import com.rogerio.news_default_sorting.dto.NewsResponseDTO;
import com.rogerio.news_default_sorting.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

  private final NewsService newsService;

  public NewsController(NewsService newsService) {
    this.newsService = newsService;
  }

  @GetMapping
  public ResponseEntity<NewsResponseDTO> getNewsOrderedBy(@RequestParam(defaultValue = "date") String orderBy){
    NewsResponseDTO newsResponseDTO = newsService.getOrderedNews(orderBy);
    return ResponseEntity.ok(newsResponseDTO);
  }
}
