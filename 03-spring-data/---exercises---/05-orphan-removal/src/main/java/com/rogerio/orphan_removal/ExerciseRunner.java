package com.rogerio.orphan_removal;

import com.rogerio.orphan_removal.model.Item;
import com.rogerio.orphan_removal.model.Order;
import com.rogerio.orphan_removal.repository.OrderRepository;
import com.rogerio.orphan_removal.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final OrderService orderService;
  private final OrderRepository orderRepository;

  public ExerciseRunner(OrderService orderService, OrderRepository orderRepository) {
    this.orderService = orderService;
    this.orderRepository = orderRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Order order = new Order(UUID.randomUUID().toString());
    List<Item> items = new ArrayList<>(List.of(
        new Item("Tv", 299.0),
        new Item("Keyboard", 29.9),
        new Item("Phone", 12.9)
    ));
    items.forEach(order::addItem);

    order = orderRepository.save(order);

    Long orderId = order.getId();
    Long itemId = order.getItems().get(1).getId();

    orderService.removeItemFromOrder(orderId, itemId);
  }
}
