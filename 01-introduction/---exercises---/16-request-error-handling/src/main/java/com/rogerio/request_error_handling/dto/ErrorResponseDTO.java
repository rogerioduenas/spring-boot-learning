package com.rogerio.request_error_handling.dto;

import org.springframework.http.HttpStatus;

public record ErrorResponseDTO(String message, HttpStatus status) {}
