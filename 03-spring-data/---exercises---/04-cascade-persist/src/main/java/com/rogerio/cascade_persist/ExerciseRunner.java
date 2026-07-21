package com.rogerio.cascade_persist;

import com.rogerio.cascade_persist.model.Item;
import com.rogerio.cascade_persist.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final OrderService orderService;

  public ExerciseRunner(OrderService orderService) {
    this.orderService = orderService;
  }

  @Override
  public void run(String... args) throws Exception {
    List<Item> items = new ArrayList<>(List.of(
        new Item("Tv", 499.0),
        new Item("Laptop", 299.0),
        new Item("Mouse", 12.99)
    ));

    orderService.createOrderWithItems(UUID.randomUUID().toString(), items);
  }
}
