package com.rogerio.sequence_allocation_order;

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
    MyHappyUser user = new MyHappyUser();
    System.out.printf("---------- Id BEFORE persist is ***%s*** ----------\n", user.getId());
    entityManager.persist(user);
    System.out.printf("---------- Id AFTER persist is ***%s*** ----------\n", user.getId());
    System.out.printf("---------- Method ends here! ----------");
  }
}
