package com.rogerio.enum_converter;

import com.rogerio.enum_converter.model.Account;
import com.rogerio.enum_converter.model.AccountStatus;
import com.rogerio.enum_converter.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final AccountRepository accountRepository;

  public ExerciseRunner(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Account account = new Account("Mike", AccountStatus.ACTIVE);
    accountRepository.save(account);

    accountRepository.findAll().forEach(System.out::println);
  }
}
