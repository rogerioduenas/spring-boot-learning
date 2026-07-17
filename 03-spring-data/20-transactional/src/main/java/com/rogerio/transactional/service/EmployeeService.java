package com.rogerio.transactional.service;

import com.rogerio.transactional.model.Employee;
import com.rogerio.transactional.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeService(EmployeeRepository repository) {
    this.employeeRepository = repository;
  }

  // THE PROXY ERROR (Silent self-invocation)
  public void parentMethod() {
    this.childMethod();
  }

  @Transactional
  public void childMethod() {
    employeeRepository.save(new Employee("Proxy Employee"));
    throw new RuntimeException("Forced error in Method: childMethod()");
  }

  // CHECKED EXCEPTION ERROR
  @Transactional
  public void checkedExceptionMethod() throws Exception {
    employeeRepository.saveAndFlush(new Employee("Employee Checked"));
    throw new Exception("Forced error (Checked Exception)");
  }

  // CHECKED EXCEPTION FIX (Explicit rollbackFor)
  @Transactional(rollbackFor = Exception.class)
  public void checkedExceptionMethodCorrect() throws Exception {
    employeeRepository.saveAndFlush(new Employee("Employee Checked Correct"));
    throw new Exception("Forced error (Checked Exception Correct)");
  }
}
