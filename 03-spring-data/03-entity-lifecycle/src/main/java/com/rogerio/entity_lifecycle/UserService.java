package com.rogerio.entity_lifecycle;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  EntityManager entityManager;

  public UserService(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Transactional
  public Long saveUser(User user) {
    entityManager.persist(user);
    return user.getId();
  }
}
