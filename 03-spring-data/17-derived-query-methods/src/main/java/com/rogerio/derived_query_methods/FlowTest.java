package com.rogerio.derived_query_methods;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

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
    Person person2 = new Person("Anna");
    Person person3 = new Person("Mary");

    personRepository.save(person);
    personRepository.save(person2);
    personRepository.save(person3);

    personRepository.flush();

    System.out.println("\n=== 1. findByName ===");
    List<Person> res1 = personRepository.findByName("Mike");
    System.out.println("Return: " + res1);

    System.out.println("\n=== 2. findByNameIgnoreCase ===");
    List<Person> res2 = personRepository.findByNameIgnoreCase("mike");
    System.out.println("Return: " + res2);

    System.out.println("\n=== 3. findByNameContaining ===");
    List<Person> res3 = personRepository.findByNameContaining("ar");
    System.out.println("Return: " + res3);

    System.out.println("\n=== 4. findByNameContainingAndIdGreaterThan ===");
    List<Person> res4 = personRepository.findByNameContainingAndIdGreaterThan("M", 0);
    System.out.println("Return: " + res4);

    System.out.println("\n=== 5. findByNameContainingAndIdGreaterThanOrderByIdDesc ===");
    List<Person> res5 = personRepository.findByNameContainingAndIdGreaterThanOrderByIdDesc("M", 0);
    System.out.println("Return: " + res5);
  }
}
