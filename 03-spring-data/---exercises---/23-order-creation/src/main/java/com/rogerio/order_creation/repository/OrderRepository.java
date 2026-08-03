package com.rogerio.order_creation.repository;

import com.rogerio.order_creation.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
