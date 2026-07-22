package com.rogerio.orphan_removal.repository;

import com.rogerio.orphan_removal.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
