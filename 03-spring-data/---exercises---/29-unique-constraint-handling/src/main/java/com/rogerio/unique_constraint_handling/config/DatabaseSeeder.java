package com.rogerio.unique_constraint_handling.config;

import com.rogerio.unique_constraint_handling.model.Account;
import com.rogerio.unique_constraint_handling.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final AccountRepository accountRepository;

  public DatabaseSeeder(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    if (accountRepository.count() == 0) {
      accountRepository.save(new Account("mike@mike.com", "123-456"));
    }
  }
}
