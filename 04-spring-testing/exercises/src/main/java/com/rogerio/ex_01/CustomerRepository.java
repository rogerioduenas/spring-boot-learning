package com.rogerio.ex_01;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
  @Query("SELECT c FROM CustomerEntity c WHERE c.status = :status")
  Page<CustomerEntity> findByStatus(@Param("status") CustomerStatus status, Pageable pageable);
}