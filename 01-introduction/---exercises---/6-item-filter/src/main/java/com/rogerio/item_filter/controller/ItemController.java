package com.rogerio.item_filter.controller;

import com.rogerio.item_filter.dto.ItemResponseDTO;
import com.rogerio.item_filter.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compare")
public class ItemController {

  private final ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping
  public ResponseEntity<List<ItemResponseDTO>> getItems(@RequestParam List<Long> ids) {
    List<ItemResponseDTO> items = itemService.findByIds(ids);
    return ResponseEntity.ok(items);
  }
}
