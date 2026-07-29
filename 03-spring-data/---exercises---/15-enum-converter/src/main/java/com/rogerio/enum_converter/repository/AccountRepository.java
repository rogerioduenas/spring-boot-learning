package com.rogerio.enum_converter.repository;

import com.rogerio.enum_converter.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
