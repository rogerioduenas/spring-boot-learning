package com.rogerio.cascade_persist.service;

import com.rogerio.cascade_persist.model.Item;
import com.rogerio.cascade_persist.model.Order;
import com.rogerio.cascade_persist.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Transactional
  public Order createOrderWithItems(String orderNumber, List<Item> items){
    Order order = new Order();
    order.setOrderNumber(orderNumber);

    items.forEach(order::addItem);

    orderRepository.save(order);
    return order;
  }
}
