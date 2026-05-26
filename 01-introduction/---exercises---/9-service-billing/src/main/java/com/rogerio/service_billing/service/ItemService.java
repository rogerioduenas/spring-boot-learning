package com.rogerio.service_billing.service;

import com.rogerio.service_billing.dto.ItemResponseDTO;
import com.rogerio.service_billing.dto.UpdatePriceRequest;
import com.rogerio.service_billing.model.Item;
import com.rogerio.service_billing.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

  private ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public Optional<ItemResponseDTO> updateItemPrice(Long id, UpdatePriceRequest request) {
    List<Item> items = itemRepository.getItems();

    return items.stream()
        .filter(item -> item.getId().equals(id))
        .findFirst()
        .map(item -> {
          item.setPrice(request.price());
          return new ItemResponseDTO(item.getId(), item.getDescription(), item.getPrice());
        });
  }
}
