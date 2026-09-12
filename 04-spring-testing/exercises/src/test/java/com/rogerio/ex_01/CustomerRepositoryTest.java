package com.rogerio.ex_01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  private CustomerEntity createCustomer(String name, String email, CustomerStatus status) {
    CustomerEntity customer = testEntityManager.persistAndFlush(new CustomerEntity(name, email, status));
    testEntityManager.clear();
    return customer;
  }

  @Test
  @DisplayName("Should return the first page, sorted by name, containing only active customers.")
  void givenCustomersInDatabase_whenFindByStatusActive_thenReturnPagedAndSortedFirstPage() {
    // Given
    createCustomer("User C", "c@email.com", CustomerStatus.ACTIVE);
    createCustomer("User A", "a@email.com", CustomerStatus.ACTIVE);
    createCustomer("User B", "b@email.com", CustomerStatus.ACTIVE);

    // When
    Page<CustomerEntity> pageResult = customerRepository.findByStatus(
        CustomerStatus.ACTIVE,
        PageRequest.of(0, 2, Sort.by("name").ascending())
    );

    // Then
    assertThat(pageResult.getTotalElements()).isEqualTo(3);
    assertThat(pageResult.getTotalPages()).isEqualTo(2);
    assertThat(pageResult.getContent()).hasSize(2);

    assertThat(pageResult.getContent())
        .extracting(CustomerEntity::getName)
        .containsExactly("User A", "User B");
  }

  @Test
  @DisplayName("Should return an empty page when there are no customers with the specified status")
  void givenCustomersInDatabase_whenFindByStatusWithoutMatches_thenReturnEmptyPage() {
    // Given
    createCustomer("User A", "a@email.com", CustomerStatus.ACTIVE);

    // When
    Page<CustomerEntity> pageResult = customerRepository.findByStatus(
        CustomerStatus.BLOCKED,
        PageRequest.of(0, 2)
    );

    // Then
    assertThat(pageResult.getTotalPages()).isEqualTo(0);
    assertThat(pageResult.getTotalElements()).isEqualTo(0);
    assertThat(pageResult.getContent()).isEmpty();
  }
}
