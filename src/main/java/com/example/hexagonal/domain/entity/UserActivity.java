package com.example.hexagonal.domain.entity;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@With
@Value
public class UserActivity {
    UUID userId;
    long purchaseAmount;
    OffsetDateTime createdAt;
}
