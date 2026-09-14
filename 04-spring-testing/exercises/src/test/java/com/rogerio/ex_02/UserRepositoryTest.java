package com.rogerio.ex_02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.catchThrowable;

@DataJpaTest
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Test
  @DisplayName("Should throw DataIntegrityViolationException when CPF is duplicate")
  void givenExistingUser_whenSaveAnotherUserWithSameCpf_thenThrowDataIntegrityViolationException() {
    // Given
    String duplicateCPF = "VALID_CPF";
    testEntityManager.persistAndFlush(new UserEntity("Mike", "mike@mike.com", duplicateCPF));
    testEntityManager.clear();

    // When
    Throwable exception = catchThrowable(() -> userRepository.saveAndFlush(new UserEntity("Anna", "anna@anna.com", duplicateCPF)));

    // Then
    assertThat(exception).isInstanceOf(DataIntegrityViolationException.class);
  }

  @Test
  @DisplayName("Should throw DataIntegrityViolationException when email is duplicate")
  void givenExistingUser_whenSaveAnotherUserWithSameEmail_thenThrowDataIntegrityViolationException() {
    // Given
    String duplicateEmail = "EMAIL@EMAIL.COM";
    testEntityManager.persistAndFlush(new UserEntity("Mike", duplicateEmail, "VALID_CPF_1"));
    testEntityManager.clear();

    // When
    Throwable exception = catchThrowable(() -> userRepository.saveAndFlush(new UserEntity("Anna", duplicateEmail, "VALID_CPF_2")));

    // Then
    assertThat(exception).isInstanceOf(DataIntegrityViolationException.class);
  }
}
