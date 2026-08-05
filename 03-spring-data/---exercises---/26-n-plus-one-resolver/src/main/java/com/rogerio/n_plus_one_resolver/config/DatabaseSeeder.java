package com.rogerio.n_plus_one_resolver.config;

import com.rogerio.n_plus_one_resolver.model.Company;
import com.rogerio.n_plus_one_resolver.model.Employee;
import com.rogerio.n_plus_one_resolver.repository.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  private final CompanyRepository companyRepository;

  public DatabaseSeeder(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    if (companyRepository.count() == 0) {
      Company company = new Company("Google");
      List<Employee> employees = new ArrayList<>(List.of(
          new Employee("Mike"),
          new Employee("Bob"),
          new Employee("Anna")
      ));
      employees.forEach(company::addEmployee);
      companyRepository.save(company);
    }
  }
}
