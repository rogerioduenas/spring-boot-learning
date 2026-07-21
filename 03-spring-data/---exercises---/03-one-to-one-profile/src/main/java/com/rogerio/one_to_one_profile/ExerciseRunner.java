package com.rogerio.one_to_one_profile;

import com.rogerio.one_to_one_profile.model.Employee;
import com.rogerio.one_to_one_profile.repository.EmployeeProfileRepository;
import com.rogerio.one_to_one_profile.repository.EmployeeRepository;
import com.rogerio.one_to_one_profile.service.EmployeeService;
import com.rogerio.one_to_one_profile.service.ProfileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final EmployeeRepository employeeRepository;
  private final ProfileService profileService;
  private final EmployeeService employeeService;

  public ExerciseRunner(EmployeeProfileRepository employeeProfileRepository, EmployeeRepository employeeRepository, ProfileService profileService, EmployeeService employeeService) {
    this.employeeRepository = employeeRepository;
    this.profileService = profileService;
    this.employeeService = employeeService;
  }

  @Override
  public void run(String... args) throws Exception {
    Employee employee = employeeRepository.save(new Employee("Mike"));
    Employee employee2 = employeeRepository.save(new Employee("John"));

    profileService.createProfile(employee.getId(), "First Street 001", "0000-1111");
    profileService.createProfile(employee2.getId(), "Second Street 002", "0000-2222");

    employeeService.deleteEmployee(1L);
  }
}
