# 🏋️ Exercise 22 — Controlled Manual Pagination (`subList`)

## 📝 Description

You must apply the manual pagination algorithm you previously created to limit the return of a large in-memory data list, safely preventing index overflow errors.

## ⚙️ Technical Objectives

- Reinforce pagination logic using `Math.min` and `subList`.
- Practice using `@RequestParam` with default values (`defaultValue`).

## 📂 Required Structure

Class:

- `LogEntry` (`id`, `message`)

**Note:** Populate your Service with a static list containing at least 12 items.

## 🎯 Routes and HTTP Methods

### GET `/logs?page=0&size=5`

## 📋 Functional Requirements

- The `page` (default `"0"`) and `size` (default `"5"`) parameters must be received in the Controller and passed to the Service.
- Calculate the `start` and `end` indexes based on the actual size of the list.
- Use `Math.min(end, list.size())` to protect the code against `IndexOutOfBoundsException`.
- Return the corresponding sublist with status **200 OK**.

## 🧪 Postman Test Cases

### First Page

```http
GET http://localhost:8080/logs?page=0&size=5
```

**Expected Result:** Returns items 1 through 5.

### Last Partial Page

```http
GET http://localhost:8080/logs?page=2&size=5
```

**Expected Result:** Returns only the remaining 2 items (items 11 and 12).

### Empty Page

```http
GET http://localhost:8080/logs?page=5&size=5
```

**Expected Result:** Returns an empty page without throwing any Java errors (**200 OK**).