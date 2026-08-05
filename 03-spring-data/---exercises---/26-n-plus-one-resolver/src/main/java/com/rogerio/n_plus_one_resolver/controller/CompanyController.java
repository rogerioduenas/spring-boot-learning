package com.rogerio.n_plus_one_resolver.controller;

import com.rogerio.n_plus_one_resolver.dto.CompanyDetailDTO;
import com.rogerio.n_plus_one_resolver.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @GetMapping("/companies/{id}/details")
  public ResponseEntity<CompanyDetailDTO> getCompany(@PathVariable("id") Long id) {
    CompanyDetailDTO dto = companyService.findByIdWithEmployees(id);
    return ResponseEntity.ok(dto);
  }
}
