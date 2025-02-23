package com.example.hexagonal.application.port.out;

import java.util.UUID;

public interface GetTotalPurchaseAmountPort {
    long getTotalPurchaseAmount(UUID userId);
}
