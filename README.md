# 🍃 Spring Boot Backend Learning Journey

A repository focused on mastering the Spring ecosystem through a practical, progressive, and problem-oriented approach.

---

# 📖 About the Repository

This repository represents the continuation of the [Java Backend Learning Journey](https://github.com/rogerioduenas/java-learning), expanding the knowledge acquired from the language fundamentals into modern backend application development using the Spring ecosystem.

The learning path evolves from Spring Boot fundamentals to advanced concepts such as persistence, query optimization, REST API architecture, testing, and security.

### 🎯 Main Objectives

- Structured and progressive learning
- Practice-driven development approach
- Real-world inspired applications
- Focus on clean architecture, best practices, and performance

---

## 📂 Repository Philosophy

This repository represents a transition toward a self-directed learning approach.

Previous technologies were learned through structured courses and guided content. For this journey, I intentionally changed my learning process by researching the required skills, creating my own roadmap, and studying each topic through official documentation, technical articles, and trusted resources.

Instead of following a predefined course structure, each concept was explored through implementation, reinforced by independent practical exercises focused on solving backend problems, modeling real-world domains, and building maintainable solutions.

The goal was not only to learn Spring Boot and Docker, but also to develop the ability to independently identify learning paths, research solutions, and acquire new technologies throughout a developer's career.

# 🧩 Project Structure

The repository is organized into major learning modules, where each stage represents a natural evolution in backend application development.

## 📚 Learning Phases

```text
Spring Boot Fundamentals
          │
          ▼
REST API Development
          │
          ▼
🐳 Docker Environment
          │
          ▼
Spring Data JPA
          │
          ▼
Spring Testing
          │
          ▼
Spring Security
```

Each module introduces new concepts while building upon previously acquired knowledge.

---

# 🐳 Journey Milestone: Docker

Before entering the persistence layer, a dedicated Docker module was introduced to establish a development environment closer to real-world applications.

**Starting from the Spring Data JPA module:**

- Each exercise becomes a fully independent Spring Boot application
- Each project has its own Docker environment
- Isolated database configuration
- Independent setup
- Fully decoupled execution from other exercises

This approach allows every project to be executed and studied individually, simulating real backend applications.

---

# 🗺️ Learning Path

| Module | Content | Status | Exercises |
|--------|---------|--------|--------|
| 00 | [Hello World](00-Hello-World) | ✅ Completed | 00 |
| 01 | [Spring Boot Fundamentals](01-introduction) | ✅ Completed | [15](01-introduction/---exercises---) |
| 01 → 12-mvc | [Spring MVC & REST APIs](01-introduction/12-mvc) | ✅ Completed | [15](01-introduction/---exercises---) |
| 02 | [Docker Environment](02-docker/hello-docker) | ✅ Completed | 00 |
| 03 | [Spring Data JPA](03-spring-data) | ✅ Completed | [30](03-spring-data) |
| 04 | [Spring Testing](04-spring-testing) | ✅ Completed | [10](04-spring-testing/exercises/src/main/java/com/rogerio) |
| 05 | [Spring Security](05-spring-security) | ✅ Completed | 00 |
|  |  | Total Exercises | 70 |

---

# 🏋️ Practical Exercises

Hands-on practice is the core of this repository.

Instead of small isolated examples, this learning journey is composed of multiple independent projects that simulate challenges commonly found in backend development.

## 📊 Overview

- ✅ 70 practical exercises across Spring Boot and Spring Data JPA modules
- ✅ Each exercise is an independent Spring Boot project
- ✅ Each exercise contains its own technical `README.md`
- ✅ Each exercise solves a specific backend problem
- ✅ Complete project structure and organization
- ✅ Starting from Spring Data JPA, every exercise includes its own Docker environment

---

## 🧠 What Each Exercise Includes

Depending on the topic, projects may contain:

- Controllers
- Services
- DTOs
- Mappers
- Entities
- Repositories
- Bean Validation
- Global Exception Handling
- Business rules
- Custom configurations
- Individual documentation

---

# 🚀 Main Topics Covered

## Spring Boot

- Dependency Injection
- Bean Scopes
- Properties and YAML Configuration
- IoC Container
- AOP
- MVC Architecture
- REST API Design
- ResponseEntity Handling
- DTO Mapping
- Exception Handling
- Pagination
- HTTP Headers
- Externalized Configuration

---

## Spring Data JPA & Hibernate

- Entity Modeling
- Entity Relationships
- Cascade Operations
- Orphan Removal
- Transactions
- Rollback Strategies
- Soft Delete
- Lazy Loading
- N+1 Query Problem
- JOIN FETCH Optimization
- Projections
- Derived Queries
- Custom Queries
- Pagination and Sorting
- Attribute Converter
- Database Constraints
- Query Performance Optimization

---

## Spring Testing

- Spring Context Integration (`@SpringJUnitConfig`, `@SpringJUnitWebConfig`)
- Mocking Beans in Spring Context (`@MockitoBean` / `@MockBean`)
- `@Mock` vs `@MockBean` / `@MockitoBean` Differences
- Dependency Injection in Tests (`@Autowired`)
- Persistence Layer Testing (`@DataJpaTest`)
- Transactional Rollback Strategies
- Web Layer Slice Testing (`@WebMvcTest`)
- Controller Request & Response Verification with `MockMvc`
- JSON Serialization & Deserialization Testing
- External HTTP API Mocking with `MockRestServiceServer`
- Full Integration Testing (`@SpringBootTest`)
- Random Port Testing (`WebEnvironment.RANDOM_PORT`)

---

## Spring Security

- Modern `SecurityFilterChain` Bean Configuration
- Custom Security Filters (`OncePerRequestFilter`)
- Security Context & User Retrieval (`SecurityContextHolder`)
- Public Endpoint Exposure (`permitAll()` vs `web.ignoring()`)
- Custom `AuthenticationProvider` Implementation
- Programmatic & Manual User Authentication
- Global Security Exception Handling (`@RestControllerAdvice`)
- Granted Authorities vs Roles Architecture
- Role-Based Access Control (RBAC) & Fine-Grained Permissions
- Method-Level Security (`@PreAuthorize`) & Custom Meta-Annotations
- API Key Authentication Filters
- Stateless JWT Architecture (Token Generation, Validation & Filters)
- CSRF & Session Management (`SessionCreationPolicy.STATELESS`)
- Password Hashing with `BCryptPasswordEncoder` (HashGuard)

---

# 🚀 How to Run

Each module was designed to be studied independently.

For the initial modules, simply open the project in your IDE and run the application.

Starting from the **Spring Data JPA module**, each project provides its own Docker infrastructure for database execution.

---

# 🛠 Technologies Used

- Java 21 (Temurin)
- Spring Boot
- Spring MVC
- Spring Data JPA
- Spring Security
- Spring AOP
- Hibernate
- Bean Validation
- JUnit 5 (Jupiter Engine)
- Mockito 5
- Spring Testing (`@SpringBootTest`, `@WebMvcTest`, `@DataJpaTest`, `MockMvc`)
- JWT (JSON Web Tokens)
- BCrypt
- Docker & Docker Compose
- PostgreSQL & MySQL
- Maven
- IntelliJ IDEA


---

## 🎯 Next Milestone: Production-Grade Capstone Application

With the core Spring Boot ecosystem established, the next milestone in this self-directed journey is the architecture and development of an **End-to-End Production-Grade Backend Application**.

This upcoming repository will integrate every skill mastered throughout these independent learning modules into a single, real-world domain solution:

- **Complete RESTful Service:** Full domain modeling with Spring Boot 3, Spring Data JPA, and Spring Security with JWT.
- **Containerized Infrastructure:** Multi-container setup using Docker & Docker Compose for isolated application and database runtime.
- **Performance & Data Integrity:** Query optimization (N+1 query prevention, `JOIN FETCH`, projections) and transactional consistency.
- **Automated Quality Assurance:** Comprehensive test suite featuring unit and integration slice tests (`@WebMvcTest`, `@DataJpaTest`, `@SpringBootTest`).
- **Clean Architecture & Best Practices:** Layered design, global exception handling, DTO mapping, and bean validations.

> 🛠️ *This capstone project is currently under architectural design and initial implementation.*
