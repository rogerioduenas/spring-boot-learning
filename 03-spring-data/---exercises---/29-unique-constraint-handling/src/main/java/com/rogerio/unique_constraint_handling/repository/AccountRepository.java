package com.rogerio.unique_constraint_handling.repository;

import com.rogerio.unique_constraint_handling.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
