# 🏋️ Exercise 09 — Partial Update with Status Validation

## 📝 Description

Simulate updating the price of a service registered in the system. If the service is found, it should be updated. Otherwise, the system must notify that the request could not be processed.

---

## ⚙️ Technical Objectives

- Reinforce the correct use of the partial update HTTP verb (`@PatchMapping`).
- Practice combining `@PathVariable` (to locate the resource) and `@RequestBody` (to receive the update data) within the same method.

---

## 📂 Required Structure

### Class: `ServiceItem`

```java
public class ServiceItem {
    private Long id;
    private String description;
    private Double price;
}
```

> **Note:** Keep a static service registered with ID `1`.

---

## 🎯 Routes and HTTP Verbs

### `PATCH /services/{id}`

---

## 📋 Business Rules

- If the `id` exists in memory:
    - Update the object's price using the value received in the request body.
    - Return the updated object with status **200 OK**.

- If the `id` does not exist:
    - Return status **400 BAD REQUEST**  
      (indicating that the request attempted to modify an invalid resource).

---

## 🧪 Postman Test Cases

### ✅ Success Case

```http
PATCH http://localhost:8080/services/1
```

### Request Body

```json
{
  "price": 150.00
}
```

### Expected Result

- Returns the updated service object
- Status: `200 OK`

---

### ❌ Failure Case

```http
PATCH http://localhost:8080/services/95
```

### Request Body

```json
{
  "price": 150.00
}
```

### Expected Result

- Empty response body
- Status: `400 BAD REQUEST`