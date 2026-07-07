package com.rogerio.join_column_mappedBy;

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

    Employee employee = new Employee("Mike");
    Email email = new Email("mike@mike.com");

    employee.getEmails().add(email);
    entityManager.persist(employee);

    email.setEmployee(employee);
    entityManager.persist(email);
  }
}
