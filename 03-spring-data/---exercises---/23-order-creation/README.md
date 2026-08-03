# 🏋️ Exercise 23 — Creating an Order on Both Sides (Avoid Empty Child Collections)

## 📝 Description

Implement a REST endpoint to create an `Order` containing multiple `OrderItems`.

You must ensure that:

- The `Order` is persisted using the appropriate cascade configuration.
- Both sides of the relationship are properly synchronized in memory (JVM) before the persistence context is flushed to the database.

---

## ⚙️ Technical Objectives

- Safely process collection-based requests.
- Ensure bidirectional relationships are synchronized in memory using helper methods in a real-world REST workflow.

---

## 📂 Required Structure

### Entities

#### `Order`

Fields:

- `id`
- `orderNumber`
- `items`

Relationship:

```java
@OneToMany(cascade = CascadeType.ALL)
```

#### `OrderItem`

Fields:

- `id`
- `productName`
- `price`
- `order`

---

### DTOs

#### `OrderRequestDTO`

Fields:

- `orderNumber`
- `items`

Where:

```text
items = List<ItemRequestDTO>
```

#### `ItemRequestDTO`

Fields:

- `productName`
- `price`

#### `OrderResponseDTO`

Fields:

- `id`
- `orderNumber`
- `totalAmount`

---

## 🎯 HTTP Route and Method

### POST `/orders`

**Response:**

```text
201 Created
```

---

## 📋 Business Rules

- Iterate through the list of `items` received in the DTO.
- Convert each item into an `OrderItem` entity.
- Add each item to the `Order` entity using an OOP-based safe helper method.

Example:

```java
order.addItem(item);
```

This method must perform:

```java
item.setOrder(order);
order.getItems().add(item);
```

This ensures that both sides of the relationship remain synchronized.

- Save the `Order`.
- Cascade persistence must automatically persist the associated `OrderItems`.
- Calculate the total amount of the `Order` either inside the Service layer or within a method of the `Order` entity itself.
- Return the calculated value in the response DTO.

---

## 🧪 Postman Test Case

### Request

**POST**

```text
http://localhost:8080/orders
```

**JSON**

```json
{
  "orderNumber": "ORD-2026-99",
  "items": [
    {
      "productName": "Book A",
      "price": 20.00
    },
    {
      "productName": "Book B",
      "price": 30.00
    }
  ]
}
```

---

### Expected Result

**Status**

```text
201 Created
```

**Response Body**

```json
{
  "id": 1,
  "orderNumber": "ORD-2026-99",
  "totalAmount": 50.00
}
```