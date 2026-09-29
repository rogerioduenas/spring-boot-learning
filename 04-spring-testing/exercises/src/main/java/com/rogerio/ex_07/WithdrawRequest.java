package com.rogerio.ex_07;

import java.math.BigDecimal;

public record WithdrawRequest(Long accountId, BigDecimal amount) {}