package com.rogerio.employee_registration.dto;

import com.rogerio.employee_registration.model.Role;

public record ResponseEmployeeDTO(Long id, String name, Role role) {}
