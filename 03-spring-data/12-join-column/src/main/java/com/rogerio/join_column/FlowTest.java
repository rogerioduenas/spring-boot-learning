package com.rogerio.join_column;

import com.rogerio.join_column.joinColumn.oneToMany.Email;
import com.rogerio.join_column.joinColumn.oneToMany.Employee;
import com.rogerio.join_column.joinColumn.oneToOne.Address;
import com.rogerio.join_column.joinColumn.oneToOne.Office;
import com.rogerio.join_column.joinColumns.Product;
import com.rogerio.join_column.joinColumns.Stock;
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

    // ---------- JOIN COLUMN ----------

    // @OneToOne
    Address address = new Address("Tokyo");
    entityManager.persist(address);

    Office office = new Office();
    office.setAddress(address);
    entityManager.persist(office);

    // @OneToMany
    Employee employee = new Employee("Mike");
    Email email = new Email("email@email.com");

    email.setEmployee(employee);
    employee.getEmails().add(email);

    entityManager.persist(employee);
    entityManager.persist(email);

    // ---------- JOIN COLUMNS ----------

    Product product = new Product();
    product.setId(100L);
    product.setBarCode(1234567890);

    Stock stock = new Stock();
    stock.setProduct(product);

    entityManager.persist(product);
    entityManager.persist(stock);
  }
}
