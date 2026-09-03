package com.rogerio.data_jpa_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TestEntityManager entityManager;

  // Insertion
  @Test
  void givenUser_whenSaved_thenCanBeFoundById() {
    User user = userRepository.save(new User("Mike", "12345"));
    entityManager.flush();
    entityManager.clear();

    User savedUser = userRepository.findById(user.getId()).orElseThrow();

    assertEquals("Mike", savedUser.getUsername());
    assertEquals("12345", savedUser.getPassword());
  }

  // Update
  @Test
  void givenUser_whenUpdated_thenCanBeFoundByIdWithUpdatedData() {
    User user = userRepository.save(new User("Mike", "12345"));

    user.setUsername("Anna");
    userRepository.save(user);
    entityManager.flush();
    entityManager.clear();

    User updatedUser = userRepository.findById(user.getId()).orElseThrow();

    assertNotNull(updatedUser);
    assertEquals("Anna", updatedUser.getUsername());
  }

  // findByUsername using saveAndFlush
  @Test
  void givenUser_whenFindByUsernameCalled_thenUserIsFound() {
    userRepository.saveAndFlush(new User("Mike", "12345"));
    entityManager.clear();

    User foundUser = userRepository.findByUsername("Mike");

    assertNotNull(foundUser);
    assertEquals("Mike", foundUser.getUsername());
  }
}