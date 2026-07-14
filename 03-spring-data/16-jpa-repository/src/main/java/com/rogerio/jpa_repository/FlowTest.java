package com.rogerio.jpa_repository;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlowTest implements CommandLineRunner {

  private final PersonRepository personRepository;

  public FlowTest(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    Person person = new Person("Mike");
    personRepository.save(person);

    Long count = personRepository.count();
    System.out.printf("Person count: %d\n", count);
  }
}
