package com.rogerio.flight_deals.model;

public record Flight(Long id, String origin, String destination, Double price, Integer availableSeats) {}
