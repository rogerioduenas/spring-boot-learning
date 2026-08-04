package com.rogerio.transaction_rollback.repository;

import com.rogerio.transaction_rollback.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
