package com.rogerio.unidirectional_bidirectional_association;

import com.rogerio.unidirectional_bidirectional_association.bidirectional.manyToMany.Developer;
import com.rogerio.unidirectional_bidirectional_association.bidirectional.manyToMany.Project;
import com.rogerio.unidirectional_bidirectional_association.bidirectional.oneToMany.Order;
import com.rogerio.unidirectional_bidirectional_association.bidirectional.oneToMany.OrderItem;
import com.rogerio.unidirectional_bidirectional_association.unidirectional.manyToMany.Author;
import com.rogerio.unidirectional_bidirectional_association.unidirectional.manyToMany.Book;
import com.rogerio.unidirectional_bidirectional_association.unidirectional.manyToOne.School;
import com.rogerio.unidirectional_bidirectional_association.unidirectional.manyToOne.Student;
import com.rogerio.unidirectional_bidirectional_association.unidirectional.oneToMany.Department;
import com.rogerio.unidirectional_bidirectional_association.unidirectional.oneToMany.Employee;
import com.rogerio.unidirectional_bidirectional_association.unidirectional.oneToOne.Apartment;
import com.rogerio.unidirectional_bidirectional_association.unidirectional.oneToOne.ParkingSpot;
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

    // ---------- Unidirectional ----------

    // @OneToMany
    Employee employee = new Employee("Mike");
    entityManager.persist(employee);

    Department department = new Department("IT");
    department.getEmployees().add(employee);
    entityManager.persist(department);

    // @ManyToOne
    School school = new School("Java School");
    entityManager.persist(school);

    Student student = new Student("Mike");
    student.setSchool(school);
    entityManager.persist(student);

    // @OneToOne
    ParkingSpot parkingSpot = new ParkingSpot();
    entityManager.persist(parkingSpot);

    Apartment apartment = new Apartment();
    apartment.setParkingSpot(parkingSpot);
    entityManager.persist(apartment);

    // @ManyToMany
    Author author = new Author("Mike");
    entityManager.persist(author);

    Book book = new Book("Harry Potter");
    book.getAuthors().add(author);
    entityManager.persist(book);

    // ---------- Bidirectional ----------

    // @OneToMany
    Order order = new Order();
    OrderItem orderItem = new OrderItem("Keyboard");

    orderItem.setOrder(order);

    order.getItems().add(orderItem);

    entityManager.persist(order);

    entityManager.persist(orderItem);

    // @ManyToMany
    Developer dev = new Developer("Mike");
    entityManager.persist(dev);

    Project project = new Project("Sales System");

    project.getDevelopers().add(dev);

    entityManager.persist(project);
  }
}
