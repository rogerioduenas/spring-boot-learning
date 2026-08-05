package com.rogerio.n_plus_one_resolver.service;

import com.rogerio.n_plus_one_resolver.dto.CompanyDetailDTO;
import com.rogerio.n_plus_one_resolver.exception.ResourceNotFoundException;
import com.rogerio.n_plus_one_resolver.mapper.CompanyMapper;
import com.rogerio.n_plus_one_resolver.model.Company;
import com.rogerio.n_plus_one_resolver.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  private final CompanyRepository companyRepository;
  private final CompanyMapper companyMapper;

  public CompanyService(CompanyRepository companyRepository, CompanyMapper companyMapper) {
    this.companyRepository = companyRepository;
    this.companyMapper = companyMapper;
  }

  public CompanyDetailDTO findByIdWithEmployees(Long id) {
    Company company = companyRepository.findByIdWithEmployees(id)
        .orElseThrow(() -> new ResourceNotFoundException("Company with id " + id + " not found"));
    return companyMapper.companyToCompanyDetailDTO(company);
  }
}
