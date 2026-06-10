# 🏋️ Exercise 24 — Performance Measurement with AOP (`@Around`)

## 📝 Description

Measure the exact time a heavy operation takes to complete. You will use an Aspect that wraps the method execution, calculates the elapsed time, and outputs this information to the console.

## ⚙️ Technical Objectives

- Master the use of `@Around` and flow control with `ProceedingJoinPoint`.

## 📂 Required Structure

Class:

- `ReportService` (Create a mock method that calls `Thread.sleep(1500);` to simulate a slow operation.)

Aspect Class:

- `PerformanceAspect`

## 🎯 Routes and HTTP Methods

### GET `/reports/heavy`

## 📋 Functional Requirements

- The `@Around` Aspect must monitor the heavy method in `ReportService`.
- Capture the current time in milliseconds before calling `.proceed()`.
- Call `.proceed()`, capture the end time, and print the elapsed time to the console.

Example:

```text
Method X took 1502ms to execute
```

## 🧪 Postman Test Cases

When calling the endpoint, Postman should take approximately 1.5 seconds to receive a response.

Verify that the performance log correctly measures and displays the execution time in the console.