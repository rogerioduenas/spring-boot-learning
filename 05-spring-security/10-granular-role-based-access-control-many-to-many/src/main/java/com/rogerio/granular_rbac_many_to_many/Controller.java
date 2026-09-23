package com.rogerio.granular_rbac_many_to_many;

import com.rogerio.granular_rbac_many_to_many.Repository.UserRepository;
import com.rogerio.granular_rbac_many_to_many.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class Controller {

  private final UserRepository userRepository;

  public Controller(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('USER_READ')")
  public ResponseEntity<List<Employee>> findAll() {
    List<Employee> employees = userRepository.findAll().stream()
        .filter(Employee.class::isInstance)
        .map(Employee.class::cast)
        .toList();

    return ResponseEntity.ok(employees);
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<Employee> findById(@PathVariable Long id) {
    return userRepository.findById(id)
        .filter(Employee.class::isInstance)
        .map(Employee.class::cast)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}
