package com.rogerio.ex_08;

import java.math.BigDecimal;

public record ConversionResult(
    boolean success,
    BigDecimal convertedAmount,
    BigDecimal rate
) {}
