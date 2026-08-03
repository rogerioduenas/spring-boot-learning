package com.rogerio.order_creation.mapper;

import com.rogerio.order_creation.dto.OrderRequestDTO;
import com.rogerio.order_creation.dto.OrderResponseDTO;
import com.rogerio.order_creation.model.Order;
import com.rogerio.order_creation.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

  public Order toEntity(OrderRequestDTO dto) {
    return new Order(dto.orderNumber());
  }

  public OrderResponseDTO toDTO(Order order) {
    return new OrderResponseDTO(
        order.getId(),
        order.getOrderNumber(),
        order.getItems().stream()
            .mapToDouble(OrderItem::getPrice)
            .sum()
    );
  }
}
