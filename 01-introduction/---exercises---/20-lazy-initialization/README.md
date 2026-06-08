# 🏋️ Exercise 20 — Lazy Initialization with `@Lazy` for Dependencies

## 📝 Description

Simulate a scenario where two Services depend on each other during application startup (circular dependency), preventing the project from starting successfully. You will use lazy initialization to unblock the application.

## ⚙️ Technical Objectives

- Resolve architectural startup issues using the `@Lazy` annotation.

## 📂 Required Structure

Classes:

- `ServiceA` (Injects `ServiceB` through the constructor)
- `ServiceB` (Injects `ServiceA` through the constructor)

## 📋 Functional Requirements

If you try to run the project as-is, Spring will throw a `BeanCurrentlyInCreationException` in the console, causing the application to fail during startup.

Add `@Lazy` to one of the constructor arguments to inform Spring that the component should only be created when it is actually needed.

Unblock the application and ensure it starts successfully.

## 🧪 Postman Test Cases

No specific endpoint is required.

The test case is the successful startup of the application, as shown in the Spring Boot console logs, without any errors being thrown by Tomcat.