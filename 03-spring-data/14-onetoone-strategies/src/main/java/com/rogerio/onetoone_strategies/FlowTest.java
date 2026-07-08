package com.rogerio.onetoone_strategies;

import com.rogerio.onetoone_strategies.foreignKey.Address;
import com.rogerio.onetoone_strategies.foreignKey.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlowTest implements CommandLineRunner {

  private final EntityManager entityManager;

  public FlowTest(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
  Address address = new Address();
  entityManager.persist(address);

  User user = new User();
  user.setAddress(address);
  entityManager.persist(user);
  }
}
