# 🏋️ Exercise 30 — The Final Challenge: Complete Ticket Management API

## 📝 Description

To finish on a high note, you will build the complete flow of a mini support ticket system. This exercise requires you to combine almost all the concepts learned throughout the course into a single workflow.

## ⚙️ Technical Objectives

Combine:

- `@RestController`
- `@Service`
- Constructor Injection
- Input/Output DTOs
- `@PathVariable`
- `@RequestParam`
- Manual Pagination
- `@Value`
- Global Error Handling
- AOP

## 📂 Required Structure

Entity:

- `Ticket` (`id`, `title`, `description`, `priority`, `isClosed`)

Input DTO:

- `TicketRequestDTO` (`title`, `description`, `priority`)

Output DTO:

- `TicketResponseDTO` (`id`, `title`, `priority`, `statusText`)

Exception:

- `TicketNotFoundException`

Aspect:

- `TicketLogAspect`

## 🎯 Routes and HTTP Methods

### POST `/tickets`

Creates a ticket.

**Response:** `201 Created`

### GET `/tickets?page=1&size=2`

Returns a paginated list of tickets.

**Response:** `200 OK`

### PATCH `/tickets/{id}/close`

Closes a ticket.

If the ID does not exist, an exception must be thrown and handled as a **404 Not Found** error.

## 📋 Functional Requirements

### AOP

Whenever a ticket is closed (`/close`), the Aspect must generate a console log containing the date and the ID of the resolved ticket.

### DTO

The `statusText` field in the output DTO must be calculated based on the entity's `isClosed` boolean value.

Examples:

- `true` → `"CLOSED"`
- `false` → `"IN PROGRESS"`

### YAML & `@Value`

The system must read the maximum number of tickets allowed in memory directly from `application.yaml`.

If the static ticket list reaches this limit, the Service must prevent the creation of new tickets by throwing an exception, which must be handled by the global Advice as a **400 Bad Request** response.

## 🧪 Postman Test Cases

- Create tickets until the maximum limit defined in the YAML file is reached.
- Request an invalid ticket ID and verify that the Advice formats the error correctly.
- Test pagination and validate the logs generated in the IDE console.