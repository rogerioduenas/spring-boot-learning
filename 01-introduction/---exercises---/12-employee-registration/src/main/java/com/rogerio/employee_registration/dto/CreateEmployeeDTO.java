package com.rogerio.employee_registration.dto;

import com.rogerio.employee_registration.model.Role;

public record CreateEmployeeDTO(String name, Role role, Double salary) {}
