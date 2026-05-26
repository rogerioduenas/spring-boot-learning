package com.rogerio.service_billing.controller;

import com.rogerio.service_billing.dto.ItemResponseDTO;
import com.rogerio.service_billing.dto.UpdatePriceRequest;
import com.rogerio.service_billing.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
public class ItemController {

  private final ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ItemResponseDTO> updateItemPrice(@PathVariable Long id, @RequestBody UpdatePriceRequest request) {
    return itemService.updateItemPrice(id, request)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.badRequest().build());
  }
}
