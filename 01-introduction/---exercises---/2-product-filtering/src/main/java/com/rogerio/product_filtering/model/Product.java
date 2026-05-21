package com.rogerio.product_filtering.model;

public record Product(Long id, String name, ProductCategory category, Double price) {}
