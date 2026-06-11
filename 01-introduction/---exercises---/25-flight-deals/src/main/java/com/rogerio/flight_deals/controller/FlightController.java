package com.rogerio.flight_deals.controller;

import com.rogerio.flight_deals.dto.ResponseFlightDealDTO;
import com.rogerio.flight_deals.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

  private final FlightService flightService;

  public FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  @GetMapping("/search")
  public ResponseEntity<List<ResponseFlightDealDTO>> searchFlights(
      @RequestParam(required = false) String origin,
      @RequestParam(required = false) Double maxPrice) {

    List<ResponseFlightDealDTO> responseFlightDealDTOs = flightService.filter(origin, maxPrice);

    return ResponseEntity.ok(responseFlightDealDTOs);
  }
}
