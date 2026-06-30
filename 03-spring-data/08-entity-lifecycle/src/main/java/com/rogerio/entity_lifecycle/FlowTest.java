package com.rogerio.entity_lifecycle;

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
    Article article = new Article("Original Title", "INTERNAL");

    entityManager.persist(article);

    System.out.println("--- Checkpoint: persist executed ---");

    article.setTitle("Changed Title by Managed State");

    System.out.println("--- Checkpoint: End of method (Transaction commit is about to happen) ---");
  }
}