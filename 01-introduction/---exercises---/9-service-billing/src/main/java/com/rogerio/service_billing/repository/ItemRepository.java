package com.rogerio.service_billing.repository;

import com.rogerio.service_billing.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

  private List<Item> items = new ArrayList<>(List.of(
      new Item(1L, "Aleatory description", 50.00)
  ));

  public List<Item> getItems() {
    return items;
  }
}
