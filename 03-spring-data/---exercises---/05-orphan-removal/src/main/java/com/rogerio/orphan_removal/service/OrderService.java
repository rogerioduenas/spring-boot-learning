package com.rogerio.orphan_removal.service;

import com.rogerio.orphan_removal.model.Order;
import com.rogerio.orphan_removal.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Transactional
  public void removeItemFromOrder(Long orderId, Long itemId) {
    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new RuntimeException("Order not found"));

    order.getItems().stream()
        .filter(item -> item.getId().equals(itemId))
        .findFirst()
        .ifPresent(order::removeItem);
  }
}
