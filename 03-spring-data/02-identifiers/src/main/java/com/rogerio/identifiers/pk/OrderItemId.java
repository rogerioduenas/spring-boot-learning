package com.rogerio.identifiers.pk;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class OrderItemId implements Serializable {

  private Long orderId;
  private UUID productId;

  public OrderItemId() {}

  public Long getOrderId() {
    return orderId;
  }

  public UUID getProductId() {
    return productId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    OrderItemId that = (OrderItemId) o;
    return Objects.equals(getOrderId(), that.getOrderId()) && Objects.equals(getProductId(), that.getProductId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getOrderId(), getProductId());
  }
}
