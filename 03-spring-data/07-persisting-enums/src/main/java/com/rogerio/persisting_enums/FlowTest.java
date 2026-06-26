package com.rogerio.persisting_enums;

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
    Article article = new Article("Aleatory title", Type.EXTERNAL, Category.MUSIC);
    entityManager.persist(article);
  }
}
