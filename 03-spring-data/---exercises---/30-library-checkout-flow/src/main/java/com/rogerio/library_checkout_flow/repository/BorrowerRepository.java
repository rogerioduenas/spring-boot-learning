package com.rogerio.library_checkout_flow.repository;

import com.rogerio.library_checkout_flow.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
