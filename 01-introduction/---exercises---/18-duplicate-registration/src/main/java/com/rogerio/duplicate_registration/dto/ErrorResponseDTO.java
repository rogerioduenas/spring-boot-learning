package com.rogerio.duplicate_registration.dto;

import org.springframework.http.HttpStatus;

public record ErrorResponseDTO(String message, HttpStatus status) {}
