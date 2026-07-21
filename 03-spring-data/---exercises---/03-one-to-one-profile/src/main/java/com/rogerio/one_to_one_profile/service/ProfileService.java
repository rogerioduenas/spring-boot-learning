package com.rogerio.one_to_one_profile.service;

import com.rogerio.one_to_one_profile.model.Employee;
import com.rogerio.one_to_one_profile.model.EmployeeProfile;
import com.rogerio.one_to_one_profile.repository.EmployeeProfileRepository;
import com.rogerio.one_to_one_profile.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfileService {

  private final EmployeeRepository employeeRepository;
  private final EmployeeProfileRepository employeeProfileRepository;

  public ProfileService(EmployeeRepository employeeRepository, EmployeeProfileRepository employeeProfileRepository) {
    this.employeeRepository = employeeRepository;
    this.employeeProfileRepository = employeeProfileRepository;
  }

  @Transactional
  public EmployeeProfile createProfile(Long employeeId, String address, String phone) {
    Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new RuntimeException("Employee with id %s not found".formatted(employeeId)));

    EmployeeProfile employeeProfile = new EmployeeProfile(address, phone, employee);
    employee.setEmployeeProfile(employeeProfile);

    employeeProfileRepository.save(employeeProfile);
    return employeeProfile;
  }
}
