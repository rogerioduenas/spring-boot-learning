package com.rogerio.ex_03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class AccountRepositoryTest {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  @DisplayName("Should update account balance directly in database when custom modifying query is executed")
  void givenAccountInDatabase_whenUpdateBalanceAndClearContext_thenReturnUpdatedBalanceFromDatabase() {
    // Given
    AccountEntity savedAccount = testEntityManager.persistAndFlush(new AccountEntity("OWNER", 100.0));
    testEntityManager.clear();

    // When
    accountRepository.updateBalance(savedAccount.getId(), 500.0);
    testEntityManager.flush();
    testEntityManager.clear();

    // Then
    AccountEntity updatedAccount = accountRepository.findById(savedAccount.getId()).orElseThrow();
    assertThat(updatedAccount.getBalance()).isEqualTo(500.0);
  }
}
