package com.rogerio.order_creation.controller;

import com.rogerio.order_creation.dto.OrderRequestDTO;
import com.rogerio.order_creation.dto.OrderResponseDTO;
import com.rogerio.order_creation.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
    OrderResponseDTO dto = orderService.createOrder(orderRequestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }
}
