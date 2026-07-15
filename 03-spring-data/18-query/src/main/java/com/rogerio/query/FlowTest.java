package com.rogerio.query;

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

    System.out.println("\n=== 1. Testing findAllJpql ===");
    List<Person> res1 = personRepository.findAllJpql();
    System.out.println("Return: " + res1);

    System.out.println("\n=== 2. Testing findAllNative ===");
    List<Person> res2 = personRepository.findAllNative();
    System.out.println("Return: " + res2);

    System.out.println("\n=== 3. Testing findByNameJpqlNamed ===");
    List<Person> res3 = personRepository.findByNameJpqlNamed("Anna");
    System.out.println("Return: " + res3);

    System.out.println("\n=== 4. Testing findByNameNativeNamed ===");
    List<Person> res4 = personRepository.findByNameNativeNamed("Mike");
    System.out.println("Return: " + res4);
  }
}
