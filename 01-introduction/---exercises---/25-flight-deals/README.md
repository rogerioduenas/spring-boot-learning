# 🏋️ Exercise 25 — Flexible DTO with Optional Parameters

## 📝 Description

Create a flight search system. Users can submit complex filters, and the system must return a DTO shaped according to the business rules processed by the Service layer.

## ⚙️ Technical Objectives

- Combine optional parameter handling (`@RequestParam(required = false)`) with mapping to a customized output DTO.

## 📂 Required Structure

Entity:

- `Flight` (`id`, `origin`, `destination`, `price`, `availableSeats`)

Output DTO:

- `FlightDealsDTO` (`origin`, `destination`, `price`, `isCheap`)

## 🎯 Routes and HTTP Methods

### GET `/flights/search`

## 📋 Functional Requirements

- The Controller must accept `origin` and `maxPrice` as optional parameters.
- The Service must filter the flight list.
- If a flight's price is less than **USD 500.00**, the DTO field `isCheap` must be set to `true`; otherwise, it must be set to `false`.
- Return the mapped list of DTOs.

## 🧪 Postman Test Cases

Filter both inexpensive and expensive flights and verify that the calculated `isCheap` field in the DTO changes dynamically based on the flight price.