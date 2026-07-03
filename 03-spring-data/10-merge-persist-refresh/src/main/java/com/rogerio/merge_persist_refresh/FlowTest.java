package com.rogerio.merge_persist_refresh;

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

    System.out.println("\n----- SCENARIO 1: PERSIST -----");

    Person p1 = new Person();
    p1.setName("John");

    entityManager.persist(p1);
    p1.setName("John Updated");

    entityManager.flush();

    // -----------------------------------------------------------

    System.out.println("\n----- SCENARIO 2: MERGE -----");

    entityManager.clear();

    p1.setName("Mary");
    Person managedPerson = entityManager.merge(p1);

    p1.setName("This Will Be Ignored");
    managedPerson.setName("Mary Successful");

    entityManager.flush();

    // -----------------------------------------------------------

    System.out.println("\n----- SCENARIO 3: REFRESH -----");

    Person p3 = new Person();
    p3.setName("Original Name");
    entityManager.persist(p3);
    entityManager.flush();

    p3.setName("Dirty Name Altered Locally");

    entityManager.refresh(p3);

    System.out.println("Result after refresh: " + p3.getName());

    System.out.println("\n----- END OF EXECUTION -----");
  }
}
