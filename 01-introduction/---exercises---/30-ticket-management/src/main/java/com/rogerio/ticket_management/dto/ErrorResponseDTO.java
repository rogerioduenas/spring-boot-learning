package com.rogerio.ticket_management.dto;

import org.springframework.http.HttpStatus;

public record ErrorResponseDTO(HttpStatus status, String message) {}
