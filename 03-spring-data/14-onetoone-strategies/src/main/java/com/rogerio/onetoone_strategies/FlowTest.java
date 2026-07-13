package com.rogerio.onetoone_strategies;

import com.rogerio.onetoone_strategies.SharedPK.Product;
import com.rogerio.onetoone_strategies.SharedPK.ProductDetail;
import com.rogerio.onetoone_strategies.foreignKey.Address;
import com.rogerio.onetoone_strategies.foreignKey.User;
import com.rogerio.onetoone_strategies.joinTable.Employee;
import com.rogerio.onetoone_strategies.joinTable.WorkStation;
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

    //  Foreign Key
    Address address = new Address();
    entityManager.persist(address);

    User user = new User();
    user.setAddress(address);
    entityManager.persist(user);

    //  Shared Primary Key
    Product product = new Product();
    product.setName("Notebook");

    ProductDetail detail = new ProductDetail();
    detail.setWeight(2.5);
    detail.setProduct(product);

    product.setDetails(detail);

    entityManager.persist(product);
    entityManager.persist(detail);

    // Join Table
    WorkStation workStation = new WorkStation();
    Employee employee = new Employee();

    employee.setWorkStation(workStation);
    workStation.setEmployee(employee);

    entityManager.persist(workStation);
    entityManager.persist(employee);
  }
}
