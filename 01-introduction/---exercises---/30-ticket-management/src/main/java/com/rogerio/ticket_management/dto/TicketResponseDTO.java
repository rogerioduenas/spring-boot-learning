package com.rogerio.ticket_management.dto;

import com.rogerio.ticket_management.model.Priority;

public record TicketResponseDTO(Long id, String title, Priority priority, String statusText) {}
