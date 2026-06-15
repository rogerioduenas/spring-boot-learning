package com.rogerio.ticket_management.dto;

import com.rogerio.ticket_management.model.Priority;

public record TicketRequestDTO(String title, String description, Priority priority) {}
