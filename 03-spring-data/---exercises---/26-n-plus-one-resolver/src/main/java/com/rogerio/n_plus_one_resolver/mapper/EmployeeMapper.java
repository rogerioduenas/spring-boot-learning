package com.rogerio.n_plus_one_resolver.mapper;

import com.rogerio.n_plus_one_resolver.dto.EmployeeDTO;
import com.rogerio.n_plus_one_resolver.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

  public EmployeeDTO employeeToEmployeeDTO(Employee employee) {
    return new EmployeeDTO(employee.getId(), employee.getName());
  }
}
