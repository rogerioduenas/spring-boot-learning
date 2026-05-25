package com.rogerio.item_filter.repository;

import com.rogerio.item_filter.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

  private final List<Item> items = new ArrayList<>(List.of(
      new Item(10L, "Item 10"),
      new Item(20L, "Item 20"),
      new Item(30L, "Item 30"),
      new Item(40L, "Item 40")
  ));

  public List<Item> getItems() {
    return items;
  }
}
