package com.rogerio.custom_query_with_pagination;

import com.rogerio.custom_query_with_pagination.model.Department;
import com.rogerio.custom_query_with_pagination.model.User;
import com.rogerio.custom_query_with_pagination.repository.DepartmentRepository;
import com.rogerio.custom_query_with_pagination.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class ExerciseRunner implements CommandLineRunner {

  private final UserRepository userRepository;
  private final DepartmentRepository departmentRepository;

  public ExerciseRunner(UserRepository userRepository, DepartmentRepository departmentRepository) {
    this.userRepository = userRepository;
    this.departmentRepository = departmentRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Department department = departmentRepository.save(new Department("IT"));
    for (int i = 0; i < 10; i++) {
      String userName = "User " + i;
      Boolean active = i < 4;
      userRepository.save(new User(userName, active, department));
    }

    userRepository
        .findActiveUsersByDepartment("IT", PageRequest.of(0, 2))
        .forEach(System.out::println);
  }
}
