package com.rogerio.unique_onstraints;

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
    Person person = new Person("mike", "mike@mike.com");
//    entityManager.persist(person);

    Worker worker = new Worker("Mike", 123, false);
    entityManager.persist(worker);
  }
}
