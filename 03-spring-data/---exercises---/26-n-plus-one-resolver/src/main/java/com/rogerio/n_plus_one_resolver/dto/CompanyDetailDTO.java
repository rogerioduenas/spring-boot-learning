package com.rogerio.n_plus_one_resolver.dto;

import java.util.List;

public record CompanyDetailDTO(Long id, String name, List<EmployeeDTO> employees) {
}
