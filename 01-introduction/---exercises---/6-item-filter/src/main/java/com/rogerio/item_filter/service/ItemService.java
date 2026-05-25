package com.rogerio.item_filter.service;

import com.rogerio.item_filter.dto.ItemResponseDTO;
import com.rogerio.item_filter.model.Item;
import com.rogerio.item_filter.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

  private final ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public List<ItemResponseDTO> findByIds(List<Long> ids) {
    List<Item> items = itemRepository.getItems();
    return items.stream()
        .filter(item -> ids.contains(item.id()))
        .map(item -> new ItemResponseDTO(item.id(), item.name()))
        .toList();
  }
}
