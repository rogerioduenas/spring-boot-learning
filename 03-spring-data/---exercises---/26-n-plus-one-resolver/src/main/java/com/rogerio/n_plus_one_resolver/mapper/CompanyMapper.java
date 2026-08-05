package com.rogerio.n_plus_one_resolver.mapper;

import com.rogerio.n_plus_one_resolver.dto.CompanyDetailDTO;
import com.rogerio.n_plus_one_resolver.dto.EmployeeDTO;
import com.rogerio.n_plus_one_resolver.model.Company;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyMapper {

  private final EmployeeMapper employeeMapper;

  public CompanyMapper(EmployeeMapper employeeMapper) {
    this.employeeMapper = employeeMapper;
  }

  public CompanyDetailDTO companyToCompanyDetailDTO(Company company) {
    List<EmployeeDTO> employeeDTOS = company.getEmployees().stream()
        .map(employeeMapper::employeeToEmployeeDTO)
        .toList();
    return new CompanyDetailDTO(company.getId(), company.getName(), employeeDTOS);
  }
}
