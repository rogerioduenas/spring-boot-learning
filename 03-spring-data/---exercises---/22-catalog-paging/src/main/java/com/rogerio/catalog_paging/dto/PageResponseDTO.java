package com.rogerio.catalog_paging.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponseDTO<T>(
    List<T> content,
    int totalPages,
    long totalElements
) {
  public PageResponseDTO(Page<T> page) {
    this(
        page.getContent(),
        page.getTotalPages(),
        page.getTotalElements()
    );
  }
}
