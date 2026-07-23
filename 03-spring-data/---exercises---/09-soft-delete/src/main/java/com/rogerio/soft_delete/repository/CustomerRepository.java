package com.rogerio.soft_delete.repository;

import com.rogerio.soft_delete.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
