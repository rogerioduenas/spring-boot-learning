package com.rogerio.identifiers;

import com.rogerio.identifiers.pk.OrderItemId;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

  @EmbeddedId
  private OrderItemId orderItemId =  new OrderItemId();

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private Order order;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private Product product;

  private Integer quantity;
  private Double price;

  public OrderItem() {}

  public OrderItem(Order order, Product product, Integer quantity, Double price) {
    this.order = order;
    this.product = product;
    this.quantity = quantity;
    this.price = price;
  }

  public OrderItemId getOrderItemId() {
    return orderItemId;
  }

  public void setOrderItemId(OrderItemId orderItemId) {
    this.orderItemId = orderItemId;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
