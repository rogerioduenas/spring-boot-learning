package com.rogerio.transaction_rollback.config;

import com.rogerio.transaction_rollback.model.Wallet;
import com.rogerio.transaction_rollback.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final WalletRepository walletRepository;

  public DatabaseSeeder(WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    if (walletRepository.count() == 0) {
      walletRepository.save(new Wallet("Mike", BigDecimal.valueOf(2000)));
      walletRepository.save(new Wallet("Anna", BigDecimal.valueOf(0)));
    }
  }
}
