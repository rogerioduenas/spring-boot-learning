package com.rogerio.http_response_customizer.dto;

import java.util.Map;

public record BatchProcessResponseDTO(String message, Map<String, Integer> summary) {}
