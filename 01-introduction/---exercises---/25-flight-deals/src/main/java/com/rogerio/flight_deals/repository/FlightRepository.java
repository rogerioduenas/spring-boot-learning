package com.rogerio.flight_deals.repository;

import com.rogerio.flight_deals.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FlightRepository {

  private final List<Flight> flights = new ArrayList<>(List.of(
      new Flight(1L, "GRU", "GIG", 120.00, 50),
      new Flight(2L, "GRU", "MIA", 450.00, 12),
      new Flight(3L, "GIG", "MIA", 390.00, 8),
      new Flight(4L, "LIS", "MAD", 85.00, 100),
      new Flight(5L, "JFK", "LAX", 250.00, 32),
      new Flight(6L, "GRU", "JFK", 650.00, 25),
      new Flight(7L, "GRU", "CDG", 890.00, 14),
      new Flight(8L, "GIG", "CDG", 920.00, 5),
      new Flight(9L, "JFK", "NRT", 1200.00, 20),
      new Flight(10L, "LIS", "GRU", 780.00, 40)
  ));

  public List<Flight> getFlights() {
    return flights;
  }
}
