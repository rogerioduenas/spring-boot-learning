package com.rogerio.user_registration.dto;

import com.rogerio.user_registration.model.UserRole;

public record UserCreateDTO(String name, UserRole role) {
}
