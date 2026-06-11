package com.rogerio.flight_deals.service;

import com.rogerio.flight_deals.dto.ResponseFlightDealDTO;
import com.rogerio.flight_deals.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

  private final FlightRepository flightRepository;

  public FlightService(FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  public List<ResponseFlightDealDTO> filter(String origin, Double maxPrice) {
    List<ResponseFlightDealDTO> responseFlightDealDTOs = flightRepository.getFlights().stream()
        .filter(flight -> origin == null || flight.origin().equalsIgnoreCase(origin))
        .filter(flight -> maxPrice == null ||  flight.price() <= maxPrice)
        .map(flight -> new ResponseFlightDealDTO(
            flight.origin(),
            flight.destination(),
            flight.price(),
            isCheaper(flight.price())))
        .toList();

    return responseFlightDealDTOs;
  }

  private Boolean isCheaper(Double price) {
    return price < 500.0;
  }
}
