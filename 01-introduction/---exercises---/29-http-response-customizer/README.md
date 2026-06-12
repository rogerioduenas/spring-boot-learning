# 🏋️ Exercise 29 — Batch Processing with Custom `ResponseEntity`

## 📝 Description

A bulk update API receives a list of data items. Some items may be processed successfully while others may fail. You must customize a `ResponseEntity` to return custom HTTP headers containing a summary of the operation.

## ⚙️ Technical Objectives

- Practice manually creating and manipulating HTTP response headers using the `HttpHeaders` class combined with `ResponseEntity`.

## 🎯 Routes and HTTP Methods

### POST `/batch-process`

Receives a list of strings in the request body, for example:

```json
["item1", "ERROR_item2", "item3"]
```

## 📋 Functional Requirements

- The Controller must iterate through the list of strings.
- If a string contains the word `"ERROR"`, count it as a failure; otherwise, count it as a success.
- Create an `HttpHeaders` object.
- Add the headers `X-Success-Count` and `X-Failed-Count` with their respective calculated values.
- Return:

```java
ResponseEntity.ok()
    .headers(headers)
    .body("Processed");
```

## 🧪 Postman Test Cases

Send a list of strings using Postman.

Check the **Headers** tab in the response panel (below the response body) and verify that the custom headers `X-Success-Count` and `X-Failed-Count` are present with the correct values.