package com.rogerio.cascade_persist.repository;

import com.rogerio.cascade_persist.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
