package com.rogerio.pagination;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlowTest implements CommandLineRunner {

  private final EntityManager entityManager;
  private final EmployeeRepository employeeRepository;

  public FlowTest(EntityManager entityManager, EmployeeRepository employeeRepository) {
    this.entityManager = entityManager;
    this.employeeRepository = employeeRepository;
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    Employee employee = new Employee("Mike", "Developer", 2000.0);
    Employee employee2 = new Employee("Mary", "Tech lead", 5000.0);
    Employee employee3 = new Employee("Anna", "Tech lead", 6000.0);
    Employee employee4 = new Employee("Brian", "Developer", 3000.0);
    entityManager.persist(employee);
    entityManager.persist(employee2);
    entityManager.persist(employee3);
    entityManager.persist(employee4);
    entityManager.flush();

    Pageable pageWithTwoElements = PageRequest.of(1, 2);

    Page<Employee> allEmployees = employeeRepository.findAll(pageWithTwoElements);
    System.out.println(allEmployees.getContent());

    List<Employee> allTechLeads = employeeRepository.findAllByRole("Tech lead", pageWithTwoElements);
    allTechLeads.forEach(System.out::println);

    Pageable sortedByPriceDescNameAsc =
        PageRequest.of(0, 6, Sort.by("salary").descending().and(Sort.by("name")));
    Page<Employee> sortedEmployees = employeeRepository.findAll(sortedByPriceDescNameAsc);
    System.out.println(sortedEmployees.getContent());
  }
}
