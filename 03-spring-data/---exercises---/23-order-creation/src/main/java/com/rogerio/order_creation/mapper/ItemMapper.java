package com.rogerio.order_creation.mapper;

import com.rogerio.order_creation.dto.ItemRequestDTO;
import com.rogerio.order_creation.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

  public OrderItem toEntity(ItemRequestDTO dto) {
    return new OrderItem(dto.productName(), dto.price());
  }
}
