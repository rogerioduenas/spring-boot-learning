package com.rogerio.cascade_types;

import com.rogerio.cascade_types.entities.Address;
import com.rogerio.cascade_types.entities.Person;
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

    // CascadeType.PERSIST
    Person person = new Person();
    Address address = new Address();
    address.setPerson(person);
    person.getAddresses().add(address);

    entityManager.persist(person);

    entityManager.flush();
    entityManager.clear();

    // CascadeType.MERGE
    Person savedPerson = entityManager.find(Person.class, person.getId());
    Address savedAddress = savedPerson.getAddresses().get(0);

    savedPerson.setName("John Doe");
    savedAddress.setHouseNumber(12345);

    entityManager.merge(savedPerson);

    entityManager.flush();
    entityManager.clear();

    // CascadeType.REMOVE
    Person personToRemove = entityManager.find(Person.class, person.getId());
    entityManager.remove(personToRemove);

    entityManager.flush();
  }
}
