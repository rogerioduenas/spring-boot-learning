package com.rogerio.join_column.joinColumns;

import java.io.Serializable;

public record ProductId(Long id, Integer barCode) implements Serializable {}
