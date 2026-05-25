package com.rogerio.news_default_sorting.service;

import com.rogerio.news_default_sorting.dto.NewsResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

  public NewsResponseDTO getOrderedNews(String value){
    return new NewsResponseDTO(String.format("Results ordered by: %s", value));
  }
}
