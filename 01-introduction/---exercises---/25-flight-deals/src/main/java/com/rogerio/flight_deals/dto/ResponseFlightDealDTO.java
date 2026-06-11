package com.rogerio.flight_deals.dto;

public record ResponseFlightDealDTO(String origin, String destination, Double price, Boolean isCheap) {}