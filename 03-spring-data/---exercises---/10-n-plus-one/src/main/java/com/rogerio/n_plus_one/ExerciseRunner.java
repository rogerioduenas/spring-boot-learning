package com.rogerio.n_plus_one;

import com.rogerio.n_plus_one.model.Company;
import com.rogerio.n_plus_one.model.Employee;
import com.rogerio.n_plus_one.repository.CompanyRepository;
import com.rogerio.n_plus_one.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final CompanyRepository companyRepository;
  private final EmployeeRepository employeeRepository;
  private final EntityManager entityManager;

  public ExerciseRunner(CompanyRepository companyRepository, EmployeeRepository employeeRepository, EntityManager entityManager) {
    this.companyRepository = companyRepository;
    this.employeeRepository = employeeRepository;
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    Company company1 = new Company("Company 1");
    Company company2 = new Company("Company 2");
    Company company3 = new Company("Company 3");
    companyRepository.save(company1);
    companyRepository.save(company2);
    companyRepository.save(company3);
    companyRepository.flush();

    Employee employee1 = new Employee("Mike", company1);
    Employee employee2 = new Employee("John", company1);
    Employee employee3 = new Employee("Mary", company2);
    Employee employee4 = new Employee("Anna", company2);
    Employee employee5 = new Employee("Mario", company3);
    Employee employee6 = new Employee("Brian", company3);
    employeeRepository.save(employee1);
    employeeRepository.save(employee2);
    employeeRepository.save(employee3);
    employeeRepository.save(employee4);
    employeeRepository.save(employee5);
    employeeRepository.save(employee6);
    employeeRepository.flush();
    entityManager.clear();

    List<Company> companies = companyRepository.findAll();
//    List<Company> companies = companyRepository.findAllWithEmployees();

    for (Company company : companies) {
      System.out.printf("%s has %d employees%n", company.getName(), company.getEmployees().size());
    }
  }
}
