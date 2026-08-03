package com.rogerio.order_creation.service;

import com.rogerio.order_creation.dto.OrderRequestDTO;
import com.rogerio.order_creation.dto.OrderResponseDTO;
import com.rogerio.order_creation.mapper.ItemMapper;
import com.rogerio.order_creation.mapper.OrderMapper;
import com.rogerio.order_creation.model.Order;
import com.rogerio.order_creation.model.OrderItem;
import com.rogerio.order_creation.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

  private final OrderRepository orderRepository;
  private final OrderMapper orderMapper;
  private final ItemMapper itemMapper;

  public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, ItemMapper itemMapper) {
    this.orderRepository = orderRepository;
    this.orderMapper = orderMapper;
    this.itemMapper = itemMapper;
  }

  @Transactional
  public OrderResponseDTO createOrder(OrderRequestDTO dto) {
    Order order = orderMapper.toEntity(dto);

    List<OrderItem> orderItems = dto.items().stream()
        .map(itemMapper::toEntity)
        .toList();

    orderItems.forEach(order::addItem);

    Order savedOrder = orderRepository.save(order);

    return orderMapper.toDTO(savedOrder);
  }
}
